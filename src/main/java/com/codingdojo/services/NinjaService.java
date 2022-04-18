package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Ninja;
import com.codingdojo.repositories.NinjaRepository;
@Service
public class NinjaService {
private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository=ninjaRepository;
	}
	
	public void Create(Ninja ninja) {
			ninjaRepository.save(ninja);
	}
	
	public ArrayList<Ninja> FindAll() {
		return (ArrayList<Ninja>)ninjaRepository.findAll();
	}
	public Ninja FindOne(long id)
	{
		Optional<Ninja> ninja=ninjaRepository.findById(id);
		return ninja.isPresent()?ninja.get():null;
	}
	public void Update(Ninja ninja)
	{
		Create(ninja);
	}
	public void Delete(Long id)
	{
		ninjaRepository.deleteById(id);
	}
}
