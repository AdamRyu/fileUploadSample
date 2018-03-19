package com.fileuploadsample.demo.model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileInfoRepository extends CrudRepository<FileInfo, Long> {

    //get meta-data by id
    FileInfo findById(long id);

    //get file meta-data by file type
    List<FileInfo> findByType(String fileType);
}
