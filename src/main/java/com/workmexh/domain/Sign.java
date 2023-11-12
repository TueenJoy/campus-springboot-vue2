package com.workmexh.domain;

public class Sign {
    private Integer signId;
    private String signTitle;
    private Integer signNumber;
    private String signUser;
    public String signUname;



    public Sign(Integer signId, String signTitle, Integer signNumber, String signUser, String signUname) {
        this.signId = signId;
        this.signTitle = signTitle;
        this.signNumber = signNumber;
        this.signUser = signUser;
        this.signUname = signUname;
    }

    public Sign(String signTitle, Integer signNumber, String signUser, String signUname) {

        this.signTitle = signTitle;
        this.signNumber = signNumber;
        this.signUser = signUser;
        this.signUname = signUname;
    }


    public Sign() {

    }
    public String getSignUname() {
        return signUname;
    }

    public void setSignUname(String signUname) {
        this.signUname = signUname;
    }
    public Integer getSignId() {
        return signId;
    }

    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    public String getSignTitle() {
        return signTitle;
    }

    public void setSignTitle(String signTitle) {
        this.signTitle = signTitle;
    }

    public Integer getSignNumber() {
        return signNumber;
    }

    public void setSignNumber(Integer signNumber) {
        this.signNumber = signNumber;
    }

    public String getSignUser() {
        return signUser;
    }

    public void setSignUser(String signUser) {
        this.signUser = signUser;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "signId=" + signId +
                ", signTitle='" + signTitle + '\'' +
                ", signNumber=" + signNumber +
                ", signUser='" + signUser + '\'' +
                ", signUname='" + signUname + '\'' +
                '}';
    }
}
