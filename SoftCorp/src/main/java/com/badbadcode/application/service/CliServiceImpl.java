package com.badbadcode.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badbadcode.application.dao.ICliDao;
import com.badbadcode.application.entity.Cliente;

@Service
public class CliServiceImpl implements ICliService{

	@Autowired
	private ICliDao clienteDao;
	
	@Override
	public Iterable<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	
}
