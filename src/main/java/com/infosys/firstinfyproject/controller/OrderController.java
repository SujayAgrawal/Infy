package com.infosys.firstinfyproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.firstinfyproject.entities.SalesOrder;
import com.infosys.firstinfyproject.service.SalesOrderService;

import io.swagger.annotations.ApiOperation;

/**
 * This controller is responsible to interact with orders placed by users.
 * 
 * @author Sujay-PC
 *
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private SalesOrderService salesOrderService;

	@GetMapping("/")
	public ResponseEntity<List<SalesOrder>> getOrders() {
		return new ResponseEntity<List<SalesOrder>>(salesOrderService.getAllSalesOrder(), HttpStatus.OK);
	}

	@GetMapping("/{salesOrderId}")
	@ApiOperation(value = "Finds sales order by Id", notes = "Pass a valid sales order Id to lookup sales order", response = SalesOrder.class)
	public ResponseEntity<SalesOrder> getOrder(@PathVariable("salesOrderId") Long salesOrderId) {
		return new ResponseEntity<SalesOrder>(salesOrderService.getSalesOrderById(salesOrderId), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<SalesOrder> createOrder(@RequestBody SalesOrder salesOrder) {
		// this will be a post call which will be responsible to insert records in h2
		// database
		return new ResponseEntity<SalesOrder>(salesOrderService.createSalesOrder(salesOrder), HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<SalesOrder> updateOrder(@RequestBody SalesOrder salesOrder) {
		return new ResponseEntity<SalesOrder>(salesOrderService.updateOrder(salesOrder), HttpStatus.OK);
	}

	@DeleteMapping("/{salesOrderId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("salesOrderId") Long salesOrderId) {
		salesOrderService.deleteSalesOrderById(salesOrderId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
