package com.land.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Integer value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Integer value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Integer> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Integer> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andMgrIdIsNull() {
            addCriterion("mgr_id is null");
            return (Criteria) this;
        }

        public Criteria andMgrIdIsNotNull() {
            addCriterion("mgr_id is not null");
            return (Criteria) this;
        }

        public Criteria andMgrIdEqualTo(Integer value) {
            addCriterion("mgr_id =", value, "mgrId");
            return (Criteria) this;
        }

        public Criteria andMgrIdNotEqualTo(Integer value) {
            addCriterion("mgr_id <>", value, "mgrId");
            return (Criteria) this;
        }

        public Criteria andMgrIdGreaterThan(Integer value) {
            addCriterion("mgr_id >", value, "mgrId");
            return (Criteria) this;
        }

        public Criteria andMgrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mgr_id >=", value, "mgrId");
            return (Criteria) this;
        }

        public Criteria andMgrIdLessThan(Integer value) {
            addCriterion("mgr_id <", value, "mgrId");
            return (Criteria) this;
        }

        public Criteria andMgrIdLessThanOrEqualTo(Integer value) {
            addCriterion("mgr_id <=", value, "mgrId");
            return (Criteria) this;
        }

        public Criteria andMgrIdIn(List<Integer> values) {
            addCriterion("mgr_id in", values, "mgrId");
            return (Criteria) this;
        }

        public Criteria andMgrIdNotIn(List<Integer> values) {
            addCriterion("mgr_id not in", values, "mgrId");
            return (Criteria) this;
        }

        public Criteria andMgrIdBetween(Integer value1, Integer value2) {
            addCriterion("mgr_id between", value1, value2, "mgrId");
            return (Criteria) this;
        }

        public Criteria andMgrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mgr_id not between", value1, value2, "mgrId");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNull() {
            addCriterion("permission is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNotNull() {
            addCriterion("permission is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionEqualTo(String value) {
            addCriterion("permission =", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotEqualTo(String value) {
            addCriterion("permission <>", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThan(String value) {
            addCriterion("permission >", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("permission >=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThan(String value) {
            addCriterion("permission <", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThanOrEqualTo(String value) {
            addCriterion("permission <=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLike(String value) {
            addCriterion("permission like", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotLike(String value) {
            addCriterion("permission not like", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionIn(List<String> values) {
            addCriterion("permission in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotIn(List<String> values) {
            addCriterion("permission not in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionBetween(String value1, String value2) {
            addCriterion("permission between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotBetween(String value1, String value2) {
            addCriterion("permission not between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andHireDateIsNull() {
            addCriterion("hire_date is null");
            return (Criteria) this;
        }

        public Criteria andHireDateIsNotNull() {
            addCriterion("hire_date is not null");
            return (Criteria) this;
        }

        public Criteria andHireDateEqualTo(Date value) {
            addCriterionForJDBCDate("hire_date =", value, "hireDate");
            return (Criteria) this;
        }

        public Criteria andHireDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("hire_date <>", value, "hireDate");
            return (Criteria) this;
        }

        public Criteria andHireDateGreaterThan(Date value) {
            addCriterionForJDBCDate("hire_date >", value, "hireDate");
            return (Criteria) this;
        }

        public Criteria andHireDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hire_date >=", value, "hireDate");
            return (Criteria) this;
        }

        public Criteria andHireDateLessThan(Date value) {
            addCriterionForJDBCDate("hire_date <", value, "hireDate");
            return (Criteria) this;
        }

        public Criteria andHireDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hire_date <=", value, "hireDate");
            return (Criteria) this;
        }

        public Criteria andHireDateIn(List<Date> values) {
            addCriterionForJDBCDate("hire_date in", values, "hireDate");
            return (Criteria) this;
        }

        public Criteria andHireDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("hire_date not in", values, "hireDate");
            return (Criteria) this;
        }

        public Criteria andHireDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hire_date between", value1, value2, "hireDate");
            return (Criteria) this;
        }

        public Criteria andHireDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hire_date not between", value1, value2, "hireDate");
            return (Criteria) this;
        }

        public Criteria andSalIsNull() {
            addCriterion("sal is null");
            return (Criteria) this;
        }

        public Criteria andSalIsNotNull() {
            addCriterion("sal is not null");
            return (Criteria) this;
        }

        public Criteria andSalEqualTo(Double value) {
            addCriterion("sal =", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotEqualTo(Double value) {
            addCriterion("sal <>", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalGreaterThan(Double value) {
            addCriterion("sal >", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalGreaterThanOrEqualTo(Double value) {
            addCriterion("sal >=", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalLessThan(Double value) {
            addCriterion("sal <", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalLessThanOrEqualTo(Double value) {
            addCriterion("sal <=", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalIn(List<Double> values) {
            addCriterion("sal in", values, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotIn(List<Double> values) {
            addCriterion("sal not in", values, "sal");
            return (Criteria) this;
        }

        public Criteria andSalBetween(Double value1, Double value2) {
            addCriterion("sal between", value1, value2, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotBetween(Double value1, Double value2) {
            addCriterion("sal not between", value1, value2, "sal");
            return (Criteria) this;
        }

        public Criteria andCommIsNull() {
            addCriterion("comm is null");
            return (Criteria) this;
        }

        public Criteria andCommIsNotNull() {
            addCriterion("comm is not null");
            return (Criteria) this;
        }

        public Criteria andCommEqualTo(Double value) {
            addCriterion("comm =", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotEqualTo(Double value) {
            addCriterion("comm <>", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThan(Double value) {
            addCriterion("comm >", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThanOrEqualTo(Double value) {
            addCriterion("comm >=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThan(Double value) {
            addCriterion("comm <", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThanOrEqualTo(Double value) {
            addCriterion("comm <=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommIn(List<Double> values) {
            addCriterion("comm in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotIn(List<Double> values) {
            addCriterion("comm not in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommBetween(Double value1, Double value2) {
            addCriterion("comm between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotBetween(Double value1, Double value2) {
            addCriterion("comm not between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andMakeDateIsNull() {
            addCriterion("make_date is null");
            return (Criteria) this;
        }

        public Criteria andMakeDateIsNotNull() {
            addCriterion("make_date is not null");
            return (Criteria) this;
        }

        public Criteria andMakeDateEqualTo(Date value) {
            addCriterionForJDBCDate("make_date =", value, "makeDate");
            return (Criteria) this;
        }

        public Criteria andMakeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("make_date <>", value, "makeDate");
            return (Criteria) this;
        }

        public Criteria andMakeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("make_date >", value, "makeDate");
            return (Criteria) this;
        }

        public Criteria andMakeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("make_date >=", value, "makeDate");
            return (Criteria) this;
        }

        public Criteria andMakeDateLessThan(Date value) {
            addCriterionForJDBCDate("make_date <", value, "makeDate");
            return (Criteria) this;
        }

        public Criteria andMakeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("make_date <=", value, "makeDate");
            return (Criteria) this;
        }

        public Criteria andMakeDateIn(List<Date> values) {
            addCriterionForJDBCDate("make_date in", values, "makeDate");
            return (Criteria) this;
        }

        public Criteria andMakeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("make_date not in", values, "makeDate");
            return (Criteria) this;
        }

        public Criteria andMakeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("make_date between", value1, value2, "makeDate");
            return (Criteria) this;
        }

        public Criteria andMakeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("make_date not between", value1, value2, "makeDate");
            return (Criteria) this;
        }

        public Criteria andMakeByIsNull() {
            addCriterion("make_by is null");
            return (Criteria) this;
        }

        public Criteria andMakeByIsNotNull() {
            addCriterion("make_by is not null");
            return (Criteria) this;
        }

        public Criteria andMakeByEqualTo(String value) {
            addCriterion("make_by =", value, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByNotEqualTo(String value) {
            addCriterion("make_by <>", value, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByGreaterThan(String value) {
            addCriterion("make_by >", value, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByGreaterThanOrEqualTo(String value) {
            addCriterion("make_by >=", value, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByLessThan(String value) {
            addCriterion("make_by <", value, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByLessThanOrEqualTo(String value) {
            addCriterion("make_by <=", value, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByLike(String value) {
            addCriterion("make_by like", value, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByNotLike(String value) {
            addCriterion("make_by not like", value, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByIn(List<String> values) {
            addCriterion("make_by in", values, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByNotIn(List<String> values) {
            addCriterion("make_by not in", values, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByBetween(String value1, String value2) {
            addCriterion("make_by between", value1, value2, "makeBy");
            return (Criteria) this;
        }

        public Criteria andMakeByNotBetween(String value1, String value2) {
            addCriterion("make_by not between", value1, value2, "makeBy");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterionForJDBCDate("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterionForJDBCDate("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterionForJDBCDate("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andSpare1IsNull() {
            addCriterion("spare_1 is null");
            return (Criteria) this;
        }

        public Criteria andSpare1IsNotNull() {
            addCriterion("spare_1 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare1EqualTo(String value) {
            addCriterion("spare_1 =", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotEqualTo(String value) {
            addCriterion("spare_1 <>", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1GreaterThan(String value) {
            addCriterion("spare_1 >", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1GreaterThanOrEqualTo(String value) {
            addCriterion("spare_1 >=", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1LessThan(String value) {
            addCriterion("spare_1 <", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1LessThanOrEqualTo(String value) {
            addCriterion("spare_1 <=", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1Like(String value) {
            addCriterion("spare_1 like", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotLike(String value) {
            addCriterion("spare_1 not like", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1In(List<String> values) {
            addCriterion("spare_1 in", values, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotIn(List<String> values) {
            addCriterion("spare_1 not in", values, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1Between(String value1, String value2) {
            addCriterion("spare_1 between", value1, value2, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotBetween(String value1, String value2) {
            addCriterion("spare_1 not between", value1, value2, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare2IsNull() {
            addCriterion("spare_2 is null");
            return (Criteria) this;
        }

        public Criteria andSpare2IsNotNull() {
            addCriterion("spare_2 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare2EqualTo(String value) {
            addCriterion("spare_2 =", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotEqualTo(String value) {
            addCriterion("spare_2 <>", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2GreaterThan(String value) {
            addCriterion("spare_2 >", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2GreaterThanOrEqualTo(String value) {
            addCriterion("spare_2 >=", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2LessThan(String value) {
            addCriterion("spare_2 <", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2LessThanOrEqualTo(String value) {
            addCriterion("spare_2 <=", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2Like(String value) {
            addCriterion("spare_2 like", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotLike(String value) {
            addCriterion("spare_2 not like", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2In(List<String> values) {
            addCriterion("spare_2 in", values, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotIn(List<String> values) {
            addCriterion("spare_2 not in", values, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2Between(String value1, String value2) {
            addCriterion("spare_2 between", value1, value2, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotBetween(String value1, String value2) {
            addCriterion("spare_2 not between", value1, value2, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare3IsNull() {
            addCriterion("spare_3 is null");
            return (Criteria) this;
        }

        public Criteria andSpare3IsNotNull() {
            addCriterion("spare_3 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare3EqualTo(String value) {
            addCriterion("spare_3 =", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotEqualTo(String value) {
            addCriterion("spare_3 <>", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3GreaterThan(String value) {
            addCriterion("spare_3 >", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3GreaterThanOrEqualTo(String value) {
            addCriterion("spare_3 >=", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3LessThan(String value) {
            addCriterion("spare_3 <", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3LessThanOrEqualTo(String value) {
            addCriterion("spare_3 <=", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3Like(String value) {
            addCriterion("spare_3 like", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotLike(String value) {
            addCriterion("spare_3 not like", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3In(List<String> values) {
            addCriterion("spare_3 in", values, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotIn(List<String> values) {
            addCriterion("spare_3 not in", values, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3Between(String value1, String value2) {
            addCriterion("spare_3 between", value1, value2, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotBetween(String value1, String value2) {
            addCriterion("spare_3 not between", value1, value2, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare4IsNull() {
            addCriterion("spare_4 is null");
            return (Criteria) this;
        }

        public Criteria andSpare4IsNotNull() {
            addCriterion("spare_4 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare4EqualTo(String value) {
            addCriterion("spare_4 =", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotEqualTo(String value) {
            addCriterion("spare_4 <>", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4GreaterThan(String value) {
            addCriterion("spare_4 >", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4GreaterThanOrEqualTo(String value) {
            addCriterion("spare_4 >=", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4LessThan(String value) {
            addCriterion("spare_4 <", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4LessThanOrEqualTo(String value) {
            addCriterion("spare_4 <=", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4Like(String value) {
            addCriterion("spare_4 like", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotLike(String value) {
            addCriterion("spare_4 not like", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4In(List<String> values) {
            addCriterion("spare_4 in", values, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotIn(List<String> values) {
            addCriterion("spare_4 not in", values, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4Between(String value1, String value2) {
            addCriterion("spare_4 between", value1, value2, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotBetween(String value1, String value2) {
            addCriterion("spare_4 not between", value1, value2, "spare4");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}