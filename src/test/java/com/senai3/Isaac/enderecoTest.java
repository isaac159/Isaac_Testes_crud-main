package com.senai3.Isaac;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai3.Isaac.domain.Endereco;
import com.senai3.Isaac.repositories.EnderecoRepository;

@SpringBootTest

public class enderecoTest {

	@Autowired
	EnderecoRepository enderecoRepository;

	@Test
	void Endereco() {
		Endereco e1 = new Endereco();
		e1.setIdEndereco(1);
		e1.setBairro("Nova Cidade");
		e1.setCep("0900923840");
		e1.setLogradouro("Rua");
		e1.setComplemento("Casa");
		enderecoRepository.save(e1);

	}

	@Test
	public void listaEndereco() {
		List<Endereco> List = enderecoRepository.findAll();
		assertThat(List).size().isGreaterThan(0);
	}

	@Test
	public void idEndereco() {
		Endereco endereco = enderecoRepository.findById(1).get();
		assertEquals("Nova Cidade", endereco.getBairro());
	}

	@Test
	public void updateEndereco() {
		Endereco endereco = enderecoRepository.findById(1).get();
		endereco.setBairro("Nova Cidade");
		enderecoRepository.save(endereco);
		assertNotEquals("Cidade Nova", endereco.getBairro());
	}

	@Test
	public void DeleteEndereco() {
		enderecoRepository.deleteById(1);
		assertThat(enderecoRepository.existsById(1));
	}
}
