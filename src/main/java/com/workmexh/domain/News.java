package com.workmexh.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class News {
    private Integer listId;
    private String listTitle;
    private String listAuthor;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp listDatetime;
    private Integer listNumber;
    private String listContent;
    private String listImg;
    private Integer listType;

    public News(Integer listId, String listTitle, String listAuthor, Timestamp listDatetime, Integer listNumber, String listContent, String listImg, Integer listType) {
        this.listId = listId;
        this.listTitle = listTitle;
        this.listAuthor = listAuthor;
        this.listDatetime = listDatetime;
        this.listNumber = listNumber;
        this.listContent = listContent;
        this.listImg = listImg;
        this.listType = listType;
    }

    public News(String listTitle, String listAuthor, Timestamp listDatetime, Integer listNumber, String listContent, String listImg, Integer listType) {
        this.listTitle = listTitle;
        this.listAuthor = listAuthor;
        this.listDatetime = listDatetime;
        this.listNumber = listNumber;
        this.listContent = listContent;
        this.listImg = listImg;
        this.listType = listType;
    }

    public News() {

    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public String getListAuthor() {
        return listAuthor;
    }

    public void setListAuthor(String listAuthor) {
        this.listAuthor = listAuthor;
    }

    public Timestamp getListDatetime() {
        return listDatetime;
    }

    public void setListDatetime(Timestamp listDatetime) {
        this.listDatetime = listDatetime;
    }

    public String getListContent() {
        return listContent;
    }

    public void setListContent(String listContent) {
        this.listContent = listContent;
    }

    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public Integer getListNumber() {
        return listNumber;
    }

    public void setListNumber(Integer listNumber) {
        this.listNumber = listNumber;
    }

    @Override
    public String toString() {
        return "News{" +
                "listId=" + listId +
                ", listTitle='" + listTitle + '\'' +
                ", listAuthor=" + listAuthor +
                ", listDatetime=" + listDatetime +
                ", listNumber=" + listNumber +
                ", listContent='" + listContent + '\'' +
                ", listImg='" + listImg + '\'' +
                ", listType='" + listType + '\'' +
                '}';
    }
}
