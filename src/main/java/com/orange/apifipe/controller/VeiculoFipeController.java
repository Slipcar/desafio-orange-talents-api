package com.orange.apifipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.apifipe.service.VeiculoFipeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class VeiculoFipeController {

	@Autowired
	private VeiculoFipeService veiculoFipeService;

	@GetMapping("/veiculo/{tipoVeiculo}/marcas/{idMarca}/modelos/{idModelo}/anos/{idAno}")
	@ApiOperation(value = "Retorna O Veículo de Acordo Com os Parâmetros Passados")
	public ResponseEntity<Object> getModelo(@PathVariable String tipoVeiculo, @PathVariable Long idMarca,
			@PathVariable Long idModelo, @PathVariable String idAno) {
		Object veiculo = veiculoFipeService.getModeloValor(tipoVeiculo, idMarca, idModelo, idAno);
		return ResponseEntity.ok(veiculo);
	}
}
