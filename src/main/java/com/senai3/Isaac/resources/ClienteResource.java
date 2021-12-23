package com.senai3.Isaac.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai3.Isaac.domain.Cliente;
import com.senai3.Isaac.services.ClienteService;

@RestController 
@RequestMapping(value = "/clientes")
public class ClienteResource { 
	@Autowired
private ClienteService service;
@RequestMapping
	public ResponseEntity<Cliente>find (@PathVariable Integer id){
	Cliente obj = service.buscar(id); 
	return ResponseEntity.ok().body(obj);
}
}
