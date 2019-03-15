package com.tian.model;

public class Leavewords {
    private Integer leavewordsId;

    private String lProductionName;

    private String visitorNickname;

    private String leavewords;

    private Integer leavewordsState;

    private String reply;

    private Long createdAt;

    private Long updatedAt;

    private String compileBy;

    private Integer lPronductionId;



    public Leavewords(Integer leavewordsId, String lProductionName, String visitorNickname, String leavewords, Integer leavewordsState, String reply, Long createdAt, Long updatedAt, String compileBy, Integer lPronductionId) {
        this.leavewordsId = leavewordsId;
        this.lProductionName = lProductionName;
        this.visitorNickname = visitorNickname;
        this.leavewords = leavewords;
        this.leavewordsState = leavewordsState;
        this.reply = reply;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.compileBy = compileBy;
        this.lPronductionId = lPronductionId;
    }

    public Leavewords() {
        super();
    }

    public Integer getLeavewordsId() {
        return leavewordsId;
    }

    public void setLeavewordsId(Integer leavewordsId) {
        this.leavewordsId = leavewordsId;
    }

    public String getlProductionName() {
        return lProductionName;
    }

    public void setlProductionName(String lProductionName) {
        this.lProductionName = lProductionName == null ? null : lProductionName.trim();
    }

    public String getVisitorNickname() {
        return visitorNickname;
    }

    public void setVisitorNickname(String visitorNickname) {
        this.visitorNickname = visitorNickname == null ? null : visitorNickname.trim();
    }

    public String getLeavewords() {
        return leavewords;
    }

    public void setLeavewords(String leavewords) {
        this.leavewords = leavewords == null ? null : leavewords.trim();
    }

    public Integer getLeavewordsState() {
        return leavewordsState;
    }

    public void setLeavewordsState(Integer leavewordsState) {
        this.leavewordsState = leavewordsState;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
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

    public String getCompileBy() {
        return compileBy;
    }

    public void setCompileBy(String compileBy) {
        this.compileBy = compileBy == null ? null : compileBy.trim();
    }

    public Integer getlPronductionId() {
        return lPronductionId;
    }

    public void setlPronductionId(Integer lPronductionId) {
        this.lPronductionId = lPronductionId;
    }


    @Override
    public String toString() {
        return "Leavewords{" + "leavewordsId=" + leavewordsId + ", lProductionName='" + lProductionName + '\'' + ", visitorNickname='" + visitorNickname + '\'' + ", leavewords='" + leavewords + '\'' + ", leavewordsState=" + leavewordsState + ", reply='" + reply + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", compileBy='" + compileBy + '\'' + ", lPronductionId=" + lPronductionId + '}';
    }
}