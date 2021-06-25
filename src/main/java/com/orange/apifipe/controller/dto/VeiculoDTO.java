package com.orange.apifipe.controller.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import com.orange.apifipe.model.Veiculo;
import com.orange.apifipe.service.RodizioService;

public class VeiculoDTO {

	@NotBlank(message = "{veiculo.marca}")
	private String marca;

	@NotBlank(message = "{veiculo.modelo}")
	private String modelo;

	@NotBlank(message = "{veiculo.ano}")
	@Range(min = 1900, max = 9999, message = "{veiculo.formatoAno}")
	private Integer ano;

	@NotBlank(message = "{usuarioId.naoexiste}")
	private Long idUsuario;

	public VeiculoDTO() {

	}

	public Veiculo novoVeiculo() {
		return new Veiculo(idUsuario, marca, modelo, ano, getRodizioDia(), emRodizio());
	}

	// Retorna o dia em que participa do rodízio
	public String getRodizioDia() {
		return RodizioService.rodizioDia(ano);

	}

	// Verifica se está em rodízio
	public boolean emRodizio() {
		return RodizioService.emRodizio(ano);

	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

}
