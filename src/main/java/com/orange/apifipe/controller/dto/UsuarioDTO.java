package com.orange.apifipe.controller.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.orange.apifipe.model.Usuario;
import com.orange.apifipe.model.Veiculo;

public class UsuarioDTO {

	private Long id;

	@NonNull
	@NotBlank(message = "{nome.obrigatorio}")
	private String nome;

	@NonNull
	@NotBlank(message = "{email.obrigatorio}")
	private String email;

	@NonNull
	@CPF(message = "{cpf.invalido}")
	@Size(min = 11, max = 11, message = "{cpf.valida}")
	@NotBlank(message = "cpf.obrigatorio}")
	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	private List<Veiculo> veiculos;

	public UsuarioDTO() {
	}

	public Usuario novoUsuario() {
		return new Usuario(nome, cpf, email, dataNascimento);
	}

	public UsuarioDTO(Long id, @NotBlank(message = "{nome.obrigatorio}") String nome,
			@NotBlank(message = "{email.obrigatorio}") String email,
			@NotBlank(message = "{cpf.obrigatorio}") @CPF(message = "{cpf.invalido}") @Size(min = 11, max = 11, message = "{cpf.valida}") String cpf,
			Date dataNascimento, List<Veiculo> veiculos) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.veiculos = veiculos;
	}

	public UsuarioDTO(Usuario u) {
		this.id = u.getId();
		this.nome = u.getNome();
		this.email = u.getEmail();
		this.cpf = u.getCpf();
		this.dataNascimento = u.getDataNascimento();
		this.veiculos = u.getVeiculo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
}
