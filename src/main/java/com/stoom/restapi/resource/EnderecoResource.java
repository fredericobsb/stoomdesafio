package com.stoom.restapi.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.stoom.restapi.exceptions.EnderecoNotFoundException;
import com.stoom.restapi.model.Endereco;
import com.stoom.restapi.repository.EnderecoRepository;
import com.stoom.restapi.utils.LatitudeLongitudeUtil;


@RestController
public class EnderecoResource {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	private LatitudeLongitudeUtil latitudeLongitudeUtil;
	
	@GetMapping("/enderecos")
	public List<Endereco> recuperarTodos() {
		List<Endereco>listaAuxiliarEndereco = new ArrayList<>();
		List<Endereco>listaEndereco = enderecoRepository.findAll();
		Endereco enderecoBuscado = null;
		for(Endereco endereco : listaEndereco) {
			enderecoBuscado = endereco;
			if(endereco != null) {
				if(endereco.getLatitude() == null || endereco.getLongitude() == null) {
					latitudeLongitudeUtil = new LatitudeLongitudeUtil();
					enderecoBuscado = latitudeLongitudeUtil.preencheLatitudeLongitude(endereco);
				}
			}
			listaAuxiliarEndereco.add(enderecoBuscado);
		}
		return listaAuxiliarEndereco;
	}
	
	@GetMapping("/enderecos/{id}")
	public Endereco recuperarPorId(@PathVariable long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		if (!endereco.isPresent())
			throw new EnderecoNotFoundException("User not found!");
		Endereco enderecoBuscado = endereco.get();
		
		if(endereco.get().getLatitude() == null || endereco.get().getLongitude() == null) {
			latitudeLongitudeUtil = new LatitudeLongitudeUtil();
			enderecoBuscado = latitudeLongitudeUtil.preencheLatitudeLongitude(endereco.get());
		}
		return enderecoBuscado;
	}
	
	@PostMapping("/enderecos")
	public ResponseEntity<Object> createEndereco(@RequestBody Endereco endereco) {
		Endereco savedEndereco = enderecoRepository.save(endereco);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEndereco.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/enderecos/{id}")
	public void deleteEndereco(@PathVariable long id) {
		enderecoRepository.deleteById(id);
	}
	
	@PutMapping("/enderecos/{id}")
	public ResponseEntity<Object> updateEndereco(@RequestBody Endereco endereco, @PathVariable long id) {
		Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
		if (!enderecoOptional.isPresent())
			return ResponseEntity.notFound().build();
		endereco.setId(id);
		enderecoRepository.save(endereco);
		return ResponseEntity.noContent().build();
	}
}
