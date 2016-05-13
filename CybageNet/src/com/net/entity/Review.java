package com.net.entity;

public class Review {
	int reviewId;
	int rbookId;
	String username;
	String review;
	public Review(int reviewId, int rbookid, String username, String review) {
		super();
		this.reviewId = reviewId;
		this.rbookId = rbookid;
		this.username = username;
		this.review = review;
	}
	public Review() {
		// TODO Auto-generated constructor stub
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getRbookid() {
		return rbookId;
	}
	public void setRbookid(int rbookid) {
		this.rbookId = rbookid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", rbookid=" + rbookId + ", username=" + username + ", review=" + review
				+ "]";
	}	
	
	

}
