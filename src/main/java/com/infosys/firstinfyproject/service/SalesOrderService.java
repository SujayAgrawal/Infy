package com.infosys.firstinfyproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.firstinfyproject.entities.SalesOrder;
import com.infosys.firstinfyproject.repository.SalesOrderRepository;

@Service
public class SalesOrderService {

	@Autowired
	private SalesOrderRepository salesOrderRepository;

	/**
	 * Get all sales order from sales_order table
	 * 
	 * @return list of sales order
	 */
	public List<SalesOrder> getAllSalesOrder() {
		List<SalesOrder> salesOrders = salesOrderRepository.findAll();
		if (salesOrders.size() > 0) {
			return salesOrders;
		} else {
			return new ArrayList<SalesOrder>();
		}
	}

	/**
	 * This gives specific sales order for corresponding order id
	 * 
	 * @param salesOrderId
	 * @return SalesOrder
	 */
	public SalesOrder getSalesOrderById(Long salesOrderId) {
		Optional<SalesOrder> salesOrder = salesOrderRepository.findById(salesOrderId);
		if (salesOrder.isPresent()) {
			return salesOrder.get();
		} else {
			throw new RuntimeException("Record not found");
		}
	}

	public SalesOrder createSalesOrder(SalesOrder salesOrder) {
		Optional<SalesOrder> existingOrder = salesOrderRepository.findById(salesOrder.getSalesOrderId());
		if (existingOrder.isPresent()) {
			throw new RuntimeException("Order already exists!!!");
		} else {
			return salesOrderRepository.save(salesOrder);
		}
	}

}
