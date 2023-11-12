package com.workmexh.domain;
// 用户Users的实体类 根据数据库的结构创建即可

public class User {

    private Integer userId;
    private String userName;
    private String userAcc;
    private Integer userAge;
    private String userGender;
    private String userPassword;
    private String userMobile;
    private String userEmail;
    private String userImage;
    private Integer userStatus;
    private String userPermission;

    public User(Integer userId, String userName, String userAcc, Integer userAge, String userGender, String userPassword, String userMobile, String userEmail, String userImage, Integer userStatus, String userPermission) {
        this.userId = userId;
        this.userName = userName;
        this.userAcc = userAcc;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userPassword = userPassword;
        this.userMobile = userMobile;
        this.userEmail = userEmail;
        this.userImage = userImage;
        this.userStatus = userStatus;
        this.userPermission = userPermission;
    }

    public User(Integer userId, String userName,String userAcc, String userPassword) {
        this.userId = userId;
        this.userName=userName;
        this.userAcc = userAcc;
        this.userPassword = userPassword;
    }
    public User(String userAcc){
        this.userAcc=userAcc;
    }
    public User(String userAcc,String userName){
        this.userAcc=userAcc;
        this.userName=userName;

    }

    public User(Integer userAcc, String userPassword) {
        this.userId = userAcc;
        this.userPassword = userPassword;
    }

    public User(){}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAcc='" + userAcc + '\'' +
                ", userAge=" + userAge +
                ", userGender='" + userGender + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userMobile=" + userMobile +
                ", userEmail='" + userEmail + '\'' +
                ", userImage='" + userImage + '\'' +
                ", userStatus=" + userStatus +
                ", userPermission='" + userPermission + '\'' +
                '}';
    }
}
