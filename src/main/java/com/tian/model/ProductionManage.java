package com.tian.model;

public class ProductionManage {
    private Integer productionId;

    private String productionName;

    private String belongFirstShowreel;

    private String belongSecondShowreel;

    private Integer productionState;

    private String compileBy;

    private Long createdAt;

    private Long updatedAt;

    private String intro;

    private String thumbnail;

    private String videoUrl;

    private String particulars;

    private String introduce;

    private String productionLeavewords;

    public ProductionManage(Integer productionId, String productionName, String belongFirstShowreel, String belongSecondShowreel, Integer productionState, String compileBy, Long createdAt, Long updatedAt, String intro, String thumbnail, String videoUrl, String particulars, String introduce, String productionLeavewords) {
        this.productionId = productionId;
        this.productionName = productionName;
        this.belongFirstShowreel = belongFirstShowreel;
        this.belongSecondShowreel = belongSecondShowreel;
        this.productionState = productionState;
        this.compileBy = compileBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.intro = intro;
        this.thumbnail = thumbnail;
        this.videoUrl = videoUrl;
        this.particulars = particulars;
        this.introduce = introduce;
        this.productionLeavewords = productionLeavewords;
    }

    public ProductionManage() {
        super();
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName == null ? null : productionName.trim();
    }

    public String getBelongFirstShowreel() {
        return belongFirstShowreel;
    }

    public void setBelongFirstShowreel(String belongFirstShowreel) {
        this.belongFirstShowreel = belongFirstShowreel == null ? null : belongFirstShowreel.trim();
    }

    public String getBelongSecondShowreel() {
        return belongSecondShowreel;
    }

    public void setBelongSecondShowreel(String belongSecondShowreel) {
        this.belongSecondShowreel = belongSecondShowreel == null ? null : belongSecondShowreel.trim();
    }

    public Integer getProductionState() {
        return productionState;
    }

    public void setProductionState(Integer productionState) {
        this.productionState = productionState;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars == null ? null : particulars.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getProductionLeavewords() {
        return productionLeavewords;
    }

    public void setProductionLeavewords(String productionLeavewords) {
        this.productionLeavewords = productionLeavewords == null ? null : productionLeavewords.trim();
    }

    @Override
    public String toString() {
        return "ProductionManage{" + "productionId=" + productionId + ", productionName='" + productionName + '\'' + ", belongFirstShowreel='" + belongFirstShowreel + '\'' + ", belongSecondShowreel='" + belongSecondShowreel + '\'' + ", productionState=" + productionState + ", compileBy='" + compileBy + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", intro='" + intro + '\'' + ", thumbnail='" + thumbnail + '\'' + ", videoUrl='" + videoUrl + '\'' + ", particulars='" + particulars + '\'' + ", introduce='" + introduce + '\'' + ", productionLeavewords='" + productionLeavewords + '\'' + '}';
    }
}