package com.hdw.springboot.entity;
import java.sql.Date;

public class UploadInfo {
    private static final long serialVersionUID = 2L;
    private int project_id;
    private String project_name;
    private String package_name;
    private String class_name;
    private String method_name;
    private Date insert_date;

    public int getProject_id() {
        return project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getPackage_name() {
        return package_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getMethod_name() {
        return method_name;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }

}
