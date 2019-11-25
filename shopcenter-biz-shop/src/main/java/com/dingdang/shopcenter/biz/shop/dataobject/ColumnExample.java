package com.dingdang.shopcenter.biz.shop.dataobject;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ColumnExample {
protected String orderByClause;

protected boolean distinct;

protected List<Criteria> oredCriteria;

    public ColumnExample() {
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

                                                            
                                public Criteria andColumnNameIsNull() {
                                addCriterion("ColumnName is null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameNotNull() {
                                addCriterion("ColumnName is not null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameEqualTo(String value) {
                                addCriterion("ColumnName =", value, "columnName");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameNotEqualTo(String value) {
                                addCriterion("ColumnName <>", value, "columnName");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameGreaterThan(String value) {
                                addCriterion("ColumnName >", value, "columnName");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameGreaterThanOrEqualTo(String value) {
                                addCriterion("ColumnName >=", value, "columnName");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameLessThan(String value) {
                                addCriterion("ColumnName <", value, "columnName");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameLessThanOrEqualTo(String value) {
                                addCriterion("ColumnName <=", value, "columnName");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameIn(List<String> values) {
                                addCriterion("ColumnName in", values, "columnName");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameNotIn(List<String> values) {
                                addCriterion("ColumnName not in", values, "columnName");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameBetween(String value1, String value2) {
                                addCriterion("ColumnName between", value1, value2, "columnName");
                                return (Criteria) this;
                                }

                                public Criteria andColumnNameNotBetween(String value1, String value2) {
                                addCriterion("ColumnName not between", value1, value2, "columnName");
                                return (Criteria) this;
                                }

                                                                    public Criteria andColumnNameLike(String value) {
                                    addCriterion("ColumnName like", value, "columnName");
                                    return (Criteria) this;
                                    }

                                    public Criteria andColumnNameNotLike(String value) {
                                    addCriterion("ColumnName not like", value, "columnName");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andColumnTypeIsNull() {
                                addCriterion("ColumnType is null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeNotNull() {
                                addCriterion("ColumnType is not null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeEqualTo(Integer value) {
                                addCriterion("ColumnType =", value, "columnType");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeNotEqualTo(Integer value) {
                                addCriterion("ColumnType <>", value, "columnType");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeGreaterThan(Integer value) {
                                addCriterion("ColumnType >", value, "columnType");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeGreaterThanOrEqualTo(Integer value) {
                                addCriterion("ColumnType >=", value, "columnType");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeLessThan(Integer value) {
                                addCriterion("ColumnType <", value, "columnType");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeLessThanOrEqualTo(Integer value) {
                                addCriterion("ColumnType <=", value, "columnType");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeIn(List<Integer> values) {
                                addCriterion("ColumnType in", values, "columnType");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeNotIn(List<Integer> values) {
                                addCriterion("ColumnType not in", values, "columnType");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeBetween(Integer value1, Integer value2) {
                                addCriterion("ColumnType between", value1, value2, "columnType");
                                return (Criteria) this;
                                }

                                public Criteria andColumnTypeNotBetween(Integer value1, Integer value2) {
                                addCriterion("ColumnType not between", value1, value2, "columnType");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andEnableIsNull() {
                                addCriterion("Enable is null");
                                return (Criteria) this;
                                }

                                public Criteria andEnableNotNull() {
                                addCriterion("Enable is not null");
                                return (Criteria) this;
                                }

                                public Criteria andEnableEqualTo(Integer value) {
                                addCriterion("Enable =", value, "enable");
                                return (Criteria) this;
                                }

                                public Criteria andEnableNotEqualTo(Integer value) {
                                addCriterion("Enable <>", value, "enable");
                                return (Criteria) this;
                                }

                                public Criteria andEnableGreaterThan(Integer value) {
                                addCriterion("Enable >", value, "enable");
                                return (Criteria) this;
                                }

                                public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
                                addCriterion("Enable >=", value, "enable");
                                return (Criteria) this;
                                }

                                public Criteria andEnableLessThan(Integer value) {
                                addCriterion("Enable <", value, "enable");
                                return (Criteria) this;
                                }

                                public Criteria andEnableLessThanOrEqualTo(Integer value) {
                                addCriterion("Enable <=", value, "enable");
                                return (Criteria) this;
                                }

                                public Criteria andEnableIn(List<Integer> values) {
                                addCriterion("Enable in", values, "enable");
                                return (Criteria) this;
                                }

                                public Criteria andEnableNotIn(List<Integer> values) {
                                addCriterion("Enable not in", values, "enable");
                                return (Criteria) this;
                                }

                                public Criteria andEnableBetween(Integer value1, Integer value2) {
                                addCriterion("Enable between", value1, value2, "enable");
                                return (Criteria) this;
                                }

                                public Criteria andEnableNotBetween(Integer value1, Integer value2) {
                                addCriterion("Enable not between", value1, value2, "enable");
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

                                                            
                                public Criteria andDirectionIsNull() {
                                addCriterion("Direction is null");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionNotNull() {
                                addCriterion("Direction is not null");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionEqualTo(String value) {
                                addCriterion("Direction =", value, "direction");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionNotEqualTo(String value) {
                                addCriterion("Direction <>", value, "direction");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionGreaterThan(String value) {
                                addCriterion("Direction >", value, "direction");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionGreaterThanOrEqualTo(String value) {
                                addCriterion("Direction >=", value, "direction");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionLessThan(String value) {
                                addCriterion("Direction <", value, "direction");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionLessThanOrEqualTo(String value) {
                                addCriterion("Direction <=", value, "direction");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionIn(List<String> values) {
                                addCriterion("Direction in", values, "direction");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionNotIn(List<String> values) {
                                addCriterion("Direction not in", values, "direction");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionBetween(String value1, String value2) {
                                addCriterion("Direction between", value1, value2, "direction");
                                return (Criteria) this;
                                }

                                public Criteria andDirectionNotBetween(String value1, String value2) {
                                addCriterion("Direction not between", value1, value2, "direction");
                                return (Criteria) this;
                                }

                                                                    public Criteria andDirectionLike(String value) {
                                    addCriterion("Direction like", value, "direction");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDirectionNotLike(String value) {
                                    addCriterion("Direction not like", value, "direction");
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

                                                            
                                public Criteria andStyleIsNull() {
                                addCriterion("Style is null");
                                return (Criteria) this;
                                }

                                public Criteria andStyleNotNull() {
                                addCriterion("Style is not null");
                                return (Criteria) this;
                                }

                                public Criteria andStyleEqualTo(String value) {
                                addCriterion("Style =", value, "style");
                                return (Criteria) this;
                                }

                                public Criteria andStyleNotEqualTo(String value) {
                                addCriterion("Style <>", value, "style");
                                return (Criteria) this;
                                }

                                public Criteria andStyleGreaterThan(String value) {
                                addCriterion("Style >", value, "style");
                                return (Criteria) this;
                                }

                                public Criteria andStyleGreaterThanOrEqualTo(String value) {
                                addCriterion("Style >=", value, "style");
                                return (Criteria) this;
                                }

                                public Criteria andStyleLessThan(String value) {
                                addCriterion("Style <", value, "style");
                                return (Criteria) this;
                                }

                                public Criteria andStyleLessThanOrEqualTo(String value) {
                                addCriterion("Style <=", value, "style");
                                return (Criteria) this;
                                }

                                public Criteria andStyleIn(List<String> values) {
                                addCriterion("Style in", values, "style");
                                return (Criteria) this;
                                }

                                public Criteria andStyleNotIn(List<String> values) {
                                addCriterion("Style not in", values, "style");
                                return (Criteria) this;
                                }

                                public Criteria andStyleBetween(String value1, String value2) {
                                addCriterion("Style between", value1, value2, "style");
                                return (Criteria) this;
                                }

                                public Criteria andStyleNotBetween(String value1, String value2) {
                                addCriterion("Style not between", value1, value2, "style");
                                return (Criteria) this;
                                }

                                                                    public Criteria andStyleLike(String value) {
                                    addCriterion("Style like", value, "style");
                                    return (Criteria) this;
                                    }

                                    public Criteria andStyleNotLike(String value) {
                                    addCriterion("Style not like", value, "style");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andNumberIsNull() {
                                addCriterion("Number is null");
                                return (Criteria) this;
                                }

                                public Criteria andNumberNotNull() {
                                addCriterion("Number is not null");
                                return (Criteria) this;
                                }

                                public Criteria andNumberEqualTo(Integer value) {
                                addCriterion("Number =", value, "number");
                                return (Criteria) this;
                                }

                                public Criteria andNumberNotEqualTo(Integer value) {
                                addCriterion("Number <>", value, "number");
                                return (Criteria) this;
                                }

                                public Criteria andNumberGreaterThan(Integer value) {
                                addCriterion("Number >", value, "number");
                                return (Criteria) this;
                                }

                                public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
                                addCriterion("Number >=", value, "number");
                                return (Criteria) this;
                                }

                                public Criteria andNumberLessThan(Integer value) {
                                addCriterion("Number <", value, "number");
                                return (Criteria) this;
                                }

                                public Criteria andNumberLessThanOrEqualTo(Integer value) {
                                addCriterion("Number <=", value, "number");
                                return (Criteria) this;
                                }

                                public Criteria andNumberIn(List<Integer> values) {
                                addCriterion("Number in", values, "number");
                                return (Criteria) this;
                                }

                                public Criteria andNumberNotIn(List<Integer> values) {
                                addCriterion("Number not in", values, "number");
                                return (Criteria) this;
                                }

                                public Criteria andNumberBetween(Integer value1, Integer value2) {
                                addCriterion("Number between", value1, value2, "number");
                                return (Criteria) this;
                                }

                                public Criteria andNumberNotBetween(Integer value1, Integer value2) {
                                addCriterion("Number not between", value1, value2, "number");
                                return (Criteria) this;
                                }

                                                            
                                public Criteria andColumnUrlIsNull() {
                                addCriterion("ColumnUrl is null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlNotNull() {
                                addCriterion("ColumnUrl is not null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlEqualTo(String value) {
                                addCriterion("ColumnUrl =", value, "columnUrl");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlNotEqualTo(String value) {
                                addCriterion("ColumnUrl <>", value, "columnUrl");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlGreaterThan(String value) {
                                addCriterion("ColumnUrl >", value, "columnUrl");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlGreaterThanOrEqualTo(String value) {
                                addCriterion("ColumnUrl >=", value, "columnUrl");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlLessThan(String value) {
                                addCriterion("ColumnUrl <", value, "columnUrl");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlLessThanOrEqualTo(String value) {
                                addCriterion("ColumnUrl <=", value, "columnUrl");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlIn(List<String> values) {
                                addCriterion("ColumnUrl in", values, "columnUrl");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlNotIn(List<String> values) {
                                addCriterion("ColumnUrl not in", values, "columnUrl");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlBetween(String value1, String value2) {
                                addCriterion("ColumnUrl between", value1, value2, "columnUrl");
                                return (Criteria) this;
                                }

                                public Criteria andColumnUrlNotBetween(String value1, String value2) {
                                addCriterion("ColumnUrl not between", value1, value2, "columnUrl");
                                return (Criteria) this;
                                }

                                                                    public Criteria andColumnUrlLike(String value) {
                                    addCriterion("ColumnUrl like", value, "columnUrl");
                                    return (Criteria) this;
                                    }

                                    public Criteria andColumnUrlNotLike(String value) {
                                    addCriterion("ColumnUrl not like", value, "columnUrl");
                                    return (Criteria) this;
                                    }
                                                            
                                public Criteria andColumnImageIsNull() {
                                addCriterion("ColumnImage is null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageNotNull() {
                                addCriterion("ColumnImage is not null");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageEqualTo(String value) {
                                addCriterion("ColumnImage =", value, "columnImage");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageNotEqualTo(String value) {
                                addCriterion("ColumnImage <>", value, "columnImage");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageGreaterThan(String value) {
                                addCriterion("ColumnImage >", value, "columnImage");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageGreaterThanOrEqualTo(String value) {
                                addCriterion("ColumnImage >=", value, "columnImage");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageLessThan(String value) {
                                addCriterion("ColumnImage <", value, "columnImage");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageLessThanOrEqualTo(String value) {
                                addCriterion("ColumnImage <=", value, "columnImage");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageIn(List<String> values) {
                                addCriterion("ColumnImage in", values, "columnImage");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageNotIn(List<String> values) {
                                addCriterion("ColumnImage not in", values, "columnImage");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageBetween(String value1, String value2) {
                                addCriterion("ColumnImage between", value1, value2, "columnImage");
                                return (Criteria) this;
                                }

                                public Criteria andColumnImageNotBetween(String value1, String value2) {
                                addCriterion("ColumnImage not between", value1, value2, "columnImage");
                                return (Criteria) this;
                                }

                                                                    public Criteria andColumnImageLike(String value) {
                                    addCriterion("ColumnImage like", value, "columnImage");
                                    return (Criteria) this;
                                    }

                                    public Criteria andColumnImageNotLike(String value) {
                                    addCriterion("ColumnImage not like", value, "columnImage");
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