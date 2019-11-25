package com.dingdang.shopcenter.biz.shop.dataobject;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ColumnGoodsExample {
protected String orderByClause;

protected boolean distinct;

protected List<Criteria> oredCriteria;

    public ColumnGoodsExample() {
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

							public Criteria andLikeWithNull(String value) {
                                    addCriterion(value);
                                    return (Criteria) this;
                                }

                            
                                public Criteria andColumnGoodsIdIsNull() {
                                addCriterion("ColumnGoodsId is null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdNotNull() {
                                addCriterion("ColumnGoodsId is not null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdEqualTo(Long value) {
                                addCriterion("ColumnGoodsId =", value, "columnGoodsId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdNotEqualTo(Long value) {
                                addCriterion("ColumnGoodsId <>", value, "columnGoodsId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdGreaterThan(Long value) {
                                addCriterion("ColumnGoodsId >", value, "columnGoodsId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdGreaterThanOrEqualTo(Long value) {
                                addCriterion("ColumnGoodsId >=", value, "columnGoodsId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdLessThan(Long value) {
                                addCriterion("ColumnGoodsId <", value, "columnGoodsId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdLessThanOrEqualTo(Long value) {
                                addCriterion("ColumnGoodsId <=", value, "columnGoodsId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdIn(List<Long> values) {
                                addCriterion("ColumnGoodsId in", values, "columnGoodsId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdNotIn(List<Long> values) {
                                addCriterion("ColumnGoodsId not in", values, "columnGoodsId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdBetween(Long value1, Long value2) {
                                addCriterion("ColumnGoodsId between", value1, value2, "columnGoodsId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnGoodsIdNotBetween(Long value1, Long value2) {
                                addCriterion("ColumnGoodsId not between", value1, value2, "columnGoodsId");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andColumnIdIsNull() {
                                addCriterion("ColumnId is null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdNotNull() {
                                addCriterion("ColumnId is not null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdEqualTo(Long value) {
                                addCriterion("ColumnId =", value, "columnId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdNotEqualTo(Long value) {
                                addCriterion("ColumnId <>", value, "columnId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdGreaterThan(Long value) {
                                addCriterion("ColumnId >", value, "columnId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdGreaterThanOrEqualTo(Long value) {
                                addCriterion("ColumnId >=", value, "columnId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdLessThan(Long value) {
                                addCriterion("ColumnId <", value, "columnId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdLessThanOrEqualTo(Long value) {
                                addCriterion("ColumnId <=", value, "columnId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdIn(List<Long> values) {
                                addCriterion("ColumnId in", values, "columnId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdNotIn(List<Long> values) {
                                addCriterion("ColumnId not in", values, "columnId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdBetween(Long value1, Long value2) {
                                addCriterion("ColumnId between", value1, value2, "columnId");
                                return (Criteria) this;
                                }

                                public Criteria andColumnIdNotBetween(Long value1, Long value2) {
                                addCriterion("ColumnId not between", value1, value2, "columnId");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andGoodsIdIsNull() {
                                addCriterion("GoodsId is null");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdNotNull() {
                                addCriterion("GoodsId is not null");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdEqualTo(Long value) {
                                addCriterion("GoodsId =", value, "goodsId");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdNotEqualTo(Long value) {
                                addCriterion("GoodsId <>", value, "goodsId");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdGreaterThan(Long value) {
                                addCriterion("GoodsId >", value, "goodsId");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
                                addCriterion("GoodsId >=", value, "goodsId");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdLessThan(Long value) {
                                addCriterion("GoodsId <", value, "goodsId");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
                                addCriterion("GoodsId <=", value, "goodsId");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdIn(List<Long> values) {
                                addCriterion("GoodsId in", values, "goodsId");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdNotIn(List<Long> values) {
                                addCriterion("GoodsId not in", values, "goodsId");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdBetween(Long value1, Long value2) {
                                addCriterion("GoodsId between", value1, value2, "goodsId");
                                return (Criteria) this;
                                }

                                public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
                                addCriterion("GoodsId not between", value1, value2, "goodsId");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andSortNumIsNull() {
                                addCriterion("SortNum is null");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumNotNull() {
                                addCriterion("SortNum is not null");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumEqualTo(Integer value) {
                                addCriterion("SortNum =", value, "sortNum");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumNotEqualTo(Integer value) {
                                addCriterion("SortNum <>", value, "sortNum");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumGreaterThan(Integer value) {
                                addCriterion("SortNum >", value, "sortNum");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumGreaterThanOrEqualTo(Integer value) {
                                addCriterion("SortNum >=", value, "sortNum");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumLessThan(Integer value) {
                                addCriterion("SortNum <", value, "sortNum");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumLessThanOrEqualTo(Integer value) {
                                addCriterion("SortNum <=", value, "sortNum");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumIn(List<Integer> values) {
                                addCriterion("SortNum in", values, "sortNum");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumNotIn(List<Integer> values) {
                                addCriterion("SortNum not in", values, "sortNum");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumBetween(Integer value1, Integer value2) {
                                addCriterion("SortNum between", value1, value2, "sortNum");
                                return (Criteria) this;
                                }

                                public Criteria andSortNumNotBetween(Integer value1, Integer value2) {
                                addCriterion("SortNum not between", value1, value2, "sortNum");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andCreatorIsNull() {
                                addCriterion("Creator is null");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorNotNull() {
                                addCriterion("Creator is not null");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorEqualTo(Long value) {
                                addCriterion("Creator =", value, "creator");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorNotEqualTo(Long value) {
                                addCriterion("Creator <>", value, "creator");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorGreaterThan(Long value) {
                                addCriterion("Creator >", value, "creator");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorGreaterThanOrEqualTo(Long value) {
                                addCriterion("Creator >=", value, "creator");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorLessThan(Long value) {
                                addCriterion("Creator <", value, "creator");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorLessThanOrEqualTo(Long value) {
                                addCriterion("Creator <=", value, "creator");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorIn(List<Long> values) {
                                addCriterion("Creator in", values, "creator");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorNotIn(List<Long> values) {
                                addCriterion("Creator not in", values, "creator");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorBetween(Long value1, Long value2) {
                                addCriterion("Creator between", value1, value2, "creator");
                                return (Criteria) this;
                                }

                                public Criteria andCreatorNotBetween(Long value1, Long value2) {
                                addCriterion("Creator not between", value1, value2, "creator");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andModifierIsNull() {
                                addCriterion("Modifier is null");
                                return (Criteria) this;
                                }

                                public Criteria andModifierNotNull() {
                                addCriterion("Modifier is not null");
                                return (Criteria) this;
                                }

                                public Criteria andModifierEqualTo(Long value) {
                                addCriterion("Modifier =", value, "modifier");
                                return (Criteria) this;
                                }

                                public Criteria andModifierNotEqualTo(Long value) {
                                addCriterion("Modifier <>", value, "modifier");
                                return (Criteria) this;
                                }

                                public Criteria andModifierGreaterThan(Long value) {
                                addCriterion("Modifier >", value, "modifier");
                                return (Criteria) this;
                                }

                                public Criteria andModifierGreaterThanOrEqualTo(Long value) {
                                addCriterion("Modifier >=", value, "modifier");
                                return (Criteria) this;
                                }

                                public Criteria andModifierLessThan(Long value) {
                                addCriterion("Modifier <", value, "modifier");
                                return (Criteria) this;
                                }

                                public Criteria andModifierLessThanOrEqualTo(Long value) {
                                addCriterion("Modifier <=", value, "modifier");
                                return (Criteria) this;
                                }

                                public Criteria andModifierIn(List<Long> values) {
                                addCriterion("Modifier in", values, "modifier");
                                return (Criteria) this;
                                }

                                public Criteria andModifierNotIn(List<Long> values) {
                                addCriterion("Modifier not in", values, "modifier");
                                return (Criteria) this;
                                }

                                public Criteria andModifierBetween(Long value1, Long value2) {
                                addCriterion("Modifier between", value1, value2, "modifier");
                                return (Criteria) this;
                                }

                                public Criteria andModifierNotBetween(Long value1, Long value2) {
                                addCriterion("Modifier not between", value1, value2, "modifier");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andCreateDateIsNull() {
                                addCriterion("CreateDate is null");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateNotNull() {
                                addCriterion("CreateDate is not null");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateEqualTo(Date value) {
                                addCriterion("CreateDate =", value, "createDate");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateNotEqualTo(Date value) {
                                addCriterion("CreateDate <>", value, "createDate");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateGreaterThan(Date value) {
                                addCriterion("CreateDate >", value, "createDate");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
                                addCriterion("CreateDate >=", value, "createDate");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateLessThan(Date value) {
                                addCriterion("CreateDate <", value, "createDate");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateLessThanOrEqualTo(Date value) {
                                addCriterion("CreateDate <=", value, "createDate");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateIn(List<Date> values) {
                                addCriterion("CreateDate in", values, "createDate");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateNotIn(List<Date> values) {
                                addCriterion("CreateDate not in", values, "createDate");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateBetween(Date value1, Date value2) {
                                addCriterion("CreateDate between", value1, value2, "createDate");
                                return (Criteria) this;
                                }

                                public Criteria andCreateDateNotBetween(Date value1, Date value2) {
                                addCriterion("CreateDate not between", value1, value2, "createDate");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andModifyDateIsNull() {
                                addCriterion("ModifyDate is null");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateNotNull() {
                                addCriterion("ModifyDate is not null");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateEqualTo(Date value) {
                                addCriterion("ModifyDate =", value, "modifyDate");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateNotEqualTo(Date value) {
                                addCriterion("ModifyDate <>", value, "modifyDate");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateGreaterThan(Date value) {
                                addCriterion("ModifyDate >", value, "modifyDate");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
                                addCriterion("ModifyDate >=", value, "modifyDate");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateLessThan(Date value) {
                                addCriterion("ModifyDate <", value, "modifyDate");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateLessThanOrEqualTo(Date value) {
                                addCriterion("ModifyDate <=", value, "modifyDate");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateIn(List<Date> values) {
                                addCriterion("ModifyDate in", values, "modifyDate");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateNotIn(List<Date> values) {
                                addCriterion("ModifyDate not in", values, "modifyDate");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateBetween(Date value1, Date value2) {
                                addCriterion("ModifyDate between", value1, value2, "modifyDate");
                                return (Criteria) this;
                                }

                                public Criteria andModifyDateNotBetween(Date value1, Date value2) {
                                addCriterion("ModifyDate not between", value1, value2, "modifyDate");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andStateIsNull() {
                                addCriterion("State is null");
                                return (Criteria) this;
                                }

                                public Criteria andStateNotNull() {
                                addCriterion("State is not null");
                                return (Criteria) this;
                                }

                                public Criteria andStateEqualTo(String value) {
                                addCriterion("State =", value, "state");
                                return (Criteria) this;
                                }

                                public Criteria andStateNotEqualTo(String value) {
                                addCriterion("State <>", value, "state");
                                return (Criteria) this;
                                }

                                public Criteria andStateGreaterThan(String value) {
                                addCriterion("State >", value, "state");
                                return (Criteria) this;
                                }

                                public Criteria andStateGreaterThanOrEqualTo(String value) {
                                addCriterion("State >=", value, "state");
                                return (Criteria) this;
                                }

                                public Criteria andStateLessThan(String value) {
                                addCriterion("State <", value, "state");
                                return (Criteria) this;
                                }

                                public Criteria andStateLessThanOrEqualTo(String value) {
                                addCriterion("State <=", value, "state");
                                return (Criteria) this;
                                }

                                public Criteria andStateIn(List<String> values) {
                                addCriterion("State in", values, "state");
                                return (Criteria) this;
                                }

                                public Criteria andStateNotIn(List<String> values) {
                                addCriterion("State not in", values, "state");
                                return (Criteria) this;
                                }

                                public Criteria andStateBetween(String value1, String value2) {
                                addCriterion("State between", value1, value2, "state");
                                return (Criteria) this;
                                }

                                public Criteria andStateNotBetween(String value1, String value2) {
                                addCriterion("State not between", value1, value2, "state");
                                return (Criteria) this;
                                }

                                                                    public Criteria andStateLike(String value) {
                                    addCriterion("State like", value, "state");
                                    return (Criteria) this;
                                    }

                                    public Criteria andStateNotLike(String value) {
                                    addCriterion("State not like", value, "state");
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