package generator;

import java.util.ArrayList;
import java.util.List;

public class CompetitionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public CompetitionExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andHostIsNull() {
            addCriterion("`host` is null");
            return (Criteria) this;
        }

        public Criteria andHostIsNotNull() {
            addCriterion("`host` is not null");
            return (Criteria) this;
        }

        public Criteria andHostEqualTo(Integer value) {
            addCriterion("`host` =", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotEqualTo(Integer value) {
            addCriterion("`host` <>", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThan(Integer value) {
            addCriterion("`host` >", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThanOrEqualTo(Integer value) {
            addCriterion("`host` >=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThan(Integer value) {
            addCriterion("`host` <", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThanOrEqualTo(Integer value) {
            addCriterion("`host` <=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostIn(List<Integer> values) {
            addCriterion("`host` in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotIn(List<Integer> values) {
            addCriterion("`host` not in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostBetween(Integer value1, Integer value2) {
            addCriterion("`host` between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotBetween(Integer value1, Integer value2) {
            addCriterion("`host` not between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andGuestIsNull() {
            addCriterion("guest is null");
            return (Criteria) this;
        }

        public Criteria andGuestIsNotNull() {
            addCriterion("guest is not null");
            return (Criteria) this;
        }

        public Criteria andGuestEqualTo(Integer value) {
            addCriterion("guest =", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestNotEqualTo(Integer value) {
            addCriterion("guest <>", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestGreaterThan(Integer value) {
            addCriterion("guest >", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestGreaterThanOrEqualTo(Integer value) {
            addCriterion("guest >=", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestLessThan(Integer value) {
            addCriterion("guest <", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestLessThanOrEqualTo(Integer value) {
            addCriterion("guest <=", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestIn(List<Integer> values) {
            addCriterion("guest in", values, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestNotIn(List<Integer> values) {
            addCriterion("guest not in", values, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestBetween(Integer value1, Integer value2) {
            addCriterion("guest between", value1, value2, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestNotBetween(Integer value1, Integer value2) {
            addCriterion("guest not between", value1, value2, "guest");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("`time` is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("`time` is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("`time` =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("`time` <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("`time` >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("`time` >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("`time` <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("`time` <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("`time` like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("`time` not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("`time` in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("`time` not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("`time` between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("`time` not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(String value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(String value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(String value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(String value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(String value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLike(String value) {
            addCriterion("platform like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotLike(String value) {
            addCriterion("platform not like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<String> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<String> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(String value1, String value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(String value1, String value2) {
            addCriterion("platform not between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andHostScoresIsNull() {
            addCriterion("`host_ scores` is null");
            return (Criteria) this;
        }

        public Criteria andHostScoresIsNotNull() {
            addCriterion("`host_ scores` is not null");
            return (Criteria) this;
        }

        public Criteria andHostScoresEqualTo(Integer value) {
            addCriterion("`host_ scores` =", value, "hostScores");
            return (Criteria) this;
        }

        public Criteria andHostScoresNotEqualTo(Integer value) {
            addCriterion("`host_ scores` <>", value, "hostScores");
            return (Criteria) this;
        }

        public Criteria andHostScoresGreaterThan(Integer value) {
            addCriterion("`host_ scores` >", value, "hostScores");
            return (Criteria) this;
        }

        public Criteria andHostScoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("`host_ scores` >=", value, "hostScores");
            return (Criteria) this;
        }

        public Criteria andHostScoresLessThan(Integer value) {
            addCriterion("`host_ scores` <", value, "hostScores");
            return (Criteria) this;
        }

        public Criteria andHostScoresLessThanOrEqualTo(Integer value) {
            addCriterion("`host_ scores` <=", value, "hostScores");
            return (Criteria) this;
        }

        public Criteria andHostScoresIn(List<Integer> values) {
            addCriterion("`host_ scores` in", values, "hostScores");
            return (Criteria) this;
        }

        public Criteria andHostScoresNotIn(List<Integer> values) {
            addCriterion("`host_ scores` not in", values, "hostScores");
            return (Criteria) this;
        }

        public Criteria andHostScoresBetween(Integer value1, Integer value2) {
            addCriterion("`host_ scores` between", value1, value2, "hostScores");
            return (Criteria) this;
        }

        public Criteria andHostScoresNotBetween(Integer value1, Integer value2) {
            addCriterion("`host_ scores` not between", value1, value2, "hostScores");
            return (Criteria) this;
        }

        public Criteria andGuestScoresIsNull() {
            addCriterion("`guest_ scores` is null");
            return (Criteria) this;
        }

        public Criteria andGuestScoresIsNotNull() {
            addCriterion("`guest_ scores` is not null");
            return (Criteria) this;
        }

        public Criteria andGuestScoresEqualTo(Integer value) {
            addCriterion("`guest_ scores` =", value, "guestScores");
            return (Criteria) this;
        }

        public Criteria andGuestScoresNotEqualTo(Integer value) {
            addCriterion("`guest_ scores` <>", value, "guestScores");
            return (Criteria) this;
        }

        public Criteria andGuestScoresGreaterThan(Integer value) {
            addCriterion("`guest_ scores` >", value, "guestScores");
            return (Criteria) this;
        }

        public Criteria andGuestScoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("`guest_ scores` >=", value, "guestScores");
            return (Criteria) this;
        }

        public Criteria andGuestScoresLessThan(Integer value) {
            addCriterion("`guest_ scores` <", value, "guestScores");
            return (Criteria) this;
        }

        public Criteria andGuestScoresLessThanOrEqualTo(Integer value) {
            addCriterion("`guest_ scores` <=", value, "guestScores");
            return (Criteria) this;
        }

        public Criteria andGuestScoresIn(List<Integer> values) {
            addCriterion("`guest_ scores` in", values, "guestScores");
            return (Criteria) this;
        }

        public Criteria andGuestScoresNotIn(List<Integer> values) {
            addCriterion("`guest_ scores` not in", values, "guestScores");
            return (Criteria) this;
        }

        public Criteria andGuestScoresBetween(Integer value1, Integer value2) {
            addCriterion("`guest_ scores` between", value1, value2, "guestScores");
            return (Criteria) this;
        }

        public Criteria andGuestScoresNotBetween(Integer value1, Integer value2) {
            addCriterion("`guest_ scores` not between", value1, value2, "guestScores");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("`state` like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("`state` not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    /**
     */
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