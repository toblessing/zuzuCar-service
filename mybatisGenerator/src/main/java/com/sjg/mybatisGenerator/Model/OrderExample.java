package com.sjg.mybatisGenerator.Model;

import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdIsNull() {
            addCriterion("holder_id is null");
            return (Criteria) this;
        }

        public Criteria andHolderIdIsNotNull() {
            addCriterion("holder_id is not null");
            return (Criteria) this;
        }

        public Criteria andHolderIdEqualTo(Integer value) {
            addCriterion("holder_id =", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdNotEqualTo(Integer value) {
            addCriterion("holder_id <>", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdGreaterThan(Integer value) {
            addCriterion("holder_id >", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("holder_id >=", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdLessThan(Integer value) {
            addCriterion("holder_id <", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdLessThanOrEqualTo(Integer value) {
            addCriterion("holder_id <=", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdIn(List<Integer> values) {
            addCriterion("holder_id in", values, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdNotIn(List<Integer> values) {
            addCriterion("holder_id not in", values, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdBetween(Integer value1, Integer value2) {
            addCriterion("holder_id between", value1, value2, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("holder_id not between", value1, value2, "holderId");
            return (Criteria) this;
        }

        public Criteria andReservationIdIsNull() {
            addCriterion("reservation_id is null");
            return (Criteria) this;
        }

        public Criteria andReservationIdIsNotNull() {
            addCriterion("reservation_id is not null");
            return (Criteria) this;
        }

        public Criteria andReservationIdEqualTo(Integer value) {
            addCriterion("reservation_id =", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdNotEqualTo(Integer value) {
            addCriterion("reservation_id <>", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdGreaterThan(Integer value) {
            addCriterion("reservation_id >", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reservation_id >=", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdLessThan(Integer value) {
            addCriterion("reservation_id <", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdLessThanOrEqualTo(Integer value) {
            addCriterion("reservation_id <=", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdIn(List<Integer> values) {
            addCriterion("reservation_id in", values, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdNotIn(List<Integer> values) {
            addCriterion("reservation_id not in", values, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdBetween(Integer value1, Integer value2) {
            addCriterion("reservation_id between", value1, value2, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reservation_id not between", value1, value2, "reservationId");
            return (Criteria) this;
        }

        public Criteria andLicensePlateIsNull() {
            addCriterion("license_plate is null");
            return (Criteria) this;
        }

        public Criteria andLicensePlateIsNotNull() {
            addCriterion("license_plate is not null");
            return (Criteria) this;
        }

        public Criteria andLicensePlateEqualTo(String value) {
            addCriterion("license_plate =", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateNotEqualTo(String value) {
            addCriterion("license_plate <>", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateGreaterThan(String value) {
            addCriterion("license_plate >", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateGreaterThanOrEqualTo(String value) {
            addCriterion("license_plate >=", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateLessThan(String value) {
            addCriterion("license_plate <", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateLessThanOrEqualTo(String value) {
            addCriterion("license_plate <=", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateLike(String value) {
            addCriterion("license_plate like", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateNotLike(String value) {
            addCriterion("license_plate not like", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateIn(List<String> values) {
            addCriterion("license_plate in", values, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateNotIn(List<String> values) {
            addCriterion("license_plate not in", values, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateBetween(String value1, String value2) {
            addCriterion("license_plate between", value1, value2, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateNotBetween(String value1, String value2) {
            addCriterion("license_plate not between", value1, value2, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Integer value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Integer value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Integer value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Integer value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Integer value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Integer> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Integer> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Integer value1, Integer value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andFreeTimeIsNull() {
            addCriterion("free_time is null");
            return (Criteria) this;
        }

        public Criteria andFreeTimeIsNotNull() {
            addCriterion("free_time is not null");
            return (Criteria) this;
        }

        public Criteria andFreeTimeEqualTo(String value) {
            addCriterion("free_time =", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeNotEqualTo(String value) {
            addCriterion("free_time <>", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeGreaterThan(String value) {
            addCriterion("free_time >", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeGreaterThanOrEqualTo(String value) {
            addCriterion("free_time >=", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeLessThan(String value) {
            addCriterion("free_time <", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeLessThanOrEqualTo(String value) {
            addCriterion("free_time <=", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeLike(String value) {
            addCriterion("free_time like", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeNotLike(String value) {
            addCriterion("free_time not like", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeIn(List<String> values) {
            addCriterion("free_time in", values, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeNotIn(List<String> values) {
            addCriterion("free_time not in", values, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeBetween(String value1, String value2) {
            addCriterion("free_time between", value1, value2, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeNotBetween(String value1, String value2) {
            addCriterion("free_time not between", value1, value2, "freeTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeIsNull() {
            addCriterion("reservation_time is null");
            return (Criteria) this;
        }

        public Criteria andReservationTimeIsNotNull() {
            addCriterion("reservation_time is not null");
            return (Criteria) this;
        }

        public Criteria andReservationTimeEqualTo(String value) {
            addCriterion("reservation_time =", value, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeNotEqualTo(String value) {
            addCriterion("reservation_time <>", value, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeGreaterThan(String value) {
            addCriterion("reservation_time >", value, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeGreaterThanOrEqualTo(String value) {
            addCriterion("reservation_time >=", value, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeLessThan(String value) {
            addCriterion("reservation_time <", value, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeLessThanOrEqualTo(String value) {
            addCriterion("reservation_time <=", value, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeLike(String value) {
            addCriterion("reservation_time like", value, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeNotLike(String value) {
            addCriterion("reservation_time not like", value, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeIn(List<String> values) {
            addCriterion("reservation_time in", values, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeNotIn(List<String> values) {
            addCriterion("reservation_time not in", values, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeBetween(String value1, String value2) {
            addCriterion("reservation_time between", value1, value2, "reservationTime");
            return (Criteria) this;
        }

        public Criteria andReservationTimeNotBetween(String value1, String value2) {
            addCriterion("reservation_time not between", value1, value2, "reservationTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table order
     *
     * @mbg.generated do_not_delete_during_merge Fri Jul 05 11:29:17 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
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