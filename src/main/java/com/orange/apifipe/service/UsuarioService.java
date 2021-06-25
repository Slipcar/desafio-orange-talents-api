package com.orange.apifipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.apifipe.controller.dto.UsuarioDTO;
import com.orange.apifipe.exceptions.UsuarioException;
import com.orange.apifipe.model.Usuario;
import com.orange.apifipe.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> listaUsuarios() {

		if (usuarioRepository.findAll().isEmpty()) {
			throw new UsuarioException("Não existem usuários cadastrados.");
		}

		return usuarioRepository.findAll();
	}

	public Optional<Usuario> listaUsuarioUnico(Long usuarioId) {

		if (!usuarioRepository.existsById(usuarioId)) {
			throw new UsuarioException("Não existe usuário com o id solicitado.");
		}

		return usuarioRepository.findById(usuarioId);

	}

	public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {

		if (usuarioDTO.getCpf().isBlank() || usuarioDTO.getCpf().isEmpty()) {
			throw new UsuarioException("CPF é obrigatório!");
		}

		this.validarUsuario(usuarioDTO);
		Usuario novoUsuario = new Usuario();
		copiarUsuarioDtoEntity(usuarioDTO, novoUsuario);

		novoUsuario = usuarioRepository.save(novoUsuario);

		return new UsuarioDTO(novoUsuario);
	}

	private void copiarUsuarioDtoEntity(UsuarioDTO dto, Usuario entity) {
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setEmail(dto.getEmail());
		entity.setDataNascimento(dto.getDataNascimento());
		entity.setVeiculo(dto.getVeiculos());

	}

	private void validarUsuario(UsuarioDTO dto) {
		validarCpfUsuario(dto);
		validarEmailUsuario(dto);
	}

	private void validarCpfUsuario(UsuarioDTO dto) {
		boolean existe = usuarioRepository.existsByCpf(dto.getCpf());

		if (existe) {
			throw new UsuarioException("CPF já está cadastrado na base de dados!");
		}
	}

	private void validarEmailUsuario(UsuarioDTO dto) {
		boolean existe = usuarioRepository.existsByEmail(dto.getEmail());

		if (existe) {
			throw new UsuarioException("Email já está cadastrado na base de dados!");
		}
	}
}
