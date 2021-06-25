package com.orange.apifipe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "ano")
	private Integer ano;
	
	@Column(name = "rodizio_dia")
	private String rodizioDia;
	
	@Column(name = "rodizio_ativo")
	private Boolean rodizioAtivo;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	public Veiculo() {
		
	}
	
	public Veiculo(Long id, String marca, String modelo, Integer ano, String rodizioDia, Boolean rodizioAtivo) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.rodizioDia = rodizioDia;
		this.rodizioAtivo = rodizioAtivo;
	}
	
	public Veiculo(String marca, String modelo, Integer ano) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRodizioDia() {
		return rodizioDia;
	}

	public void setRodizioDia(String rodizioDia) {
		this.rodizioDia = rodizioDia;
	}

	public Boolean getRodizioAtivo() {
		return rodizioAtivo;
	}

	public void setRodizioAtivo(Boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}
}
