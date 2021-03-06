package com.spring.boot.springbootdemo.model;

import java.util.Date;

public class TUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.LoginID
     *
     * @mbg.generated
     */
    private String loginID;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.PassWord
     *
     * @mbg.generated
     */
    private String passWord;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.LastName
     *
     * @mbg.generated
     */
    private String lastName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.Status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.SignPath
     *
     * @mbg.generated
     */
    private String signPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.creator
     *
     * @mbg.generated
     */
    private Integer creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.createTime
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.updateUser
     *
     * @mbg.generated
     */
    private Integer updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.updateTime
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.LoginID
     *
     * @return the value of t_user.LoginID
     *
     * @mbg.generated
     */
    public String getLoginID() {
        return loginID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.LoginID
     *
     * @param loginID the value for t_user.LoginID
     *
     * @mbg.generated
     */
    public void setLoginID(String loginID) {
        this.loginID = loginID == null ? null : loginID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.PassWord
     *
     * @return the value of t_user.PassWord
     *
     * @mbg.generated
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.PassWord
     *
     * @param passWord the value for t_user.PassWord
     *
     * @mbg.generated
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.LastName
     *
     * @return the value of t_user.LastName
     *
     * @mbg.generated
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.LastName
     *
     * @param lastName the value for t_user.LastName
     *
     * @mbg.generated
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.Status
     *
     * @return the value of t_user.Status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.Status
     *
     * @param status the value for t_user.Status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.SignPath
     *
     * @return the value of t_user.SignPath
     *
     * @mbg.generated
     */
    public String getSignPath() {
        return signPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.SignPath
     *
     * @param signPath the value for t_user.SignPath
     *
     * @mbg.generated
     */
    public void setSignPath(String signPath) {
        this.signPath = signPath == null ? null : signPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.phone
     *
     * @return the value of t_user.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.phone
     *
     * @param phone the value for t_user.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.address
     *
     * @return the value of t_user.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.address
     *
     * @param address the value for t_user.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.creator
     *
     * @return the value of t_user.creator
     *
     * @mbg.generated
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.creator
     *
     * @param creator the value for t_user.creator
     *
     * @mbg.generated
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.createTime
     *
     * @return the value of t_user.createTime
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.createTime
     *
     * @param createTime the value for t_user.createTime
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.updateUser
     *
     * @return the value of t_user.updateUser
     *
     * @mbg.generated
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.updateUser
     *
     * @param updateUser the value for t_user.updateUser
     *
     * @mbg.generated
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.updateTime
     *
     * @return the value of t_user.updateTime
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.updateTime
     *
     * @param updateTime the value for t_user.updateTime
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}