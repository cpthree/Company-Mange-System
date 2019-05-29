package com.ms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLandAreaIsNull() {
            addCriterion("land_area is null");
            return (Criteria) this;
        }

        public Criteria andLandAreaIsNotNull() {
            addCriterion("land_area is not null");
            return (Criteria) this;
        }

        public Criteria andLandAreaEqualTo(Long value) {
            addCriterion("land_area =", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaNotEqualTo(Long value) {
            addCriterion("land_area <>", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaGreaterThan(Long value) {
            addCriterion("land_area >", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaGreaterThanOrEqualTo(Long value) {
            addCriterion("land_area >=", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaLessThan(Long value) {
            addCriterion("land_area <", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaLessThanOrEqualTo(Long value) {
            addCriterion("land_area <=", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaIn(List<Long> values) {
            addCriterion("land_area in", values, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaNotIn(List<Long> values) {
            addCriterion("land_area not in", values, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaBetween(Long value1, Long value2) {
            addCriterion("land_area between", value1, value2, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaNotBetween(Long value1, Long value2) {
            addCriterion("land_area not between", value1, value2, "landArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNull() {
            addCriterion("build_area is null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNotNull() {
            addCriterion("build_area is not null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaEqualTo(Long value) {
            addCriterion("build_area =", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotEqualTo(Long value) {
            addCriterion("build_area <>", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThan(Long value) {
            addCriterion("build_area >", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThanOrEqualTo(Long value) {
            addCriterion("build_area >=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThan(Long value) {
            addCriterion("build_area <", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThanOrEqualTo(Long value) {
            addCriterion("build_area <=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIn(List<Long> values) {
            addCriterion("build_area in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotIn(List<Long> values) {
            addCriterion("build_area not in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaBetween(Long value1, Long value2) {
            addCriterion("build_area between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotBetween(Long value1, Long value2) {
            addCriterion("build_area not between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(Integer value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(Integer value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(Integer value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(Integer value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(Integer value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<Integer> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<Integer> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(Integer value1, Integer value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleIsNull() {
            addCriterion("eia_people is null");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleIsNotNull() {
            addCriterion("eia_people is not null");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleEqualTo(String value) {
            addCriterion("eia_people =", value, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleNotEqualTo(String value) {
            addCriterion("eia_people <>", value, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleGreaterThan(String value) {
            addCriterion("eia_people >", value, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("eia_people >=", value, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleLessThan(String value) {
            addCriterion("eia_people <", value, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleLessThanOrEqualTo(String value) {
            addCriterion("eia_people <=", value, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleLike(String value) {
            addCriterion("eia_people like", value, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleNotLike(String value) {
            addCriterion("eia_people not like", value, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleIn(List<String> values) {
            addCriterion("eia_people in", values, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleNotIn(List<String> values) {
            addCriterion("eia_people not in", values, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleBetween(String value1, String value2) {
            addCriterion("eia_people between", value1, value2, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andEiaPeopleNotBetween(String value1, String value2) {
            addCriterion("eia_people not between", value1, value2, "eiaPeople");
            return (Criteria) this;
        }

        public Criteria andPermitIsNull() {
            addCriterion("permit is null");
            return (Criteria) this;
        }

        public Criteria andPermitIsNotNull() {
            addCriterion("permit is not null");
            return (Criteria) this;
        }

        public Criteria andPermitEqualTo(String value) {
            addCriterion("permit =", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitNotEqualTo(String value) {
            addCriterion("permit <>", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitGreaterThan(String value) {
            addCriterion("permit >", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitGreaterThanOrEqualTo(String value) {
            addCriterion("permit >=", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitLessThan(String value) {
            addCriterion("permit <", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitLessThanOrEqualTo(String value) {
            addCriterion("permit <=", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitLike(String value) {
            addCriterion("permit like", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitNotLike(String value) {
            addCriterion("permit not like", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitIn(List<String> values) {
            addCriterion("permit in", values, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitNotIn(List<String> values) {
            addCriterion("permit not in", values, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitBetween(String value1, String value2) {
            addCriterion("permit between", value1, value2, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitNotBetween(String value1, String value2) {
            addCriterion("permit not between", value1, value2, "permit");
            return (Criteria) this;
        }

        public Criteria andAuditFlagIsNull() {
            addCriterion("audit_flag is null");
            return (Criteria) this;
        }

        public Criteria andAuditFlagIsNotNull() {
            addCriterion("audit_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAuditFlagEqualTo(Integer value) {
            addCriterion("audit_flag =", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagNotEqualTo(Integer value) {
            addCriterion("audit_flag <>", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagGreaterThan(Integer value) {
            addCriterion("audit_flag >", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_flag >=", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagLessThan(Integer value) {
            addCriterion("audit_flag <", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagLessThanOrEqualTo(Integer value) {
            addCriterion("audit_flag <=", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagIn(List<Integer> values) {
            addCriterion("audit_flag in", values, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagNotIn(List<Integer> values) {
            addCriterion("audit_flag not in", values, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagBetween(Integer value1, Integer value2) {
            addCriterion("audit_flag between", value1, value2, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_flag not between", value1, value2, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andSuccessDateIsNull() {
            addCriterion("success_date is null");
            return (Criteria) this;
        }

        public Criteria andSuccessDateIsNotNull() {
            addCriterion("success_date is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessDateEqualTo(Date value) {
            addCriterion("success_date =", value, "successDate");
            return (Criteria) this;
        }

        public Criteria andSuccessDateNotEqualTo(Date value) {
            addCriterion("success_date <>", value, "successDate");
            return (Criteria) this;
        }

        public Criteria andSuccessDateGreaterThan(Date value) {
            addCriterion("success_date >", value, "successDate");
            return (Criteria) this;
        }

        public Criteria andSuccessDateGreaterThanOrEqualTo(Date value) {
            addCriterion("success_date >=", value, "successDate");
            return (Criteria) this;
        }

        public Criteria andSuccessDateLessThan(Date value) {
            addCriterion("success_date <", value, "successDate");
            return (Criteria) this;
        }

        public Criteria andSuccessDateLessThanOrEqualTo(Date value) {
            addCriterion("success_date <=", value, "successDate");
            return (Criteria) this;
        }

        public Criteria andSuccessDateIn(List<Date> values) {
            addCriterion("success_date in", values, "successDate");
            return (Criteria) this;
        }

        public Criteria andSuccessDateNotIn(List<Date> values) {
            addCriterion("success_date not in", values, "successDate");
            return (Criteria) this;
        }

        public Criteria andSuccessDateBetween(Date value1, Date value2) {
            addCriterion("success_date between", value1, value2, "successDate");
            return (Criteria) this;
        }

        public Criteria andSuccessDateNotBetween(Date value1, Date value2) {
            addCriterion("success_date not between", value1, value2, "successDate");
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