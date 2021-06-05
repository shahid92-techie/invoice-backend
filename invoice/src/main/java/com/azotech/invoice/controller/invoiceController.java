package com.azotech.invoice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azotech.invoice.models.InvoiceModel;
import com.azotech.invoice.repositories.invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1")
public class invoiceController {
	
	@Autowired
	private invoice invoiceRepo;
	@Autowired
	ObjectMapper mapper;
	
	@CrossOrigin(origins = "*")
    @GetMapping("/invoices")
    public List < InvoiceModel > getInvoices() {
        return invoiceRepo.findAll();
    }
    
	@CrossOrigin(origins = "*")
    @PostMapping("/add")
    public InvoiceModel createInvoice( @RequestBody InvoiceModel invoice)
    {
    	System.out.println("hi there");
    	
    	if(invoice.getOrderModels().size() > 0)
    	{
    		invoice.getOrderModels().stream().forEach(order ->{
    			order.setInvoiceModel(invoice);
    		});
    	}
    	
    	
//    	String jsonNode;
//		try {
//			jsonNode = mapper.writeValueAsString(invoice);
//			System.out.println(jsonNode);
//			JsonNode  orderDetailsNode = mapper.readTree(jsonNode);
//			
//			orderDetailsNode.hasNonNull("orderDetails");
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	
    	//JsonNode node = mapper.readTree(invoice);
    	
    	//return null;
		return invoiceRepo.save(invoice);
    	
    }
	@CrossOrigin(origins = "*")
	@GetMapping("invoice/{id}")
	public InvoiceModel getInvoice(@PathVariable(name = "id") Long id) throws Exception
	{
		Optional<InvoiceModel> invoiceModel =  invoiceRepo.findById(id);
		if(!invoiceModel.isPresent())
		{
			throw new Exception("Invoice of " + id + "..Not Present in system..");
		
		}
		
		return invoiceModel.get();
	
	}
	
	
}
		