package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Orders;
import com.example.demo.repositories.OrdersRepository;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository repository;
	
	public List<Orders> findAll(){
		return repository.findAll();
	}
	
	public Orders findById(Long id) {
		Optional<Orders> obj = repository.findById(id);
		return obj.get();
	}
}
