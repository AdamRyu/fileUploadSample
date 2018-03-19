package com.fileuploadsample.demo.model;

import javax.persistence.*;
import javax.xml.soap.Name;
import java.util.Date;

@Entity
@Table(name = "FILE_INFO")
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "nameForUser")
    private String nameForUser;
    @Column(name = "nameForServer")
    private String nameForServer;
    @Column(name = "path")
    private String path;
    @Column(name = "type")
    private String type;
    @Column(name = "size")
    private double size;
    @Column(name = "timeStamp")
    private Date timeStamp;

    public FileInfo() {
    }

    public FileInfo(String nameForUser) {
        this.nameForUser = nameForUser;
    }

    public long getId() {
        return id;
    }

    public String getNameForUser() {
        return nameForUser;
    }

    public String getNameForServer() {
        return nameForServer;
    }

    public String getPath() {
        return path;
    }

    public String getType() {
        return type;
    }

    public double getSize() {
        return size;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setNameForUser(String nameForUser) {
        this.nameForUser = nameForUser;
    }

    public void setNameForServer(String nameForServer) {
        this.nameForServer = nameForServer;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFileType(String type) {
        this.type = type;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", nameForUser='" + nameForUser + '\'' +
                ", nameForServer='" + nameForServer + '\'' +
                ", path='" + path + '\'' +
                ", fileType='" + type + '\'' +
                ", size=" + size +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
