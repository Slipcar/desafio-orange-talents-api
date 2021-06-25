package com.orange.apifipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orange.apifipe.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// CPF e EMAIL únicos
	boolean existsByCpf(String cpf);

	boolean existsByEmail(String email);
}
