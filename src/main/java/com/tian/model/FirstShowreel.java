package com.tian.model;

public class FirstShowreel {
    private Integer firstShowreelId;

    private String firstShowreelName;

    private Integer firstShowreelState;

    private String compileBy;

    private String secondShowreelName;

    private Long createdAt;

    private Long updatedAt;

    public FirstShowreel(Integer firstShowreelId, String firstShowreelName, Integer firstShowreelState, String compileBy, String secondShowreelName, Long createdAt, Long updatedAt) {
        this.firstShowreelId = firstShowreelId;
        this.firstShowreelName = firstShowreelName;
        this.firstShowreelState = firstShowreelState;
        this.compileBy = compileBy;
        this.secondShowreelName = secondShowreelName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public FirstShowreel() {
        super();
    }

    public Integer getFirstShowreelId() {
        return firstShowreelId;
    }

    public void setFirstShowreelId(Integer firstShowreelId) {
        this.firstShowreelId = firstShowreelId;
    }

    public String getFirstShowreelName() {
        return firstShowreelName;
    }

    public void setFirstShowreelName(String firstShowreelName) {
        this.firstShowreelName = firstShowreelName == null ? null : firstShowreelName.trim();
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

    public String getSecondShowreelName() {
        return secondShowreelName;
    }

    public void setSecondShowreelName(String secondShowreelName) {
        this.secondShowreelName = secondShowreelName == null ? null : secondShowreelName.trim();
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

    @Override
    public String toString() {
        return "FirstShowreel{" + "firstShowreelId=" + firstShowreelId + ", firstShowreelName='" + firstShowreelName + '\'' + ", firstShowreelState=" + firstShowreelState + ", compileBy='" + compileBy + '\'' + ", secondShowreelName='" + secondShowreelName + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}