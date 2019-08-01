package com.education.bean;

import java.util.Date;

public class Order {
    private Integer oid;

    private Date starttime;

    private Date endtime;

    private String classaddress;

    private String content;

    private Double price;

    private String remark;

    private Integer teacherid;

    private Integer studentid;

    private String studentevaluate;

    private String teacherevaluate;

    private Integer orderstatic;

    private Integer ordertype;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getClassaddress() {
        return classaddress;
    }

    public void setClassaddress(String classaddress) {
        this.classaddress = classaddress == null ? null : classaddress.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentevaluate() {
        return studentevaluate;
    }

    public void setStudentevaluate(String studentevaluate) {
        this.studentevaluate = studentevaluate == null ? null : studentevaluate.trim();
    }

    public String getTeacherevaluate() {
        return teacherevaluate;
    }

    public void setTeacherevaluate(String teacherevaluate) {
        this.teacherevaluate = teacherevaluate == null ? null : teacherevaluate.trim();
    }

    public Integer getOrderstatic() {
        return orderstatic;
    }

    public void setOrderstatic(Integer orderstatic) {
        this.orderstatic = orderstatic;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }
}