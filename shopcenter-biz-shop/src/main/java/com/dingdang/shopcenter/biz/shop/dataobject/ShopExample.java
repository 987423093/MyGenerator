package com.dingdang.shopcenter.biz.shop.dataobject;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopExample {
protected String orderByClause;

protected boolean distinct;

protected List<Criteria> oredCriteria;

    public ShopExample() {
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

                            
                                public Criteria andShopIdIsNull() {
                                addCriterion("ShopId is null");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdNotNull() {
                                addCriterion("ShopId is not null");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdEqualTo(Long value) {
                                addCriterion("ShopId =", value, "shopId");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdNotEqualTo(Long value) {
                                addCriterion("ShopId <>", value, "shopId");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdGreaterThan(Long value) {
                                addCriterion("ShopId >", value, "shopId");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
                                addCriterion("ShopId >=", value, "shopId");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdLessThan(Long value) {
                                addCriterion("ShopId <", value, "shopId");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdLessThanOrEqualTo(Long value) {
                                addCriterion("ShopId <=", value, "shopId");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdIn(List<Long> values) {
                                addCriterion("ShopId in", values, "shopId");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdNotIn(List<Long> values) {
                                addCriterion("ShopId not in", values, "shopId");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdBetween(Long value1, Long value2) {
                                addCriterion("ShopId between", value1, value2, "shopId");
                                return (Criteria) this;
                                }

                                public Criteria andShopIdNotBetween(Long value1, Long value2) {
                                addCriterion("ShopId not between", value1, value2, "shopId");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andShopNameIsNull() {
                                addCriterion("ShopName is null");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameNotNull() {
                                addCriterion("ShopName is not null");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameEqualTo(String value) {
                                addCriterion("ShopName =", value, "shopName");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameNotEqualTo(String value) {
                                addCriterion("ShopName <>", value, "shopName");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameGreaterThan(String value) {
                                addCriterion("ShopName >", value, "shopName");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameGreaterThanOrEqualTo(String value) {
                                addCriterion("ShopName >=", value, "shopName");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameLessThan(String value) {
                                addCriterion("ShopName <", value, "shopName");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameLessThanOrEqualTo(String value) {
                                addCriterion("ShopName <=", value, "shopName");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameIn(List<String> values) {
                                addCriterion("ShopName in", values, "shopName");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameNotIn(List<String> values) {
                                addCriterion("ShopName not in", values, "shopName");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameBetween(String value1, String value2) {
                                addCriterion("ShopName between", value1, value2, "shopName");
                                return (Criteria) this;
                                }

                                public Criteria andShopNameNotBetween(String value1, String value2) {
                                addCriterion("ShopName not between", value1, value2, "shopName");
                                return (Criteria) this;
                                }

                                                                    public Criteria andShopNameLike(String value) {
                                    addCriterion("ShopName like", value, "shopName");
                                    return (Criteria) this;
                                    }

                                    public Criteria andShopNameNotLike(String value) {
                                    addCriterion("ShopName not like", value, "shopName");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andShopTypeIsNull() {
                                addCriterion("ShopType is null");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeNotNull() {
                                addCriterion("ShopType is not null");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeEqualTo(Integer value) {
                                addCriterion("ShopType =", value, "shopType");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeNotEqualTo(Integer value) {
                                addCriterion("ShopType <>", value, "shopType");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeGreaterThan(Integer value) {
                                addCriterion("ShopType >", value, "shopType");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeGreaterThanOrEqualTo(Integer value) {
                                addCriterion("ShopType >=", value, "shopType");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeLessThan(Integer value) {
                                addCriterion("ShopType <", value, "shopType");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeLessThanOrEqualTo(Integer value) {
                                addCriterion("ShopType <=", value, "shopType");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeIn(List<Integer> values) {
                                addCriterion("ShopType in", values, "shopType");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeNotIn(List<Integer> values) {
                                addCriterion("ShopType not in", values, "shopType");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeBetween(Integer value1, Integer value2) {
                                addCriterion("ShopType between", value1, value2, "shopType");
                                return (Criteria) this;
                                }

                                public Criteria andShopTypeNotBetween(Integer value1, Integer value2) {
                                addCriterion("ShopType not between", value1, value2, "shopType");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andShopLogoIsNull() {
                                addCriterion("ShopLogo is null");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoNotNull() {
                                addCriterion("ShopLogo is not null");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoEqualTo(String value) {
                                addCriterion("ShopLogo =", value, "shopLogo");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoNotEqualTo(String value) {
                                addCriterion("ShopLogo <>", value, "shopLogo");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoGreaterThan(String value) {
                                addCriterion("ShopLogo >", value, "shopLogo");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoGreaterThanOrEqualTo(String value) {
                                addCriterion("ShopLogo >=", value, "shopLogo");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoLessThan(String value) {
                                addCriterion("ShopLogo <", value, "shopLogo");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoLessThanOrEqualTo(String value) {
                                addCriterion("ShopLogo <=", value, "shopLogo");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoIn(List<String> values) {
                                addCriterion("ShopLogo in", values, "shopLogo");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoNotIn(List<String> values) {
                                addCriterion("ShopLogo not in", values, "shopLogo");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoBetween(String value1, String value2) {
                                addCriterion("ShopLogo between", value1, value2, "shopLogo");
                                return (Criteria) this;
                                }

                                public Criteria andShopLogoNotBetween(String value1, String value2) {
                                addCriterion("ShopLogo not between", value1, value2, "shopLogo");
                                return (Criteria) this;
                                }

                                                                    public Criteria andShopLogoLike(String value) {
                                    addCriterion("ShopLogo like", value, "shopLogo");
                                    return (Criteria) this;
                                    }

                                    public Criteria andShopLogoNotLike(String value) {
                                    addCriterion("ShopLogo not like", value, "shopLogo");
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

                                                            
                                public Criteria andMerchantNoIsNull() {
                                addCriterion("MerchantNo is null");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoNotNull() {
                                addCriterion("MerchantNo is not null");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoEqualTo(String value) {
                                addCriterion("MerchantNo =", value, "merchantNo");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoNotEqualTo(String value) {
                                addCriterion("MerchantNo <>", value, "merchantNo");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoGreaterThan(String value) {
                                addCriterion("MerchantNo >", value, "merchantNo");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
                                addCriterion("MerchantNo >=", value, "merchantNo");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoLessThan(String value) {
                                addCriterion("MerchantNo <", value, "merchantNo");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoLessThanOrEqualTo(String value) {
                                addCriterion("MerchantNo <=", value, "merchantNo");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoIn(List<String> values) {
                                addCriterion("MerchantNo in", values, "merchantNo");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoNotIn(List<String> values) {
                                addCriterion("MerchantNo not in", values, "merchantNo");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoBetween(String value1, String value2) {
                                addCriterion("MerchantNo between", value1, value2, "merchantNo");
                                return (Criteria) this;
                                }

                                public Criteria andMerchantNoNotBetween(String value1, String value2) {
                                addCriterion("MerchantNo not between", value1, value2, "merchantNo");
                                return (Criteria) this;
                                }

                                                                    public Criteria andMerchantNoLike(String value) {
                                    addCriterion("MerchantNo like", value, "merchantNo");
                                    return (Criteria) this;
                                    }

                                    public Criteria andMerchantNoNotLike(String value) {
                                    addCriterion("MerchantNo not like", value, "merchantNo");
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