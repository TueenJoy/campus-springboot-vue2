package com.workmexh.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

public class Regiact {
    private Integer regiId;
    private String regiTitle;
    private String regiAuthor;
    private String regiContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp regiStarttime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp regiOvertime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp regiDatetime;
    private String regiImg;
    private Integer regiNumber;
    private Integer regiMaxnum;
    private Integer regiAlnum;
    public Regiact() {

    }
//    public Regiact(Integer regiId, String regiTitle, String regiAuthor, String regiContent, Timestamp regiStarttime, Timestamp regiOvertime, String regiImg, Integer regiNumber, Integer regiMaxnum, Integer regiAlnum) {
//        this.regiId = regiId;
//        this.regiTitle = regiTitle;
//        this.regiAuthor = regiAuthor;
//        this.regiContent = regiContent;
//        this.regiStarttime = regiStarttime;
//        this.regiOvertime = regiOvertime;
//        this.regiImg = regiImg;
//        this.regiNumber = regiNumber;
//        this.regiMaxnum = regiMaxnum;
//        this.regiAlnum = regiAlnum;
//    }
//
//    public Regiact(String regiTitle, String regiAuthor,Timestamp regiStarttime, Timestamp regiOvertime, String regiContent, String regiImg, Integer regiNumber, Integer regiMaxnum, Integer regiAlnum) {
//        this.regiTitle = regiTitle;
//        this.regiAuthor = regiAuthor;
//        this.regiContent = regiContent;
//        this.regiStarttime = regiStarttime;
//        this.regiOvertime = regiOvertime;
//        this.regiImg = regiImg;
//        this.regiNumber = regiNumber;
//        this.regiMaxnum = regiMaxnum;
//        this.regiAlnum = regiAlnum;
//    }



    @Override
    public String toString() {
        return "Regiact{" +
                "regiId=" + regiId +
                ", regiTitle='" + regiTitle + '\'' +
                ", regiAuthor='" + regiAuthor + '\'' +
                ", regiContent='" + regiContent + '\'' +
                ", regiStarttime=" + regiStarttime +
                ", regiOvertime=" + regiOvertime +
                ", regiDatetime=" + regiDatetime +
                ", regiImg='" + regiImg + '\'' +
                ", regiNumber=" + regiNumber +
                ", regiMaxnum=" + regiMaxnum +
                ", regiAlnum=" + regiAlnum +
                '}';
    }

    public Timestamp getRegiDatetime() {
        return regiDatetime;
    }

    public void setRegiDatetime(Timestamp regiDatetime) {
        this.regiDatetime = regiDatetime;
    }

    public Regiact(Integer regiId, String regiTitle, String regiAuthor, String regiContent, Timestamp regiStarttime, Timestamp regiOvertime, Timestamp regiDatetime, String regiImg, Integer regiNumber, Integer regiMaxnum, Integer regiAlnum) {
        this.regiId = regiId;
        this.regiTitle = regiTitle;
        this.regiAuthor = regiAuthor;
        this.regiContent = regiContent;
        this.regiStarttime = regiStarttime;
        this.regiOvertime = regiOvertime;
        this.regiDatetime = regiDatetime;
        this.regiImg = regiImg;
        this.regiNumber = regiNumber;
        this.regiMaxnum = regiMaxnum;
        this.regiAlnum = regiAlnum;
    }

    public Regiact(String regiTitle, String regiAuthor, String regiContent, Timestamp regiStarttime, Timestamp regiOvertime, Timestamp regiDatetime, String regiImg, Integer regiNumber, Integer regiMaxnum, Integer regiAlnum) {
        this.regiTitle = regiTitle;
        this.regiAuthor = regiAuthor;
        this.regiContent = regiContent;
        this.regiStarttime = regiStarttime;
        this.regiOvertime = regiOvertime;
        this.regiDatetime = regiDatetime;
        this.regiImg = regiImg;
        this.regiNumber = regiNumber;
        this.regiMaxnum = regiMaxnum;
        this.regiAlnum = regiAlnum;
    }

    public Integer getRegiId() {
        return regiId;
    }

    public void setRegiId(Integer regiId) {
        this.regiId = regiId;
    }

    public String getRegiTitle() {
        return regiTitle;
    }

    public void setRegiTitle(String regiTitle) {
        this.regiTitle = regiTitle;
    }

    public String getRegiAuthor() {
        return regiAuthor;
    }

    public void setRegiAuthor(String regiAuthor) {
        this.regiAuthor = regiAuthor;
    }

    public String getRegiContent() {
        return regiContent;
    }

    public void setRegiContent(String regiContent) {
        this.regiContent = regiContent;
    }

    public Timestamp getRegiStarttime() {
        return regiStarttime;
    }

    public void setRegiStarttime(Timestamp regiStarttime) {
        this.regiStarttime = regiStarttime;
    }

    public Timestamp getRegiOvertime() {
        return regiOvertime;
    }

    public void setRegiOvertime(Timestamp regiOvertime) {
        this.regiOvertime = regiOvertime;
    }

    public String getRegiImg() {
        return regiImg;
    }

    public void setRegiImg(String regiImg) {
        this.regiImg = regiImg;
    }

    public Integer getRegiNumber() {
        return regiNumber;
    }

    public void setRegiNumber(Integer regiNumber) {
        this.regiNumber = regiNumber;
    }

    public Integer getRegiMaxnum() {
        return regiMaxnum;
    }

    public void setRegiMaxnum(Integer regiMaxnum) {
        this.regiMaxnum = regiMaxnum;
    }

    public Integer getRegiAlnum() {
        return regiAlnum;
    }

    public void setRegiAlnum(Integer regiAlnum) {
        this.regiAlnum = regiAlnum;
    }

}
