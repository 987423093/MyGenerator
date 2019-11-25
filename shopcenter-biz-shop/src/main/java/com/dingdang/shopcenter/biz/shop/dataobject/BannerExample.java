package com.dingdang.shopcenter.biz.shop.dataobject;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BannerExample {
protected String orderByClause;

protected boolean distinct;

protected List<Criteria> oredCriteria;

    public BannerExample() {
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

                            
                                public Criteria andBannerIdIsNull() {
                                addCriterion("BannerId is null");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdNotNull() {
                                addCriterion("BannerId is not null");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdEqualTo(Long value) {
                                addCriterion("BannerId =", value, "bannerId");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdNotEqualTo(Long value) {
                                addCriterion("BannerId <>", value, "bannerId");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdGreaterThan(Long value) {
                                addCriterion("BannerId >", value, "bannerId");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdGreaterThanOrEqualTo(Long value) {
                                addCriterion("BannerId >=", value, "bannerId");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdLessThan(Long value) {
                                addCriterion("BannerId <", value, "bannerId");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdLessThanOrEqualTo(Long value) {
                                addCriterion("BannerId <=", value, "bannerId");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdIn(List<Long> values) {
                                addCriterion("BannerId in", values, "bannerId");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdNotIn(List<Long> values) {
                                addCriterion("BannerId not in", values, "bannerId");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdBetween(Long value1, Long value2) {
                                addCriterion("BannerId between", value1, value2, "bannerId");
                                return (Criteria) this;
                                }

                                public Criteria andBannerIdNotBetween(Long value1, Long value2) {
                                addCriterion("BannerId not between", value1, value2, "bannerId");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andBannerNameIsNull() {
                                addCriterion("BannerName is null");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameNotNull() {
                                addCriterion("BannerName is not null");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameEqualTo(String value) {
                                addCriterion("BannerName =", value, "bannerName");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameNotEqualTo(String value) {
                                addCriterion("BannerName <>", value, "bannerName");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameGreaterThan(String value) {
                                addCriterion("BannerName >", value, "bannerName");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameGreaterThanOrEqualTo(String value) {
                                addCriterion("BannerName >=", value, "bannerName");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameLessThan(String value) {
                                addCriterion("BannerName <", value, "bannerName");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameLessThanOrEqualTo(String value) {
                                addCriterion("BannerName <=", value, "bannerName");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameIn(List<String> values) {
                                addCriterion("BannerName in", values, "bannerName");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameNotIn(List<String> values) {
                                addCriterion("BannerName not in", values, "bannerName");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameBetween(String value1, String value2) {
                                addCriterion("BannerName between", value1, value2, "bannerName");
                                return (Criteria) this;
                                }

                                public Criteria andBannerNameNotBetween(String value1, String value2) {
                                addCriterion("BannerName not between", value1, value2, "bannerName");
                                return (Criteria) this;
                                }

                                                                    public Criteria andBannerNameLike(String value) {
                                    addCriterion("BannerName like", value, "bannerName");
                                    return (Criteria) this;
                                    }

                                    public Criteria andBannerNameNotLike(String value) {
                                    addCriterion("BannerName not like", value, "bannerName");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andBannerUrlIsNull() {
                                addCriterion("BannerUrl is null");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlNotNull() {
                                addCriterion("BannerUrl is not null");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlEqualTo(String value) {
                                addCriterion("BannerUrl =", value, "bannerUrl");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlNotEqualTo(String value) {
                                addCriterion("BannerUrl <>", value, "bannerUrl");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlGreaterThan(String value) {
                                addCriterion("BannerUrl >", value, "bannerUrl");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlGreaterThanOrEqualTo(String value) {
                                addCriterion("BannerUrl >=", value, "bannerUrl");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlLessThan(String value) {
                                addCriterion("BannerUrl <", value, "bannerUrl");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlLessThanOrEqualTo(String value) {
                                addCriterion("BannerUrl <=", value, "bannerUrl");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlIn(List<String> values) {
                                addCriterion("BannerUrl in", values, "bannerUrl");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlNotIn(List<String> values) {
                                addCriterion("BannerUrl not in", values, "bannerUrl");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlBetween(String value1, String value2) {
                                addCriterion("BannerUrl between", value1, value2, "bannerUrl");
                                return (Criteria) this;
                                }

                                public Criteria andBannerUrlNotBetween(String value1, String value2) {
                                addCriterion("BannerUrl not between", value1, value2, "bannerUrl");
                                return (Criteria) this;
                                }

                                                                    public Criteria andBannerUrlLike(String value) {
                                    addCriterion("BannerUrl like", value, "bannerUrl");
                                    return (Criteria) this;
                                    }

                                    public Criteria andBannerUrlNotLike(String value) {
                                    addCriterion("BannerUrl not like", value, "bannerUrl");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andBannerImageIsNull() {
                                addCriterion("BannerImage is null");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageNotNull() {
                                addCriterion("BannerImage is not null");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageEqualTo(String value) {
                                addCriterion("BannerImage =", value, "bannerImage");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageNotEqualTo(String value) {
                                addCriterion("BannerImage <>", value, "bannerImage");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageGreaterThan(String value) {
                                addCriterion("BannerImage >", value, "bannerImage");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageGreaterThanOrEqualTo(String value) {
                                addCriterion("BannerImage >=", value, "bannerImage");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageLessThan(String value) {
                                addCriterion("BannerImage <", value, "bannerImage");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageLessThanOrEqualTo(String value) {
                                addCriterion("BannerImage <=", value, "bannerImage");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageIn(List<String> values) {
                                addCriterion("BannerImage in", values, "bannerImage");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageNotIn(List<String> values) {
                                addCriterion("BannerImage not in", values, "bannerImage");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageBetween(String value1, String value2) {
                                addCriterion("BannerImage between", value1, value2, "bannerImage");
                                return (Criteria) this;
                                }

                                public Criteria andBannerImageNotBetween(String value1, String value2) {
                                addCriterion("BannerImage not between", value1, value2, "bannerImage");
                                return (Criteria) this;
                                }

                                                                    public Criteria andBannerImageLike(String value) {
                                    addCriterion("BannerImage like", value, "bannerImage");
                                    return (Criteria) this;
                                    }

                                    public Criteria andBannerImageNotLike(String value) {
                                    addCriterion("BannerImage not like", value, "bannerImage");
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