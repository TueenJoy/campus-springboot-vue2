package com.workmexh.common.commonDomain;
// 普通实体类 邮箱专用
public class mailJson {
    private String userMobile;
    private String nums;
    private String userAcc;

    @Override
    public String toString() {
        return "mailJson{" +
                "userMobile='" + userMobile + '\'' +
                ", nums='" + nums + '\'' +
                ", userAcc='" + userAcc + '\'' +
                '}';
    }

    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc;
    }

    public mailJson(String userMobile, String nums, String userAcc) {
        this.userMobile = userMobile;
        this.nums = nums;
        this.userAcc = userAcc;
    }

    public mailJson(String userMobile, String nums) {
        this.userMobile = userMobile;
        this.nums = nums;
    }
    public mailJson() {

    }
    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

}
