package com.stoom.restapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.stoom.restapi.model.Endereco;
import com.stoom.restapi.repository.EnderecoRepository;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class EnderecoRepositoryTest {

	 @Autowired
	 private EnderecoRepository enderecoRepository;
	 
	 @BeforeEach
	 void initUseCase(){
	     List<Endereco> listaEnderecos = new ArrayList<>();
	       Endereco endereco = new Endereco();
	       endereco.setCity("Brasilia");
	       endereco.setComplement("Complemento endereco 1");
	       endereco.setCountry("Brazil");
	       endereco.setId(1L);
	       endereco.setLatitude("2145S");
	       endereco.setLongitude("08733W");
	       endereco.setNeighbourhood("Neighbors 1");
	       endereco.setNumber(22);
	       endereco.setState("DF");
	       endereco.setStreetName("Rua do Endereco 1");
	       endereco.setZipCode(70000000L);
	       listaEnderecos.add(endereco);
	       
	       endereco = new Endereco();
	       endereco.setCity("Taguatinga");
	       endereco.setComplement("Complemento endereco 2");
	       endereco.setCountry("Brazil");
	       endereco.setId(2L);
	       endereco.setLatitude("2165S");
	       endereco.setLongitude("08773W");
	       endereco.setNeighbourhood("Neighbors 2");
	       endereco.setNumber(26);
	       endereco.setState("DF");
	       endereco.setStreetName("Rua do Endereco 2");
	       endereco.setZipCode(75134290L);
	       listaEnderecos.add(endereco);
	       enderecoRepository.saveAll(listaEnderecos);
	 }
	 
	 @AfterEach
	 public void destroyAll(){
		 enderecoRepository.deleteAll();
	 }
	 
	 @Test
	 public void recuperarTodosEnderecos() {
	        List<Endereco> todosEnderecos = enderecoRepository.findAll();
	       assertEquals(4L, todosEnderecos.size(), "4 resultados foram esperados e encontrados");
	 }
	 
	 @Test
	 public void deletarEndereco() {
		 Optional<Endereco> endereco = enderecoRepository.findById(1L);
		 enderecoRepository.delete(endereco.get());
		 endereco = enderecoRepository.findById(1L);
		 assertFalse(endereco.isPresent());
	 }
	 
	 @Test
	 public void inserirEndereco() {
		 Endereco endereco = new Endereco();
	       endereco.setCity("Nucleo bandeirante");
	       endereco.setComplement("Complemento endereco nucleo bandeirante");
	       endereco.setCountry("Brazil");
	       endereco.setId(23L);
	       endereco.setLatitude("2165S");
	       endereco.setLongitude("08233W");
	       endereco.setNeighbourhood("Neighbors nucleo bandeirante");
	       endereco.setNumber(22);
	       endereco.setState("DF");
	       endereco.setStreetName("Rua do Endereco do nucleo bandeirante");
	       endereco.setZipCode(73449087L);
	       Optional<Endereco> enderecoQueNaoExisteAinda = enderecoRepository.findById(23L);
	       assertFalse(enderecoQueNaoExisteAinda.isPresent());
	       enderecoRepository.save(endereco);
	       assertNotNull(endereco);      
	 }
	 
	 @Test
	 public void editarEndereco() {
		 Optional<Endereco> endereco = enderecoRepository.findById(1L);
		 String atributoStreetName = endereco.get().getStreetName();
		 endereco.get().setStreetName("Atributo street name modificado");
		 enderecoRepository.save(endereco.get());
		 Optional<Endereco>enderecoModificado = enderecoRepository.findById(1L);
		 assertNotEquals(atributoStreetName, enderecoModificado.get().getStreetName());
	 }
}
