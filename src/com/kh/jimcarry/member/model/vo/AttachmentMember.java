package com.kh.jimcarry.member.model.vo;

import java.sql.Date;

public class AttachmentMember {
	private String attachNo;		//첨부파일번호
	private String originName;		//파일 저장 이름
	private String changeName;		//바뀐 파일 저장 이름
	private String filePath;		//저장경로
	private Date uploadDate;		//작성일
	private String status;			//삭제여부
	private int fileLevel;			//파일 레벨
	private String attachType;		//구분
	private String driverNo;		//기사번호
	private String postCode;		//게시글코드
	private String reqNo;			//견적번호
	private String productNo;		//물품번호
	
	public AttachmentMember () {}

	public AttachmentMember(String attachNo, String originName, String changeName, String filePath, Date uploadDate,
			String status, int fileLevel, String attachType, String driverNo, String postCode, String reqNo,
			String productNo) {
		super();
		this.attachNo = attachNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
		this.fileLevel = fileLevel;
		this.attachType = attachType;
		this.driverNo = driverNo;
		this.postCode = postCode;
		this.reqNo = reqNo;
		this.productNo = productNo;
	}

	public String getAttachNo() {
		return attachNo;
	}

	public void setAttachNo(String attachNo) {
		this.attachNo = attachNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public String getAttachType() {
		return attachType;
	}

	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}

	public String getDriverNo() {
		return driverNo;
	}

	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getReqNo() {
		return reqNo;
	}

	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	@Override
	public String toString() {
		return "AttachmentMember [attachNo=" + attachNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", status=" + status + ", fileLevel="
				+ fileLevel + ", attachType=" + attachType + ", driverNo=" + driverNo + ", postCode=" + postCode
				+ ", reqNo=" + reqNo + ", productNo=" + productNo + "]";
	}

	
	
	
}
