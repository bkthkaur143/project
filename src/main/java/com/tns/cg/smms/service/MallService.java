package com.tns.cg.smms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.cg.smms.entities.Mall;
import com.tns.cg.smms.repositories.MallRepository;
@Service
@Transactional

public class MallService {
	@Autowired
	// This means to get the bean which is auto-generated by Spring
	// We will use it to handle the data
	MallRepository mRepository;
	
	// Retreiving all malls
	public List<Mall> getAll(){
		return mRepository.findAll();
	}
	
	// Creating New mall
	public void save(Mall emp) {
		mRepository.save(emp);
	}
	
	//  Retreiving mall by id
	public Mall getMallById(Integer id) {
		return mRepository.findById(id).get();
	}
	
	// Deleting mall from database
	public void delete(Integer id) {
		mRepository.deleteById(id);
	}
}
