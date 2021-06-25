package com.orange.apifipe.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.orange.apifipe.controller.dto.UsuarioDTO;
import com.orange.apifipe.model.Usuario;
import com.orange.apifipe.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(value = "Desafio Orange Talents API Usuários")
@CrossOrigin(origins="*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService UsuarioService;
	
	@GetMapping("/usuarios")
	@ApiOperation(value = "Retorna Todos os Usuários Cadastrados")
	public ResponseEntity<List<Usuario>> listaUsuario() {
		List<Usuario> list = UsuarioService.listaUsuarios();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/usuarios/{id}")
	@ApiOperation(value = "Retorna O Usuário do ID Informado")
	public ResponseEntity<Optional<Usuario>> listaUsuarioUnico(@PathVariable(value = "id") Long id) {
		Optional<Usuario> usuario = UsuarioService.listaUsuarioUnico(id);
		
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/usuarios")
	@ApiOperation(value = "Cadastra Um Novo Usuário")
	public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO dto){
		dto = UsuarioService.salvarUsuario(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
}
