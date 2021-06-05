package com.azotech.invoice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azotech.invoice.models.OrderModel;

@Repository
public interface orders extends JpaRepository <OrderModel, Long> {

	//List<OrderModel> findByInvoiceId(Long invoiceId);
	// Optional<OrderModel> findByIdAndInvoiceId(Long id, Long invoiceId);
	
}
