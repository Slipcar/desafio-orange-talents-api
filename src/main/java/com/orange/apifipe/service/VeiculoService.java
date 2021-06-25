package com.orange.apifipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.apifipe.controller.dto.VeiculoDTO;
import com.orange.apifipe.exceptions.VeiculoException;
import com.orange.apifipe.model.Usuario;
import com.orange.apifipe.model.Veiculo;
import com.orange.apifipe.repository.UsuarioRepository;
import com.orange.apifipe.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<Veiculo> listaVeiculos() {
		if (veiculoRepository.findAll().isEmpty()) {
			throw new VeiculoException("Não exitem veículos cadastrados.");
		}

		return veiculoRepository.findAll();
	}

	public void inserirVeiculo(VeiculoDTO novoVeiculoDTO, Long idUsuario) {
		if (!usuarioRepository.existsById(idUsuario)) {
			throw new VeiculoException("Não é possível cadastrar o veiculo, não existe usuario com o id informado.");
		}

		Usuario usuario = new Usuario();
		Veiculo veiculo = novoVeiculoDTO.novoVeiculo();

		usuario.setId(idUsuario);
		veiculo.setUsuario(usuario);

		veiculoRepository.save(veiculo);
	}
}
