package cn.kgc.hibernate.entity;

import java.util.Date;


public class User {
    private Integer id;      //id
    private String userName;  //用户名字
    private String password;   //密码
    private Date createDate;   //创造日期

    public User() {
    }

    public User(String userName, String password, Date createDate) {
        this.userName = userName;
        this.password = password;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
