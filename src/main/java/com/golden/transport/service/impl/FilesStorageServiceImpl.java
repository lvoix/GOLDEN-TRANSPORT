package com.golden.transport.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.golden.transport.domain.File;
import com.golden.transport.repository.FileRepository;
import com.golden.transport.service.FilesStorageService;
import com.golden.transport.service.dto.FileInfoDTO;
import com.golden.transport.service.mapper.FilesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class FilesStorageServiceImpl implements FilesStorageService {

  @Autowired
  FileRepository fileRepository;

  @Autowired
  FilesMapper filesMapper;

  private final Path root = Paths.get("uploads");

  private Path rootOperation = Paths.get(String.valueOf(root));
 /* @Value("${morservs.archive.files.dir}")
  protected  String path;*/



/*  @Autowired(required = true)
  public FilesStorageServiceImpl(FileRepository fileRepository) {
    //this.fileRepository = fileRepository;

  }*/
  @Override
  public void init() {
    try {
      Files.createDirectory(root);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }
  @Override
  public void initDirectory(Long operation) {
    try {
      Files.createDirectory(Paths.get(root + "/" + operation));
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }

  @Override
  public void save(MultipartFile file,Long operation) {
    this.rootOperation = Paths.get(this.root + "/" + operation);
    String directoryName = String.valueOf(this.rootOperation);
    java.io.File directory = new java.io.File(directoryName);

    if (! directory.exists()){
          initDirectory(operation);
    }
    try {
      Files.copy(file.getInputStream(), this.rootOperation.resolve(file.getOriginalFilename()));
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  protected String generateSignatureFile(String name,Long entityId) {
    return root + "/" +entityId+ "/"+ new java.util.Date().getTime() + "_" +
            entityId+ "_" +name;
  }

  @Override
  public Resource load(String filename) {
    try {
      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public FileInfoDTO attachFileWithEntity(FileInfoDTO fileINFOS, MultipartFile file) {
    //logger.debug("start create Document service");
/*    if(fileINFOS==null){
      logger.warn("The file Edit Object is null");
      throw EXCEPTIONFACTORY.createArchiveExeption(ExceptionEnum.NULLPRAM,"The Picture Object is null");
    }*/
   // File fileEntity=new File();
    File fileEntity = filesMapper.toEntity(fileINFOS);

    fileEntity.setEntityType(fileINFOS.getEntityType());
    fileEntity.setEntityId(fileINFOS.getEntityId());
    String generatedPath=generateSignatureFile(file.getOriginalFilename(),fileINFOS.getEntityId());
    fileEntity.setPath(generatedPath);
    fileEntity.setUrl(generatedPath);
    fileEntity.setName(file.getOriginalFilename());
    fileEntity.setExtention(fileINFOS.getExtention());
    fileEntity.setSize(fileINFOS.getSize());

    //fileEntity.setName(file.getOriginalFilename());
    //deletePictures(pictureRepository.findByEntityIdAndEntityType(picture.getEntityId(),pictureEntity.getEntityType()));
    fileEntity=fileRepository.save(fileEntity);
    if(fileEntity==null){
     // logger.warn("The file entity is null");
    }
    return filesMapper.toDto(fileEntity);
  }


  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }

  @Override
  public Page <FileInfoDTO> loadAllByID(Long entityId) {
    Pageable pageable = PageRequest.of(0, 20);
    Page<File> ls = fileRepository.findByEntityId(entityId, pageable);
    return fileRepository.findByEntityId(entityId, pageable).map(filesMapper ::toDto);
  }

}
