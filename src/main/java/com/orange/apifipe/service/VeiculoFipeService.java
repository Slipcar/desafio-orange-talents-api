package com.orange.apifipe.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orange.apifipe.controller.dto.VeiculoFipeDto;

@FeignClient(name = "tabelaFipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface VeiculoFipeService {

	@GetMapping("/{tipoVeiculo}/marcas")
	List<VeiculoFipeDto> getMarcas(@PathVariable("tipoVeiculo") String tipoVeiculo);

	@GetMapping("/{tipoVeiculo}/marcas/{idMarca}/modelos")
	VeiculoFipeDto getModelos(@PathVariable("tipoVeiculo") String tipoVeiculo, @PathVariable("idMarca") Long idMarca);

	@GetMapping("/{tipoVeiculo}/marcas/{idMarca}/modelos/{idModelo}/anos")
	List<VeiculoFipeDto> getAnos(@PathVariable("tipoVeiculo") String tipoVeiculo, @PathVariable("idMarca") Long idMarca,
			@PathVariable("idModelo") Long idModelo);

	@GetMapping("/{tipoVeiculo}/marcas/{idMarca}/modelos/{idModelo}/anos/{idAno}")
	Object getModeloValor(@PathVariable("tipoVeiculo") String tipoVeiculo, @PathVariable("idMarca") Long idMarca,
			@PathVariable("idModelo") Long idModelo, @PathVariable("idAno") String idAno);
}
