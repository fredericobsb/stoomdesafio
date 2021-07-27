/*
package com.stoom.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stoom.restapi.model.Pessoa;
import com.stoom.restapi.services.PessoaService;

@RestController
public class ApiController {

	@Autowired
	private static PessoaService pessoaService;
	
	@GetMapping("/pessoas/")
	public List<Pessoa> pessoas(){
		return pessoaService.listaDePessoas();
	}
	
	@PostMapping(path = "pessoas", consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> create(@RequestBody Pessoa novaPessoa) {
	    Pessoa pessoa = pessoaService.save(novaPessoa);
	    if (user == null) {
	        throw new ServerException();
	    } else {
	        return new ResponseEntity<>(user, HttpStatus.CREATED);
	    }
	}
}
*/
