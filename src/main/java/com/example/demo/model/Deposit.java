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
@Table(name = "DepositPayment")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dpId;

    private String meterNumber;
    private String depositAmount;
    
    @OneToOne
    private Connection connection;
    
    @ManyToOne
    private User user;

	public int getDpId() {
		return dpId;
	}

	public void setDpId(int dpId) {
		this.dpId = dpId;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public String getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Deposit(int dpId, String meterNumber, String depositAmount, Connection connection, User user) {
		super();
		this.dpId = dpId;
		this.meterNumber = meterNumber;
		this.depositAmount = depositAmount;
		this.connection = connection;
		this.user = user;
	}

	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Deposit [dpId=" + dpId + ", meterNumber=" + meterNumber + ", depositAmount=" + depositAmount
				+ ", connection=" + connection + ", user=" + user + "]";
	}
    
    
}
    
    