package com.fileuploadsample.demo.service;

import com.fileuploadsample.demo.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UploadFileService {

    //save file
    FileInfo uploadFile(MultipartFile file) throws IOException;

    //get meta-data info by id
    FileInfo getFileInfo(long id);

    //get meta-data all files info
    List<FileInfo> getAllFilesInfo();

    //get meta-data by type
    List<FileInfo> getFilesInfoByType(String type);
}
