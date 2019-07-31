package com.kh.jimcarry.serviceCenter.model.vo;

import java.sql.Date;

public class OneQ {
	private String postcode;
	private String userNo;
	private Date postDate;
	private String postTitle;
	private String postContent;
	private String attachment;
	private String postType;
	private String questionType;
	private int postNo;
	private int BCount;
	
	
	
	public OneQ() {}



	public OneQ(String postcode, String userNo, Date postDate, String postTitle, String postContent, String attachment,
			String postType, String questionType, int postNo, int bCount) {
		super();
		this.postcode = postcode;
		this.userNo = userNo;
		this.postDate = postDate;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.attachment=attachment;
		this.postType = postType;
		this.questionType = questionType;
		this.postNo = postNo;
		BCount = bCount;
	}



	public String getPostcode() {
		return postcode;
	}



	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}



	public String getUserNo() {
		return userNo;
	}



	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}



	public Date getPostDate() {
		return postDate;
	}



	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}



	public String getPostTitle() {
		return postTitle;
	}



	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}



	public String getPostContent() {
		return postContent;
	}

	

	public String getAttachment() {
		return attachment;
	}



	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}



	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}



	public String getPostType() {
		return postType;
	}



	public void setPostType(String postType) {
		this.postType = postType;
	}



	public String getQuestionType() {
		return questionType;
	}



	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}



	public int getPostNo() {
		return postNo;
	}



	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}



	public int getBCount() {
		return BCount;
	}



	public void setBCount(int bCount) {
		BCount = bCount;
	}



	@Override
	public String toString() {
		return "OneQ [postcode=" + postcode + ", userNo=" + userNo + ", postDate=" + postDate + ", postTitle="
				+ postTitle + ", postContent=" + postContent + ", attachment=" + attachment + ", postType=" + postType
				+ ", questionType=" + questionType + ", postNo=" + postNo + ", BCount=" + BCount + "]";
	}



	


	

	
}
	
	
	