package com.orange.apifipe.exceptions;

public class UsuarioException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UsuarioException(String msg) {
		super(msg);
	}
}
