package com.nimitz.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimitz.dtos.StatusServicoDto;
import com.nimitz.models.StatusServicoModel;
import com.nimitz.services.StatusServicoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/status")
public class StatusServicoController {

	private final StatusServicoService statusServicoService;

	public StatusServicoController(StatusServicoService statusServicoService) {
		this.statusServicoService = statusServicoService;
	}

	@GetMapping()
	public ResponseEntity<List<StatusServicoDto>> getStatusAtualServicos() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(statusServicoService.saveStatus());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/all")
	ResponseEntity<List<StatusServicoModel>> getAllServicos() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(statusServicoService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/{estadoAbreviado}")
	public ResponseEntity<List<Optional<StatusServicoModel>>> getStatusServicoForEstado(
			@PathVariable(value = "estadoAbreviado") String estadoAbreviado) {
		List<Optional<StatusServicoModel>> optionals = statusServicoService.findByNome(estadoAbreviado.toUpperCase());
		if (!optionals.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(optionals);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/data/{data}")
	public ResponseEntity<List<Optional<StatusServicoModel>>> getStatusServicoForData(
			@PathVariable(value = "data") String data) {
		List<Optional<StatusServicoModel>> optionals = statusServicoService.findByDataVerificacao(data);
		if (!optionals.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(optionals);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/unavailable")
	public String moreUnavailableService() {
		return "";
	}
}
