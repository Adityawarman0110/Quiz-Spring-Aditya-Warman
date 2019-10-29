package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CsrService {
	
	@Autowired
	private CsrRepository repo;

	public List<Tblprogramcsr> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void save(Tblprogramcsr csr) {
		// TODO Auto-generated method stub
		repo.save(csr);
		
	}

	public Tblprogramcsr get(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
