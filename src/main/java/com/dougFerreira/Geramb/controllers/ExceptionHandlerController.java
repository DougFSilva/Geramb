package com.dougFerreira.Geramb.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dougFerreira.Geramb.Exception.DataIntegrityViolationException;
import com.dougFerreira.Geramb.Exception.ObjectNotFoundException;
import com.dougFerreira.Geramb.Exception.OperationNotAllowedException;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartException> objetoNaoEncontradoException(ObjectNotFoundException exception) {
		StandartException standartException = new StandartException(System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value(), exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartException);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandartException> dataIntegrityViolationException(DataIntegrityViolationException exception) {
		StandartException standartException = new StandartException(System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value(), exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartException);
	}
	
	@ExceptionHandler(OperationNotAllowedException.class)
	public ResponseEntity<StandartException> operationNotAllowedException(OperationNotAllowedException exception) {
		StandartException standartException = new StandartException(System.currentTimeMillis(),
				HttpStatus.NOT_ACCEPTABLE.value(), exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(standartException);
	}
}
