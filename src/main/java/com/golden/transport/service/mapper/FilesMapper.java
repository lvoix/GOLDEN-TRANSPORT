package com.golden.transport.service.mapper;


import com.golden.transport.domain.File;
import com.golden.transport.service.dto.FileInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 */
@Mapper(componentModel = "spring", uses = {})
public interface FilesMapper extends EntityMapper<FileInfoDTO, File> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "path", target = "path")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "size", target = "size")
    @Mapping(source = "extention", target = "extention")
    FileInfoDTO toDto(File file);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "path", target = "path")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "size", target = "size")
    @Mapping(source = "extention", target = "extention")
    File toEntity(FileInfoDTO fileInfoDTO);

    default File fromId(Long id) {
        if (id == null) {
            return null;
        }
        File file = new File();
        file.setId(id);
        return file;
    }
}
