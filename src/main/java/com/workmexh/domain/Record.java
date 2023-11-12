package com.workmexh.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Record {
    private Integer recId;
    private String recTitle;
    private Integer recNumber;
    private String recUseracc;
    public Record(String recTitle, Integer recNumber, String recUseracc) {

        this.recTitle = recTitle;
        this.recNumber = recNumber;
        this.recUseracc = recUseracc;
    }
    public Record(Integer recId, String recTitle, Integer recNumber, String recUseracc) {
        this.recId = recId;
        this.recTitle = recTitle;
        this.recNumber = recNumber;
        this.recUseracc = recUseracc;
    }

    public Record() {

    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getRecTitle() {
        return recTitle;
    }

    public void setRecTitle(String recTitle) {
        this.recTitle = recTitle;
    }

    public Integer getRecNumber() {
        return recNumber;
    }

    public void setRecNumber(Integer recNumber) {
        this.recNumber = recNumber;
    }

    public String getRecUseracc() {
        return recUseracc;
    }

    public void setRecUseracc(String recUseracc) {
        this.recUseracc = recUseracc;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recId=" + recId +
                ", recTitle='" + recTitle + '\'' +
                ", recNumber=" + recNumber +
                ", recUseracc='" + recUseracc + '\'' +
                '}';
    }
}
