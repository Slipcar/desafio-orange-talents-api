package com.orange.apifipe.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class VeiculoFipeDto {

	// Variáveis retornadas da API FIPE
	private String valor;
	private String marca;
	private String modelo;
	private Integer anoModelo;
	private String combustivel;
	private String codigoFipe;
	private String mesReferencia;
	private Integer tipoVeiculo;
	private String siglaCombustivel;
	
	private String nome;
	private String codigo;
	
	private String idMarca;
	private String idModelo;
	
	private List<VeiculoFipeDto> anos = new ArrayList<>();
	private List<VeiculoFipeDto> modelos = new ArrayList<>();
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
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
	public Integer getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getCodigoFipe() {
		return codigoFipe;
	}
	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}
	public String getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	public Integer getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(Integer tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public String getSiglaCombustivel() {
		return siglaCombustivel;
	}
	public void setSiglaCombustivel(String siglaCombustivel) {
		this.siglaCombustivel = siglaCombustivel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(String idMarca) {
		this.idMarca = idMarca;
	}
	public String getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(String idModelo) {
		this.idModelo = idModelo;
	}
	public List<VeiculoFipeDto> getAnos() {
		return anos;
	}
	public void setAnos(List<VeiculoFipeDto> anos) {
		this.anos = anos;
	}
	public List<VeiculoFipeDto> getModelos() {
		return modelos;
	}
	public void setModelos(List<VeiculoFipeDto> modelos) {
		this.modelos = modelos;
	}

}
