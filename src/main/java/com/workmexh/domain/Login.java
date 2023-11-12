package com.workmexh.domain;

public class Login {
    private String userAcc;
    private String userPassword;
    private String userName;
    private String userMobile;


    public Login(String userAcc, String userPassword, String userName) {
        this.userAcc = userAcc;
        this.userPassword = userPassword;
        this.userName = userName;

    }

    @Override
    public String toString() {
        return "Login{" +
                "userAcc='" + userAcc + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userMobile=" + userMobile +
                '}';
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Login(String userAcc, String userPassword, String userName, String userMobile) {
        this.userAcc = userAcc;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userMobile = userMobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Login(String userAcc, String userPassword) {
        this.userAcc = userAcc;
        this.userPassword = userPassword;
    }

    public Login() {

    }

}
