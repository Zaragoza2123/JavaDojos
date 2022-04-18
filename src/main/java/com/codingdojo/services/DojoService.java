package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Dojo;
import com.codingdojo.repositories.DojoRepository;
@Service 
public class DojoService {
private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository=dojoRepository;
	}
	
	public void Create(Dojo dojo) {
			dojoRepository.save(dojo);
	}
	
	public ArrayList<Dojo> FindAll() {
		return (ArrayList<Dojo>)dojoRepository.findAll();
	}
	public Dojo FindOne(long id)
	{
		Optional<Dojo> dojo=dojoRepository.findById(id);
		return dojo.isPresent()?dojo.get():null;
	}
	public void Update(Dojo dojo)
	{
		Create(dojo);
	}
	public void Delete(Long id)
	{
		dojoRepository.deleteById(id);
	}
}
