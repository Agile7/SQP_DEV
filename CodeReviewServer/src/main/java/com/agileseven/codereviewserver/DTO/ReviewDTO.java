/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agileseven.codereviewserver.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author S
 */
public class ReviewDTO {

    private int approved;
    private int codeId;
    private int reviewerId;
    private int reviewId;
    private String startTime;
    private String submitTime;
    private CodeDTO code;
    private UserDTO reviewer;
    private ArrayList<ReviewAnnotationDTO> annotationList;
    private Date submitDate;

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public ReviewDTO(int approved, int codeid, int reviewerid, int reviewid, String starttime, String submittime, CodeDTO codeDTO, Date submitDate) {
        this.approved = approved;
        this.codeId = codeid;
        this.reviewerId = reviewerid;
        this.reviewId = reviewid;
        this.startTime = starttime;
        this.submitTime = submittime;
        this.code = codeDTO;
        this.submitDate = submitDate;
    }
   

    

    public ReviewDTO() {
    
    }

    public int getApproved() {
        return approved;
    }

    public int getCodeId() {
        return codeId;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public CodeDTO getCode() {
        return code;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public void setCode(CodeDTO code) {
        this.code = code;
    }

    public UserDTO getReviewer() {
        return reviewer;
    }

    public void setReviewer(UserDTO reviewer) {
        this.reviewer = reviewer;
    }
    
    
    public ArrayList<ReviewAnnotationDTO> getAnnotationList() {
        return annotationList;
    }

    public void setAnnotationList(ArrayList<ReviewAnnotationDTO> annotationList) {
        this.annotationList = annotationList;
    }
    
}
