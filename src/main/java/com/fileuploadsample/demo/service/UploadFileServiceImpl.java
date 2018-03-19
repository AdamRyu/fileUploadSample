package com.fileuploadsample.demo.service;

import com.fileuploadsample.demo.model.FileInfo;
import com.fileuploadsample.demo.model.FileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UploadFileServiceImpl implements UploadFileService{

    private final FileInfoRepository fileInfoRepository;

    @Value("${upload.path}")
    private String UPLOAD_PATH;

    @Autowired
    public UploadFileServiceImpl(FileInfoRepository fileInfoRepository) {
        this.fileInfoRepository = fileInfoRepository;
    }

    //save file
    @Override
    public FileInfo uploadFile(MultipartFile multipartFile) throws IOException{
        //check whether file is empty
        if(multipartFile.isEmpty()){
            throw new UnsupportedEncodingException("Upload failed! The file can not be empty!");
        }

        FileInfo fileInfo = null;
        try {
            //for security reason, convert file name to certain format "yyyyMMddHHmmss"
            String serverFileName = new SimpleDateFormat("yyyyMMddHHmmss'.txt'").format(new Date());

            //get file's extension name
            String fileType = multipartFile.getOriginalFilename()
                                    .substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1);


            //location of the file on server
            String path = new StringBuilder(UPLOAD_PATH)
                    .append(serverFileName)
                    .toString();

            //upload file
            InputStream inputStream = multipartFile.getInputStream();
            File savedFile = new File(path);
            OutputStream outputStream = new FileOutputStream(savedFile);

            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, read);
            }

            //save meta-data into DB
            fileInfo = new FileInfo(multipartFile.getOriginalFilename());
            fileInfo.setPath(path);
            fileInfo.setFileType(fileType);
            fileInfo.setNameForServer(serverFileName);
            fileInfo.setTimeStamp(new Date());

            fileInfoRepository.save(fileInfo);

        }catch (IOException e){
            throw new FileNotFoundException(e.toString());
        }

        return fileInfo;
    }

    //get meta-data info by id
    @Override
    public FileInfo getFileInfo(long id){
        return fileInfoRepository.findById(id);
    };

    //get meta-data all files info
    @Override
    public List<FileInfo> getAllFilesInfo(){
        List<FileInfo> list = new ArrayList<>();

        Iterator<FileInfo> iterator = fileInfoRepository.findAll().iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }

        return list;
    };

    //get meta-data by type
    @Override
    public List<FileInfo> getFilesInfoByType(String type){
        List<FileInfo> list = new ArrayList<>();

        list = fileInfoRepository.findByType(type);

        return list;
    };
}
