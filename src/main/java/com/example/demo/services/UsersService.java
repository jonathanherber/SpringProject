package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repository;
	
	public List<Users> findAll(){
		return repository.findAll();
	}
	
	public Users findById(Long id) {
		Optional<Users> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Users insert (Users obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Users update (Long id, Users obj) {
		Users entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Users entity, Users obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
