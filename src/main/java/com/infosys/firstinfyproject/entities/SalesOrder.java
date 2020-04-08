package com.infosys.firstinfyproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALES_ORDER")
public class SalesOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "SALES_ORDER_AMOUNT")
	private String salesOrderAmount;

	@Column(name = "SALES_ORDER_DESCRIPTION")
	private String salesOrderDescription;

	public Long getSalesOrderId() {
		return id;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.id = salesOrderId;
	}

	public String getSalesOrderAmount() {
		return salesOrderAmount;
	}

	public void setSalesOrderAmount(String salesOrderAmount) {
		this.salesOrderAmount = salesOrderAmount;
	}

	public String getSalesOrderDescription() {
		return salesOrderDescription;
	}

	public void setSalesOrderDescription(String salesOrderDescription) {
		this.salesOrderDescription = salesOrderDescription;
	}

	@Override
	public String toString() {
		return "SalesOrder [salesOrderId=" + id + ", salesOrderAmount=" + salesOrderAmount
				+ ", salesOrderDescription=" + salesOrderDescription + "]";
	}

}
