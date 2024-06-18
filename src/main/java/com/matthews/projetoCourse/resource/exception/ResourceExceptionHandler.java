package com.matthews.projetoCourse.resource.exception;

import java.time.Instant;

import org.hibernate.cache.spi.StandardCacheTransactionSynchronization;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matthews.projetoCourse.services.exception.DatabaseException;
import com.matthews.projetoCourse.services.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus hs = HttpStatus.NOT_FOUND;
		StandardError se = new StandardError(Instant.now(), hs.value(), error, request.getRequestURI(), e.getMessage());
		return ResponseEntity.status(hs).body(se);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> dataIntegrityViolation(DatabaseException e, HttpServletRequest request){
		String error = "Data integrity violation.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError se = new StandardError(Instant.now(), status.value(), error, request.getRequestURI(), e.getMessage());
		return ResponseEntity.status(status).body(se);
	}

}
