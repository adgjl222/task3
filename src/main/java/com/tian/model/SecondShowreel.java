package com.tian.model;

public class SecondShowreel {
    private Integer secondShowreelId;

    private String secondShowreelName;

    private Integer secondShowreelState;

    private String firstShowreelName;

    private Long createdAt;

    private Long updatedAt;

    private Integer firstShowreelState;

    private String compileBy;

    public SecondShowreel(Integer secondShowreelId, String secondShowreelName, Integer secondShowreelState, String firstShowreelName, Long createdAt, Long updatedAt, Integer firstShowreelState, String compileBy) {
        this.secondShowreelId = secondShowreelId;
        this.secondShowreelName = secondShowreelName;
        this.secondShowreelState = secondShowreelState;
        this.firstShowreelName = firstShowreelName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.firstShowreelState = firstShowreelState;
        this.compileBy = compileBy;
    }

    public SecondShowreel() {
        super();
    }

    public Integer getSecondShowreelId() {
        return secondShowreelId;
    }

    public void setSecondShowreelId(Integer secondShowreelId) {
        this.secondShowreelId = secondShowreelId;
    }

    public String getSecondShowreelName() {
        return secondShowreelName;
    }

    public void setSecondShowreelName(String secondShowreelName) {
        this.secondShowreelName = secondShowreelName == null ? null : secondShowreelName.trim();
    }

    public Integer getSecondShowreelState() {
        return secondShowreelState;
    }

    public void setSecondShowreelState(Integer secondShowreelState) {
        this.secondShowreelState = secondShowreelState;
    }

    public String getFirstShowreelName() {
        return firstShowreelName;
    }

    public void setFirstShowreelName(String firstShowreelName) {
        this.firstShowreelName = firstShowreelName == null ? null : firstShowreelName.trim();
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getFirstShowreelState() {
        return firstShowreelState;
    }

    public void setFirstShowreelState(Integer firstShowreelState) {
        this.firstShowreelState = firstShowreelState;
    }

    public String getCompileBy() {
        return compileBy;
    }

    public void setCompileBy(String compileBy) {
        this.compileBy = compileBy == null ? null : compileBy.trim();
    }

    @Override
    public String toString() {
        return "SecondShowreel{" + "secondShowreelId=" + secondShowreelId + ", secondShowreelName='" + secondShowreelName + '\'' + ", secondShowreelState=" + secondShowreelState + ", firstShowreelName='" + firstShowreelName + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", firstShowreelState=" + firstShowreelState + ", compileBy='" + compileBy + '\'' + '}';
    }
}