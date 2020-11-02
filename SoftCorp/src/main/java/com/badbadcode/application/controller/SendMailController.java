package com.badbadcode.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badbadcode.application.entity.Cliente;
import com.badbadcode.application.service.ICliService;
import com.badbadcode.application.service.IEmailService;

@RestController
@RequestMapping(value = "/api")
public class SendMailController {

    @Autowired
    private IEmailService mailService;
    
    @Autowired
    private ICliService clienteService;

    @PostMapping("/cliente")
    public boolean create(@RequestBody Cliente cliente)  {

    	String body = createBody(cliente);
    	
    	try {
			clienteService.save(cliente);
			mailService.sendEmail(cliente.getEmail(),body);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
        return true;
        
    }

	private String createBody(Cliente cliente) {
		StringBuilder body = new StringBuilder();
    	body.append("Este correo es para motivos de confirmacion\n")
    		.append("Empresa: ")
    		.append(cliente.getEmpresa())
    		.append("\nTitulo: ")
    		.append(" [ ")
    		.append(cliente.getTitulo())
    		.append(" ] ")
    		.append("\nCiudad: ")
    		.append(cliente.getCiudad())
    		.append("\nFavor de no contestar este mensaje :)");
		return body.toString();
	}
    
    
}