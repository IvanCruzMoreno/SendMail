package com.badbadcode.application.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.badbadcode.application.entity.Cliente;

@Repository
public interface ICliDao extends CrudRepository<Cliente, Long> {

}
