package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "meter")
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String meterNumber;
    private String depositAmount;
    
    @OneToOne
    private Connection connection;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Meter(int id, String meterNumber, String depositAmount, Connection connection) {
		super();
		this.id = id;
		this.meterNumber = meterNumber;
		this.depositAmount = depositAmount;
		this.connection = connection;
	}

	public Meter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Meter [id=" + id + ", meterNumber=" + meterNumber + ", depositAmount=" + depositAmount + ", connection="
				+ connection + "]";
	}
    
    
}
    
