package com.azotech.invoice.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "sale_invoices")
public class InvoiceModel {
	


	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "invoice_id")
	 private Long invoiceId;
	 
	 @Column(name = "invoice_number")
	 private String invoiceNumber;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "invoice_date")
	 private Date invoiceDate;
	 
	 @Column(name = "client_name")
	 private String cleintName;
	 
	 @Column(name = "cleint_address")
	 private String cleintAddress;
	 
	 @Column(name = "gst_number")
	 private String GSTNumber;
	 
	 @Column(name = "invoice_sub_total")
	 private Double subTotal;
	 
	 @Column(name = "invoice_tax_amount")
	 private Double taxAmount;
	 
	 @Column(name = "invoice_total")
	 private Double totalToPay;
	 
	 @OneToMany(fetch=FetchType.LAZY, mappedBy = "invoiceModel", cascade = CascadeType.ALL,targetEntity = OrderModel.class)
	 private List <OrderModel> orderModels;

	 
	 
	 
	 
	public InvoiceModel() {
	
	
	}

	public InvoiceModel(Long invoiceId, String invoiceNumber, Date invoiceDate, String cleintName, String cleintAddress,
			String gSTNumber, Double subTotal, Double taxAmount, Double totalToPay, List<OrderModel> orderModels) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.cleintName = cleintName;
		this.cleintAddress = cleintAddress;
		this.GSTNumber = gSTNumber;
		this.subTotal = subTotal;
		this.taxAmount = taxAmount;
		this.totalToPay = totalToPay;
		this.orderModels = orderModels;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getCleintName() {
		return cleintName;
	}

	public void setCleintName(String cleintName) {
		this.cleintName = cleintName;
	}

	public String getCleintAddress() {
		return cleintAddress;
	}

	public void setCleintAddress(String cleintAddress) {
		this.cleintAddress = cleintAddress;
	}

	public String getGSTNumber() {
		return GSTNumber;
	}

	public void setGSTNumber(String gSTNumber) {
		this.GSTNumber = gSTNumber;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getTotalToPay() {
		return totalToPay;
	}

	public void setTotalToPay(Double totalToPay) {
		this.totalToPay = totalToPay;
	}

	public List<OrderModel> getOrderModels() {
		return orderModels;
	}

	public void setOrderModels(List<OrderModel> orderModels) {
		this.orderModels = orderModels;
		//adding code to mapping
		
//		for(OrderModel orderModel:orderModels)
//		{
//			orderModel.setInvoiceModel(this);
//		}
		
	}
	 
	    
	    
	    
	    
}
