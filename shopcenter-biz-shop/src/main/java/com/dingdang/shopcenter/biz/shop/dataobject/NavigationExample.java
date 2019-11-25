package com.dingdang.shopcenter.biz.shop.dataobject;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NavigationExample {
protected String orderByClause;

protected boolean distinct;

protected List<Criteria> oredCriteria;

    public NavigationExample() {
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

                            
                                public Criteria andNavigationIdIsNull() {
                                addCriterion("NavigationId is null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdNotNull() {
                                addCriterion("NavigationId is not null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdEqualTo(Long value) {
                                addCriterion("NavigationId =", value, "navigationId");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdNotEqualTo(Long value) {
                                addCriterion("NavigationId <>", value, "navigationId");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdGreaterThan(Long value) {
                                addCriterion("NavigationId >", value, "navigationId");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdGreaterThanOrEqualTo(Long value) {
                                addCriterion("NavigationId >=", value, "navigationId");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdLessThan(Long value) {
                                addCriterion("NavigationId <", value, "navigationId");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdLessThanOrEqualTo(Long value) {
                                addCriterion("NavigationId <=", value, "navigationId");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdIn(List<Long> values) {
                                addCriterion("NavigationId in", values, "navigationId");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdNotIn(List<Long> values) {
                                addCriterion("NavigationId not in", values, "navigationId");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdBetween(Long value1, Long value2) {
                                addCriterion("NavigationId between", value1, value2, "navigationId");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationIdNotBetween(Long value1, Long value2) {
                                addCriterion("NavigationId not between", value1, value2, "navigationId");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andNavigationNameIsNull() {
                                addCriterion("NavigationName is null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameNotNull() {
                                addCriterion("NavigationName is not null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameEqualTo(String value) {
                                addCriterion("NavigationName =", value, "navigationName");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameNotEqualTo(String value) {
                                addCriterion("NavigationName <>", value, "navigationName");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameGreaterThan(String value) {
                                addCriterion("NavigationName >", value, "navigationName");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameGreaterThanOrEqualTo(String value) {
                                addCriterion("NavigationName >=", value, "navigationName");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameLessThan(String value) {
                                addCriterion("NavigationName <", value, "navigationName");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameLessThanOrEqualTo(String value) {
                                addCriterion("NavigationName <=", value, "navigationName");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameIn(List<String> values) {
                                addCriterion("NavigationName in", values, "navigationName");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameNotIn(List<String> values) {
                                addCriterion("NavigationName not in", values, "navigationName");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameBetween(String value1, String value2) {
                                addCriterion("NavigationName between", value1, value2, "navigationName");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationNameNotBetween(String value1, String value2) {
                                addCriterion("NavigationName not between", value1, value2, "navigationName");
                                return (Criteria) this;
                                }

                                                                    public Criteria andNavigationNameLike(String value) {
                                    addCriterion("NavigationName like", value, "navigationName");
                                    return (Criteria) this;
                                    }

                                    public Criteria andNavigationNameNotLike(String value) {
                                    addCriterion("NavigationName not like", value, "navigationName");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andNavigationImageIsNull() {
                                addCriterion("NavigationImage is null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageNotNull() {
                                addCriterion("NavigationImage is not null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageEqualTo(String value) {
                                addCriterion("NavigationImage =", value, "navigationImage");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageNotEqualTo(String value) {
                                addCriterion("NavigationImage <>", value, "navigationImage");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageGreaterThan(String value) {
                                addCriterion("NavigationImage >", value, "navigationImage");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageGreaterThanOrEqualTo(String value) {
                                addCriterion("NavigationImage >=", value, "navigationImage");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageLessThan(String value) {
                                addCriterion("NavigationImage <", value, "navigationImage");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageLessThanOrEqualTo(String value) {
                                addCriterion("NavigationImage <=", value, "navigationImage");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageIn(List<String> values) {
                                addCriterion("NavigationImage in", values, "navigationImage");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageNotIn(List<String> values) {
                                addCriterion("NavigationImage not in", values, "navigationImage");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageBetween(String value1, String value2) {
                                addCriterion("NavigationImage between", value1, value2, "navigationImage");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationImageNotBetween(String value1, String value2) {
                                addCriterion("NavigationImage not between", value1, value2, "navigationImage");
                                return (Criteria) this;
                                }

                                                                    public Criteria andNavigationImageLike(String value) {
                                    addCriterion("NavigationImage like", value, "navigationImage");
                                    return (Criteria) this;
                                    }

                                    public Criteria andNavigationImageNotLike(String value) {
                                    addCriterion("NavigationImage not like", value, "navigationImage");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andNavigationUrlIsNull() {
                                addCriterion("NavigationUrl is null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlNotNull() {
                                addCriterion("NavigationUrl is not null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlEqualTo(String value) {
                                addCriterion("NavigationUrl =", value, "navigationUrl");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlNotEqualTo(String value) {
                                addCriterion("NavigationUrl <>", value, "navigationUrl");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlGreaterThan(String value) {
                                addCriterion("NavigationUrl >", value, "navigationUrl");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlGreaterThanOrEqualTo(String value) {
                                addCriterion("NavigationUrl >=", value, "navigationUrl");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlLessThan(String value) {
                                addCriterion("NavigationUrl <", value, "navigationUrl");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlLessThanOrEqualTo(String value) {
                                addCriterion("NavigationUrl <=", value, "navigationUrl");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlIn(List<String> values) {
                                addCriterion("NavigationUrl in", values, "navigationUrl");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlNotIn(List<String> values) {
                                addCriterion("NavigationUrl not in", values, "navigationUrl");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlBetween(String value1, String value2) {
                                addCriterion("NavigationUrl between", value1, value2, "navigationUrl");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationUrlNotBetween(String value1, String value2) {
                                addCriterion("NavigationUrl not between", value1, value2, "navigationUrl");
                                return (Criteria) this;
                                }

                                                                    public Criteria andNavigationUrlLike(String value) {
                                    addCriterion("NavigationUrl like", value, "navigationUrl");
                                    return (Criteria) this;
                                    }

                                    public Criteria andNavigationUrlNotLike(String value) {
                                    addCriterion("NavigationUrl not like", value, "navigationUrl");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andNavigationDescIsNull() {
                                addCriterion("NavigationDesc is null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescNotNull() {
                                addCriterion("NavigationDesc is not null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescEqualTo(String value) {
                                addCriterion("NavigationDesc =", value, "navigationDesc");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescNotEqualTo(String value) {
                                addCriterion("NavigationDesc <>", value, "navigationDesc");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescGreaterThan(String value) {
                                addCriterion("NavigationDesc >", value, "navigationDesc");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescGreaterThanOrEqualTo(String value) {
                                addCriterion("NavigationDesc >=", value, "navigationDesc");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescLessThan(String value) {
                                addCriterion("NavigationDesc <", value, "navigationDesc");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescLessThanOrEqualTo(String value) {
                                addCriterion("NavigationDesc <=", value, "navigationDesc");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescIn(List<String> values) {
                                addCriterion("NavigationDesc in", values, "navigationDesc");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescNotIn(List<String> values) {
                                addCriterion("NavigationDesc not in", values, "navigationDesc");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescBetween(String value1, String value2) {
                                addCriterion("NavigationDesc between", value1, value2, "navigationDesc");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationDescNotBetween(String value1, String value2) {
                                addCriterion("NavigationDesc not between", value1, value2, "navigationDesc");
                                return (Criteria) this;
                                }

                                                                    public Criteria andNavigationDescLike(String value) {
                                    addCriterion("NavigationDesc like", value, "navigationDesc");
                                    return (Criteria) this;
                                    }

                                    public Criteria andNavigationDescNotLike(String value) {
                                    addCriterion("NavigationDesc not like", value, "navigationDesc");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andNavigationSortIsNull() {
                                addCriterion("NavigationSort is null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortNotNull() {
                                addCriterion("NavigationSort is not null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortEqualTo(Integer value) {
                                addCriterion("NavigationSort =", value, "navigationSort");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortNotEqualTo(Integer value) {
                                addCriterion("NavigationSort <>", value, "navigationSort");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortGreaterThan(Integer value) {
                                addCriterion("NavigationSort >", value, "navigationSort");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortGreaterThanOrEqualTo(Integer value) {
                                addCriterion("NavigationSort >=", value, "navigationSort");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortLessThan(Integer value) {
                                addCriterion("NavigationSort <", value, "navigationSort");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortLessThanOrEqualTo(Integer value) {
                                addCriterion("NavigationSort <=", value, "navigationSort");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortIn(List<Integer> values) {
                                addCriterion("NavigationSort in", values, "navigationSort");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortNotIn(List<Integer> values) {
                                addCriterion("NavigationSort not in", values, "navigationSort");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortBetween(Integer value1, Integer value2) {
                                addCriterion("NavigationSort between", value1, value2, "navigationSort");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationSortNotBetween(Integer value1, Integer value2) {
                                addCriterion("NavigationSort not between", value1, value2, "navigationSort");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andRemarkIsNull() {
                                addCriterion("Remark is null");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkNotNull() {
                                addCriterion("Remark is not null");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkEqualTo(String value) {
                                addCriterion("Remark =", value, "remark");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkNotEqualTo(String value) {
                                addCriterion("Remark <>", value, "remark");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkGreaterThan(String value) {
                                addCriterion("Remark >", value, "remark");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkGreaterThanOrEqualTo(String value) {
                                addCriterion("Remark >=", value, "remark");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkLessThan(String value) {
                                addCriterion("Remark <", value, "remark");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkLessThanOrEqualTo(String value) {
                                addCriterion("Remark <=", value, "remark");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkIn(List<String> values) {
                                addCriterion("Remark in", values, "remark");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkNotIn(List<String> values) {
                                addCriterion("Remark not in", values, "remark");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkBetween(String value1, String value2) {
                                addCriterion("Remark between", value1, value2, "remark");
                                return (Criteria) this;
                                }

                                public Criteria andRemarkNotBetween(String value1, String value2) {
                                addCriterion("Remark not between", value1, value2, "remark");
                                return (Criteria) this;
                                }

                                                                    public Criteria andRemarkLike(String value) {
                                    addCriterion("Remark like", value, "remark");
                                    return (Criteria) this;
                                    }

                                    public Criteria andRemarkNotLike(String value) {
                                    addCriterion("Remark not like", value, "remark");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andNavigationStatusIsNull() {
                                addCriterion("NavigationStatus is null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusNotNull() {
                                addCriterion("NavigationStatus is not null");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusEqualTo(Integer value) {
                                addCriterion("NavigationStatus =", value, "navigationStatus");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusNotEqualTo(Integer value) {
                                addCriterion("NavigationStatus <>", value, "navigationStatus");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusGreaterThan(Integer value) {
                                addCriterion("NavigationStatus >", value, "navigationStatus");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusGreaterThanOrEqualTo(Integer value) {
                                addCriterion("NavigationStatus >=", value, "navigationStatus");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusLessThan(Integer value) {
                                addCriterion("NavigationStatus <", value, "navigationStatus");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusLessThanOrEqualTo(Integer value) {
                                addCriterion("NavigationStatus <=", value, "navigationStatus");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusIn(List<Integer> values) {
                                addCriterion("NavigationStatus in", values, "navigationStatus");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusNotIn(List<Integer> values) {
                                addCriterion("NavigationStatus not in", values, "navigationStatus");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusBetween(Integer value1, Integer value2) {
                                addCriterion("NavigationStatus between", value1, value2, "navigationStatus");
                                return (Criteria) this;
                                }

                                public Criteria andNavigationStatusNotBetween(Integer value1, Integer value2) {
                                addCriterion("NavigationStatus not between", value1, value2, "navigationStatus");
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