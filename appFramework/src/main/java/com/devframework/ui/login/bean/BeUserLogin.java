package com.devframework.ui.login.bean;

/**
 * @作者 ZAMAJIN
 * @时间 2018/12/6 13:58
 * @描述 解析登录
 */
public class BeUserLogin {
    /**
     * {"code":0,"count":0,"msg":"登录成功!","data":{"departmentId":"11010100002159638142","departmentName":"研发部门","id":"11010100003009782405","name":"mj001","sessionId":"DE734AC4817489CFC9B125A61CF82633:BEEBBE51B13C6697F9EAEEFC98275CE2","nickName":"mj001","phone":"","subDeviceId":"11010100001311462980","deviceId":"11010100003621069543","pullStreamPath":"192.168.4.230:556","ptzControl":"192.168.4.230:3011","pushStreamPath":"192.168.4.230:554","naming":"11010100001311462980:11010100003621069543:192.168.4.230:1101010000"}}
     *
     * <p>
     * departmentName : 测试2
     * phone :
     * nickName : 用户1
     * pushStreamPath : http://ip:port
     * departmentId : 12010100002153549620
     * name : zaws
     * pullStreamPath : http://ip:port
     * id : 10000000003002906547
     * sessionId : DAC37BE6AB5AE4B20878539C3CACE45A
     * deviceId : DV123456789
     */

    private String departmentName;
    private String phone;
    private String nickName;
    private String pushStreamPath;
    private String departmentId;
    private String name;
    private String pullStreamPath;
    private String id;
    private String sessionId;
    private String deviceId;//推流时用
    private String subDeviceId;//设备ID （显示手机时用）
    private String ptzControl;//控制云台
    private String naming;
    private String onlineUrl;

    public String getDepartmentName() {
        return departmentName == null ? "" : departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPhone() {
        return phone == null ? "" : phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName == null ? "" : nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPushStreamPath() {
        return pushStreamPath == null ? "" : pushStreamPath;
    }

    public void setPushStreamPath(String pushStreamPath) {
        this.pushStreamPath = pushStreamPath;
    }

    public String getDepartmentId() {
        return departmentId == null ? "" : departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPullStreamPath() {
        return pullStreamPath == null ? "" : pullStreamPath;
    }

    public void setPullStreamPath(String pullStreamPath) {
        this.pullStreamPath = pullStreamPath;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId == null ? "" : sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDeviceId() {
        return deviceId == null ? "" : deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSubDeviceId() {
        return subDeviceId == null ? "" : subDeviceId;
    }

    public void setSubDeviceId(String subDeviceId) {
        this.subDeviceId = subDeviceId;
    }

    public String getPtzControl() {
        return ptzControl == null ? "" : ptzControl;
    }

    public String getNaming() {
        return naming == null ? "" : naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public String getOnlineUrl() {
        return onlineUrl == null ? "" : onlineUrl;
    }

    public void setOnlineUrl(String onlineUrl) {
        this.onlineUrl = onlineUrl;
    }

    @Override
    public String toString() {
        return "BeUserLogin{" +
                "departmentName='" + departmentName + '\'' +
                ", phone='" + phone + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pushStreamPath='" + pushStreamPath + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", name='" + name + '\'' +
                ", pullStreamPath='" + pullStreamPath + '\'' +
                ", id='" + id + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", subDeviceId='" + subDeviceId + '\'' +
                ", ptzControl='" + ptzControl + '\'' +
                ", naming='" + naming + '\'' +
                ", onlineUrl='" + onlineUrl + '\'' +
                '}';
    }
}
