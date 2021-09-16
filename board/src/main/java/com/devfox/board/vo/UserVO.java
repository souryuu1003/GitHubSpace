package com.devfox.board.vo;

public class UserVO {
	private int userNo;
	private String userId;
	private String userPw;
	private int userRl;
	private int userMc;
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public int getUserRl() {
		return userRl;
	}
	public void setUserRl(int userRl) {
		this.userRl = userRl;
	}
	public int getUserMc() {
		return userMc;
	}
	public void setUserMc(int userMc) {
		this.userMc = userMc;
	}
	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userRl=" + userRl
				+ ", userMc=" + userMc + "]";
	}
}
