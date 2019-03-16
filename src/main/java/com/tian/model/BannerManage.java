package com.tian.model;


public class BannerManage {
    private Integer bannerId;

    private String bannerConver;

    private String compileBy;

    private String url;

    private Integer bannerState;

    private Long createdAt;

    private Long updatedAt;

    public BannerManage(Integer bannerId, String bannerConver, String compileBy, String url, Integer bannerState, Long createdAt, Long updatedAt) {
        this.bannerId = bannerId;
        this.bannerConver = bannerConver;
        this.compileBy = compileBy;
        this.url = url;
        this.bannerState = bannerState;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BannerManage() {
        super();
    }

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerConver() {
        return bannerConver;
    }

    public void setBannerConver(String bannerConver) {
        this.bannerConver = bannerConver == null ? null : bannerConver.trim();
    }

    public String getCompileBy() {
        return compileBy;
    }

    public void setCompileBy(String compileBy) {
        this.compileBy = compileBy == null ? null : compileBy.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getBannerState() {
        return bannerState;
    }

    public void setBannerState(Integer bannerState) {
        this.bannerState = bannerState;
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
        return "BannerManage{" + "bannerId=" + bannerId + ", bannerConver='" + bannerConver + '\'' + ", compileBy='" + compileBy + '\'' + ", url='" + url + '\'' + ", bannerState=" + bannerState + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

}