package com.fileuploadsample.demo.controller;

import com.fileuploadsample.demo.model.FileInfo;
import com.fileuploadsample.demo.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/file")
public class UploadController {

    private UploadFileService uploadFileService;

    @Autowired
    public UploadController(UploadFileService uploadFileService){
        this.uploadFileService = uploadFileService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }

    //upload a file:
    //      save meta-data into embedded DB H2
    //      save the file in file system on a file system
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public FileInfo uploadFile(
            @RequestParam("uploadFile") MultipartFile file) throws IOException{

        FileInfo fileInfo = uploadFileService.uploadFile(file);

        return fileInfo;

    }

    //get a certain file meta-data
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public FileInfo getFileMetaData(@PathVariable("id") long id) throws Exception{
        FileInfo fileInfo = uploadFileService.getFileInfo(id);
        if(fileInfo == null){
            throw new FileNotFoundException( "File doestn't exist! FileID = " + id);
        }
        return fileInfo;
    }

    //get all files meta-data
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<FileInfo> getAllFilesMetaData() throws Exception{
        List<FileInfo> list = uploadFileService.getAllFilesInfo();
        if(list == null){
            throw new FileNotFoundException("No File!");
        }
        return list;
    }

    //search file by file's extension name
    @RequestMapping(value = "/search/{type}", method = RequestMethod.GET)
    public List<FileInfo> searchFile(@PathVariable String type) throws Exception{
        List<FileInfo> list = uploadFileService.getFilesInfoByType(type);
        if(list == null || list.size() == 0){
            throw new FileNotFoundException("File doesn't exist");
        }
        return list;
    }
}
