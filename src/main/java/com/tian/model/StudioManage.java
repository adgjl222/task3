package com.tian.model;

public class StudioManage {
    private Integer studioId;

    private String studioType;

    private Integer studioState;

    private String compileBy;

    private Long createdAt;

    private Long updatedAt;

    private String studioPictures;

    private String studioBody;

    public StudioManage(Integer studioId, String studioType, Integer studioState, String compileBy, Long createdAt, Long updatedAt, String studioPictures, String studioBody) {
        this.studioId = studioId;
        this.studioType = studioType;
        this.studioState = studioState;
        this.compileBy = compileBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.studioPictures = studioPictures;
        this.studioBody = studioBody;
    }

    public StudioManage() {
        super();
    }

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    public String getStudioType() {
        return studioType;
    }

    public void setStudioType(String studioType) {
        this.studioType = studioType;
    }

    public Integer getStudioState() {
        return studioState;
    }

    public void setStudioState(Integer studioState) {
        this.studioState = studioState;
    }

    public String getCompileBy() {
        return compileBy;
    }

    public void setCompileBy(String compileBy) {
        this.compileBy = compileBy == null ? null : compileBy.trim();
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

    public String getStudioPictures() {
        return studioPictures;
    }

    public void setStudioPictures(String studioPictures) {
        this.studioPictures = studioPictures == null ? null : studioPictures.trim();
    }

    public String getStudioBody() {
        return studioBody;
    }

    public void setStudioBody(String studioBody) {
        this.studioBody = studioBody == null ? null : studioBody.trim();
    }

    @Override
    public String toString() {
        return "StudioManage{" + "studioId=" + studioId + ", studioType='" + studioType + '\'' + ", studioState=" + studioState + ", compileBy='" + compileBy + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", studioPictures='" + studioPictures + '\'' + ", studioBody='" + studioBody + '\'' + '}';
    }
}