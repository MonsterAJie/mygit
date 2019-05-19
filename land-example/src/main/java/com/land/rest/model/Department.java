package com.land.rest.model;

import java.util.Date;

public class Department {
    private Integer deptId;

    private String deptName;

    private Date established;

    private Integer empCount;

    private Integer coId;

    private Date makeDate;

    private String makeBy;

    private Date updateDate;

    private String updateBy;

    private String spare1;

    private String spare2;

    private String spare3;

    private String spare4;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Date getEstablished() {
        return established;
    }

    public void setEstablished(Date established) {
        this.established = established;
    }

    public Integer getEmpCount() {
        return empCount;
    }

    public void setEmpCount(Integer empCount) {
        this.empCount = empCount;
    }

    public Integer getCoId() {
        return coId;
    }

    public void setCoId(Integer coId) {
        this.coId = coId;
    }

    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    public String getMakeBy() {
        return makeBy;
    }

    public void setMakeBy(String makeBy) {
        this.makeBy = makeBy == null ? null : makeBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1 == null ? null : spare1.trim();
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2 == null ? null : spare2.trim();
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3 == null ? null : spare3.trim();
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4 == null ? null : spare4.trim();
    }
}