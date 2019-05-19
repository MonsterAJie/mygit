package com.land.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
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

        public Criteria andCoIdIsNull() {
            addCriterion("co_id is null");
            return (Criteria) this;
        }

        public Criteria andCoIdIsNotNull() {
            addCriterion("co_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoIdEqualTo(Integer value) {
            addCriterion("co_id =", value, "coId");
            return (Criteria) this;
        }

        public Criteria andCoIdNotEqualTo(Integer value) {
            addCriterion("co_id <>", value, "coId");
            return (Criteria) this;
        }

        public Criteria andCoIdGreaterThan(Integer value) {
            addCriterion("co_id >", value, "coId");
            return (Criteria) this;
        }

        public Criteria andCoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("co_id >=", value, "coId");
            return (Criteria) this;
        }

        public Criteria andCoIdLessThan(Integer value) {
            addCriterion("co_id <", value, "coId");
            return (Criteria) this;
        }

        public Criteria andCoIdLessThanOrEqualTo(Integer value) {
            addCriterion("co_id <=", value, "coId");
            return (Criteria) this;
        }

        public Criteria andCoIdIn(List<Integer> values) {
            addCriterion("co_id in", values, "coId");
            return (Criteria) this;
        }

        public Criteria andCoIdNotIn(List<Integer> values) {
            addCriterion("co_id not in", values, "coId");
            return (Criteria) this;
        }

        public Criteria andCoIdBetween(Integer value1, Integer value2) {
            addCriterion("co_id between", value1, value2, "coId");
            return (Criteria) this;
        }

        public Criteria andCoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("co_id not between", value1, value2, "coId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureIsNull() {
            addCriterion("corporation_nature is null");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureIsNotNull() {
            addCriterion("corporation_nature is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureEqualTo(String value) {
            addCriterion("corporation_nature =", value, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureNotEqualTo(String value) {
            addCriterion("corporation_nature <>", value, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureGreaterThan(String value) {
            addCriterion("corporation_nature >", value, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureGreaterThanOrEqualTo(String value) {
            addCriterion("corporation_nature >=", value, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureLessThan(String value) {
            addCriterion("corporation_nature <", value, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureLessThanOrEqualTo(String value) {
            addCriterion("corporation_nature <=", value, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureLike(String value) {
            addCriterion("corporation_nature like", value, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureNotLike(String value) {
            addCriterion("corporation_nature not like", value, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureIn(List<String> values) {
            addCriterion("corporation_nature in", values, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureNotIn(List<String> values) {
            addCriterion("corporation_nature not in", values, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureBetween(String value1, String value2) {
            addCriterion("corporation_nature between", value1, value2, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCorporationNatureNotBetween(String value1, String value2) {
            addCriterion("corporation_nature not between", value1, value2, "corporationNature");
            return (Criteria) this;
        }

        public Criteria andCoNameIsNull() {
            addCriterion("co_name is null");
            return (Criteria) this;
        }

        public Criteria andCoNameIsNotNull() {
            addCriterion("co_name is not null");
            return (Criteria) this;
        }

        public Criteria andCoNameEqualTo(String value) {
            addCriterion("co_name =", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotEqualTo(String value) {
            addCriterion("co_name <>", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameGreaterThan(String value) {
            addCriterion("co_name >", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameGreaterThanOrEqualTo(String value) {
            addCriterion("co_name >=", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameLessThan(String value) {
            addCriterion("co_name <", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameLessThanOrEqualTo(String value) {
            addCriterion("co_name <=", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameLike(String value) {
            addCriterion("co_name like", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotLike(String value) {
            addCriterion("co_name not like", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameIn(List<String> values) {
            addCriterion("co_name in", values, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotIn(List<String> values) {
            addCriterion("co_name not in", values, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameBetween(String value1, String value2) {
            addCriterion("co_name between", value1, value2, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotBetween(String value1, String value2) {
            addCriterion("co_name not between", value1, value2, "coName");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andWebIsNull() {
            addCriterion("web is null");
            return (Criteria) this;
        }

        public Criteria andWebIsNotNull() {
            addCriterion("web is not null");
            return (Criteria) this;
        }

        public Criteria andWebEqualTo(String value) {
            addCriterion("web =", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotEqualTo(String value) {
            addCriterion("web <>", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebGreaterThan(String value) {
            addCriterion("web >", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebGreaterThanOrEqualTo(String value) {
            addCriterion("web >=", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebLessThan(String value) {
            addCriterion("web <", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebLessThanOrEqualTo(String value) {
            addCriterion("web <=", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebLike(String value) {
            addCriterion("web like", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotLike(String value) {
            addCriterion("web not like", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebIn(List<String> values) {
            addCriterion("web in", values, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotIn(List<String> values) {
            addCriterion("web not in", values, "web");
            return (Criteria) this;
        }

        public Criteria andWebBetween(String value1, String value2) {
            addCriterion("web between", value1, value2, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotBetween(String value1, String value2) {
            addCriterion("web not between", value1, value2, "web");
            return (Criteria) this;
        }

        public Criteria andEstablishedIsNull() {
            addCriterion("established is null");
            return (Criteria) this;
        }

        public Criteria andEstablishedIsNotNull() {
            addCriterion("established is not null");
            return (Criteria) this;
        }

        public Criteria andEstablishedEqualTo(Date value) {
            addCriterionForJDBCDate("established =", value, "established");
            return (Criteria) this;
        }

        public Criteria andEstablishedNotEqualTo(Date value) {
            addCriterionForJDBCDate("established <>", value, "established");
            return (Criteria) this;
        }

        public Criteria andEstablishedGreaterThan(Date value) {
            addCriterionForJDBCDate("established >", value, "established");
            return (Criteria) this;
        }

        public Criteria andEstablishedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("established >=", value, "established");
            return (Criteria) this;
        }

        public Criteria andEstablishedLessThan(Date value) {
            addCriterionForJDBCDate("established <", value, "established");
            return (Criteria) this;
        }

        public Criteria andEstablishedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("established <=", value, "established");
            return (Criteria) this;
        }

        public Criteria andEstablishedIn(List<Date> values) {
            addCriterionForJDBCDate("established in", values, "established");
            return (Criteria) this;
        }

        public Criteria andEstablishedNotIn(List<Date> values) {
            addCriterionForJDBCDate("established not in", values, "established");
            return (Criteria) this;
        }

        public Criteria andEstablishedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("established between", value1, value2, "established");
            return (Criteria) this;
        }

        public Criteria andEstablishedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("established not between", value1, value2, "established");
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