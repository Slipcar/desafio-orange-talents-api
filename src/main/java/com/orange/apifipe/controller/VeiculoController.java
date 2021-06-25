package com.orange.apifipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orange.apifipe.controller.dto.VeiculoDTO;
import com.orange.apifipe.model.Veiculo;
import com.orange.apifipe.service.VeiculoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Desafio Orange Talents API Usuários")
@CrossOrigin(origins="*")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping("/usuario/veiculo")
	@ApiOperation(value = "Retorna Todos os Veículos Cadastrados")
	public ResponseEntity<List<Veiculo>> listaVeiculos() {
		List<Veiculo> listaVeiculos = veiculoService.listaVeiculos();

		return ResponseEntity.ok().body(listaVeiculos);
	}

	// Inserir um veículo para um usuário através do id.
	@PostMapping("usuario/veiculo/{id}")
	@ApiOperation(value = "Retorna O Veículo do ID Informado")
	@ResponseStatus(HttpStatus.CREATED) // retorna o código 201 CREATED
	public ResponseEntity<Void> inserirVeiculo(@RequestBody VeiculoDTO veiculoDTO, @PathVariable Long id) {
		veiculoService.inserirVeiculo(veiculoDTO, id);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
