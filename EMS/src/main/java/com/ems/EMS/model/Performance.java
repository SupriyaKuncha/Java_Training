package com.ems.EMS.model;

import java.util.List;

public class Performance {
	
	private int employeeid;
	private double rating;
	private String feedback;
	private List<String> projectsHandled;
	private boolean eligibleForPromotion;
	
	public Performance() {
		super();
		
	}
	public Performance(int employeeid, double rating, String feedback, List<String> projectsHandled,
			boolean eligibleForPromotion) {
		super();
		this.employeeid = employeeid;
		this.rating = rating;
		this.feedback = feedback;
		this.projectsHandled = projectsHandled;
		this.eligibleForPromotion = eligibleForPromotion;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public List<String> getProjectsHandled() {
		return projectsHandled;
	}
	public void setProjectsHandled(List<String> projectsHandled) {
		this.projectsHandled = projectsHandled;
	}
	public boolean isEligibleForPromotion() {
		return eligibleForPromotion;
	}
	public void setEligibleForPromotion(boolean eligibleForPromotion) {
		this.eligibleForPromotion = eligibleForPromotion;
	}
	@Override
	public String toString() {
		return "Performance [employeeid=" + employeeid + ", rating=" + rating + ", feedback=" + feedback
				+ ", projectsHandled=" + projectsHandled + ", eligibleForPromotion=" + eligibleForPromotion + "]";
	}
	
	
	

}
