package com.golden.transport.service;

import java.nio.file.Path;
import java.util.stream.Stream;
import com.golden.transport.service.dto.FileInfoDTO;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
  public void init();

  public void initDirectory(Long operation);

  public void save(MultipartFile file, Long operation);

  public Resource load(String filename);

  public void deleteAll();

  public FileInfoDTO attachFileWithEntity(FileInfoDTO fileEdit, MultipartFile file);

  public Stream<Path> loadAll();

  public Page<FileInfoDTO> loadAllByID(Long id);

}
