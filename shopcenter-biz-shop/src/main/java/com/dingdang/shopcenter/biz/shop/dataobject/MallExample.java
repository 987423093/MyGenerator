package com.dingdang.shopcenter.biz.shop.dataobject;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MallExample {
protected String orderByClause;

protected boolean distinct;

protected List<Criteria> oredCriteria;

    public MallExample() {
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

                            
                                public Criteria andMallIdIsNull() {
                                addCriterion("MallId is null");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdNotNull() {
                                addCriterion("MallId is not null");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdEqualTo(Long value) {
                                addCriterion("MallId =", value, "mallId");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdNotEqualTo(Long value) {
                                addCriterion("MallId <>", value, "mallId");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdGreaterThan(Long value) {
                                addCriterion("MallId >", value, "mallId");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdGreaterThanOrEqualTo(Long value) {
                                addCriterion("MallId >=", value, "mallId");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdLessThan(Long value) {
                                addCriterion("MallId <", value, "mallId");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdLessThanOrEqualTo(Long value) {
                                addCriterion("MallId <=", value, "mallId");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdIn(List<Long> values) {
                                addCriterion("MallId in", values, "mallId");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdNotIn(List<Long> values) {
                                addCriterion("MallId not in", values, "mallId");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdBetween(Long value1, Long value2) {
                                addCriterion("MallId between", value1, value2, "mallId");
                                return (Criteria) this;
                                }

                                public Criteria andMallIdNotBetween(Long value1, Long value2) {
                                addCriterion("MallId not between", value1, value2, "mallId");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andMallNameIsNull() {
                                addCriterion("MallName is null");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameNotNull() {
                                addCriterion("MallName is not null");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameEqualTo(String value) {
                                addCriterion("MallName =", value, "mallName");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameNotEqualTo(String value) {
                                addCriterion("MallName <>", value, "mallName");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameGreaterThan(String value) {
                                addCriterion("MallName >", value, "mallName");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameGreaterThanOrEqualTo(String value) {
                                addCriterion("MallName >=", value, "mallName");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameLessThan(String value) {
                                addCriterion("MallName <", value, "mallName");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameLessThanOrEqualTo(String value) {
                                addCriterion("MallName <=", value, "mallName");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameIn(List<String> values) {
                                addCriterion("MallName in", values, "mallName");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameNotIn(List<String> values) {
                                addCriterion("MallName not in", values, "mallName");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameBetween(String value1, String value2) {
                                addCriterion("MallName between", value1, value2, "mallName");
                                return (Criteria) this;
                                }

                                public Criteria andMallNameNotBetween(String value1, String value2) {
                                addCriterion("MallName not between", value1, value2, "mallName");
                                return (Criteria) this;
                                }

                                                                    public Criteria andMallNameLike(String value) {
                                    addCriterion("MallName like", value, "mallName");
                                    return (Criteria) this;
                                    }

                                    public Criteria andMallNameNotLike(String value) {
                                    addCriterion("MallName not like", value, "mallName");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andMallTypeIsNull() {
                                addCriterion("MallType is null");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeNotNull() {
                                addCriterion("MallType is not null");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeEqualTo(Integer value) {
                                addCriterion("MallType =", value, "mallType");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeNotEqualTo(Integer value) {
                                addCriterion("MallType <>", value, "mallType");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeGreaterThan(Integer value) {
                                addCriterion("MallType >", value, "mallType");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeGreaterThanOrEqualTo(Integer value) {
                                addCriterion("MallType >=", value, "mallType");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeLessThan(Integer value) {
                                addCriterion("MallType <", value, "mallType");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeLessThanOrEqualTo(Integer value) {
                                addCriterion("MallType <=", value, "mallType");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeIn(List<Integer> values) {
                                addCriterion("MallType in", values, "mallType");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeNotIn(List<Integer> values) {
                                addCriterion("MallType not in", values, "mallType");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeBetween(Integer value1, Integer value2) {
                                addCriterion("MallType between", value1, value2, "mallType");
                                return (Criteria) this;
                                }

                                public Criteria andMallTypeNotBetween(Integer value1, Integer value2) {
                                addCriterion("MallType not between", value1, value2, "mallType");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andMallLogoIsNull() {
                                addCriterion("MallLogo is null");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoNotNull() {
                                addCriterion("MallLogo is not null");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoEqualTo(String value) {
                                addCriterion("MallLogo =", value, "mallLogo");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoNotEqualTo(String value) {
                                addCriterion("MallLogo <>", value, "mallLogo");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoGreaterThan(String value) {
                                addCriterion("MallLogo >", value, "mallLogo");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoGreaterThanOrEqualTo(String value) {
                                addCriterion("MallLogo >=", value, "mallLogo");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoLessThan(String value) {
                                addCriterion("MallLogo <", value, "mallLogo");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoLessThanOrEqualTo(String value) {
                                addCriterion("MallLogo <=", value, "mallLogo");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoIn(List<String> values) {
                                addCriterion("MallLogo in", values, "mallLogo");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoNotIn(List<String> values) {
                                addCriterion("MallLogo not in", values, "mallLogo");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoBetween(String value1, String value2) {
                                addCriterion("MallLogo between", value1, value2, "mallLogo");
                                return (Criteria) this;
                                }

                                public Criteria andMallLogoNotBetween(String value1, String value2) {
                                addCriterion("MallLogo not between", value1, value2, "mallLogo");
                                return (Criteria) this;
                                }

                                                                    public Criteria andMallLogoLike(String value) {
                                    addCriterion("MallLogo like", value, "mallLogo");
                                    return (Criteria) this;
                                    }

                                    public Criteria andMallLogoNotLike(String value) {
                                    addCriterion("MallLogo not like", value, "mallLogo");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andEnableStatusIsNull() {
                                addCriterion("EnableStatus is null");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusNotNull() {
                                addCriterion("EnableStatus is not null");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusEqualTo(Integer value) {
                                addCriterion("EnableStatus =", value, "enableStatus");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusNotEqualTo(Integer value) {
                                addCriterion("EnableStatus <>", value, "enableStatus");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusGreaterThan(Integer value) {
                                addCriterion("EnableStatus >", value, "enableStatus");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusGreaterThanOrEqualTo(Integer value) {
                                addCriterion("EnableStatus >=", value, "enableStatus");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusLessThan(Integer value) {
                                addCriterion("EnableStatus <", value, "enableStatus");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusLessThanOrEqualTo(Integer value) {
                                addCriterion("EnableStatus <=", value, "enableStatus");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusIn(List<Integer> values) {
                                addCriterion("EnableStatus in", values, "enableStatus");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusNotIn(List<Integer> values) {
                                addCriterion("EnableStatus not in", values, "enableStatus");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusBetween(Integer value1, Integer value2) {
                                addCriterion("EnableStatus between", value1, value2, "enableStatus");
                                return (Criteria) this;
                                }

                                public Criteria andEnableStatusNotBetween(Integer value1, Integer value2) {
                                addCriterion("EnableStatus not between", value1, value2, "enableStatus");
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