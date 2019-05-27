package com.b328.blockchain.entity;

import java.util.Date;

public class Contract {
    private Long id;
    private String partyA;
    private String partyB;
    private Date createDate;
    private Boolean isPartyASigned;
    private Boolean isPartyBSigned;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getPartyASigned() {
        return isPartyASigned;
    }

    public void setPartyASigned(Boolean partyASigned) {
        isPartyASigned = partyASigned;
    }

    public Boolean getPartyBSigned() {
        return isPartyBSigned;
    }

    public void setPartyBSigned(Boolean partyBSigned) {
        isPartyBSigned = partyBSigned;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
