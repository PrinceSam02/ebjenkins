package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Units")
public class Units {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unitId;

    private String meterNumber;
    private String unitsFrom;
    private String unitsTo;
    private String numOfUnits;
    private String price;
    private String calculatedDate;
    private String month;
    
    private String status;
    
    @ManyToOne
    private Connection connection;
    
    @ManyToOne
    private User user;

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public String getUnitsFrom() {
		return unitsFrom;
	}

	public void setUnitsFrom(String unitsFrom) {
		this.unitsFrom = unitsFrom;
	}

	public String getUnitsTo() {
		return unitsTo;
	}

	public void setUnitsTo(String unitsTo) {
		this.unitsTo = unitsTo;
	}

	public String getNumOfUnits() {
		return numOfUnits;
	}

	public void setNumOfUnits(String numOfUnits) {
		this.numOfUnits = numOfUnits;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCalculatedDate() {
		return calculatedDate;
	}

	public void setCalculatedDate(String calculatedDate) {
		this.calculatedDate = calculatedDate;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Units(int unitId, String meterNumber, String unitsFrom, String unitsTo, String numOfUnits, String price,
			String calculatedDate, String month, String status, Connection connection, User user) {
		super();
		this.unitId = unitId;
		this.meterNumber = meterNumber;
		this.unitsFrom = unitsFrom;
		this.unitsTo = unitsTo;
		this.numOfUnits = numOfUnits;
		this.price = price;
		this.calculatedDate = calculatedDate;
		this.month = month;
		this.status = status;
		this.connection = connection;
		this.user = user;
	}

	public Units() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Units [unitId=" + unitId + ", meterNumber=" + meterNumber + ", unitsFrom=" + unitsFrom + ", unitsTo="
				+ unitsTo + ", numOfUnits=" + numOfUnits + ", price=" + price + ", calculatedDate=" + calculatedDate
				+ ", month=" + month + ", status=" + status + ", connection=" + connection + ", user=" + user + "]";
	}

	
    
}