package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Isssue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issId;
    
    private String issueOn;
    private String meterNumber;
    private String issueDesc;
    
    private String reply;
    @ManyToOne
    private User user;
	public int getIssId() {
		return issId;
	}
	public void setIssId(int issId) {
		this.issId = issId;
	}
	public String getIssueOn() {
		return issueOn;
	}
	public void setIssueOn(String issueOn) {
		this.issueOn = issueOn;
	}
	public String getMeterNumber() {
		return meterNumber;
	}
	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}
	public String getIssueDesc() {
		return issueDesc;
	}
	public void setIssueDesc(String issueDesc) {
		this.issueDesc = issueDesc;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Issue(int issId, String issueOn, String meterNumber, String issueDesc, String reply, User user) {
		super();
		this.issId = issId;
		this.issueOn = issueOn;
		this.meterNumber = meterNumber;
		this.issueDesc = issueDesc;
		this.reply = reply;
		this.user = user;
	}
	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Issue [issId=" + issId + ", issueOn=" + issueOn + ", meterNumber=" + meterNumber + ", issueDesc="
				+ issueDesc + ", reply=" + reply + ", user=" + user + "]";
	}

	
}