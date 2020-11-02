package com.badbadcode.application.service;

import com.badbadcode.application.entity.Cliente;

public interface ICliService {
	
	public Iterable<Cliente> findAll();
	public Cliente save(Cliente cliente);

}
