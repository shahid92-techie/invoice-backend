package com.azotech.invoice.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
@Table(name = "invoice_orders")
public class OrderModel {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    
    @Column(name = "order_details")
    private String orderdetails;
    
    @Column(name = "quantity")
    private String quantity;
    
    
    @Column(name = "rate")
    private Double rate;
    
    @Column(name = "total")
    private Double total;
    
    //@ManyToOne(optional=false,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @ManyToOne
   @JoinColumn(name = "invoice_id")
    @JsonIgnore
    private InvoiceModel invoiceModel;

    
    
    
	public OrderModel() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	

	public OrderModel(int orderId, String orderdetails, String quantity, Double rate, Double total,
			InvoiceModel invoiceModel) {
		super();
		this.orderId = orderId;
		this.orderdetails = orderdetails;
		this.quantity = quantity;
		this.rate = rate;
		this.total = total;
		this.invoiceModel = invoiceModel;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(String orderdetails) {
		this.orderdetails = orderdetails;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public InvoiceModel getInvoiceModel() {
		return invoiceModel;
	}

	public void setInvoiceModel(InvoiceModel invoiceModel) {
		this.invoiceModel = invoiceModel;
		//invoiceModel.getOrderModels().add(this);
	}

	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderId + ", orderdetails=" + orderdetails + ", quantity=" + quantity
				+ ", rate=" + rate + ", total=" + total + ", invoiceModel=" + invoiceModel + "]";
	}
    
    
    
    
    

}
