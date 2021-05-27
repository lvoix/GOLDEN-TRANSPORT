package com.golden.transport.rest;

import java.util.*;
import java.util.stream.Collectors;

import com.golden.transport.message.ResponseMessage;
import com.golden.transport.service.FilesStorageService;
import com.golden.transport.service.dto.FileInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import javax.validation.Valid;



@Controller
public class FilesResource {

  @Autowired
  FilesStorageService storageService;

  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFiles(@Valid FileInfoDTO fileInfoDTO, @RequestParam("file") MultipartFile[] files) {
    String message = "";
    try {
      List<String> fileNames = new ArrayList<>();
      List<MultipartFile> filess = Arrays.asList(files);

      Arrays.asList(files).stream().forEach(file -> {
        FileInfoDTO filesinfos = storageService.attachFileWithEntity(fileInfoDTO, file);
        storageService.save(file, filesinfos.getEntityId());
        fileNames.add(file.getOriginalFilename());
      });

      message = "Uploaded the files successfully: " + fileNames + files + fileInfoDTO;
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Fail to upload files!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @GetMapping("/files")
  public ResponseEntity<List<FileInfoDTO>> getListFiles() {
    List<FileInfoDTO> fileInfos = storageService.loadAll().map(path -> {
      String filename = path.getFileName().toString();
      String url = MvcUriComponentsBuilder
          .fromMethodName(FilesResource.class, "getFile", path.getFileName().toString()).build().toString();

      return new FileInfoDTO(filename, url);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<List<FileInfoDTO>> getListFilesbyID(@PathVariable long id) {
    Page<FileInfoDTO> fileInfos = storageService.loadAllByID(id);
    List<FileInfoDTO> listOfOptionals = fileInfos.getContent();
    return ResponseEntity.status(HttpStatus.OK).body(listOfOptionals);
  }

  @GetMapping("/files/name/{filename:.+}")
  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    Resource file = storageService.load(filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }
}
