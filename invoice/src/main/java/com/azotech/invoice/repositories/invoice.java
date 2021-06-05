package com.azotech.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azotech.invoice.models.InvoiceModel;

@Repository
public interface invoice extends JpaRepository <InvoiceModel, Long> {

}
