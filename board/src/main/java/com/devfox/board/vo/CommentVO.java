package com.devfox.board.vo;

public class CommentVO {
	private int commentNo;
	private String commentContent;
	private String commentWriter;
	private int fkBoardNo;
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}
	public int getFkBoardNo() {
		return fkBoardNo;
	}
	public void setFkBoardNo(int fkBoardNo) {
		this.fkBoardNo = fkBoardNo;
	}
	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", commentContent=" + commentContent + ", commentWriter="
				+ commentWriter + ", fkBoardNo=" + fkBoardNo + "]";
	}
}
