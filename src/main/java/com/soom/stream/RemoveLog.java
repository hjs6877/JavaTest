package com.soom.stream;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2016-11-29 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class RemoveLog {
    private String mymubmerId;
    private String userNm;
    private String birthDate;
    private String relation;
    private String removeTarget;
    private String proofNm;
    private String removeDate;

    public RemoveLog(String mynumberId, String userNm, String birthDate, String relation, String removeTarget, String proofNm, String removeDate) {
        this.mymubmerId = mynumberId;
        this.userNm = userNm;
        this.birthDate = birthDate;
        this.relation = relation;
        this.removeTarget = removeTarget;
        this.proofNm = proofNm;
        this.removeDate = removeDate;
    }

    public String getMymubmerId() {
        return mymubmerId;
    }

    public void setMymubmerId(String mymubmerId) {
        this.mymubmerId = mymubmerId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRemoveTarget() {
        return removeTarget;
    }

    public void setRemoveTarget(String removeTarget) {
        this.removeTarget = removeTarget;
    }

    public String getProofNm() {
        return proofNm;
    }

    public void setProofNm(String proofNm) {
        this.proofNm = proofNm;
    }

    public String getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(String removeDate) {
        this.removeDate = removeDate;
    }


}
