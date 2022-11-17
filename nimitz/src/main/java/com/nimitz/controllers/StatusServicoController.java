package com.nimitz.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimitz.dtos.StatusServicoDto;
import com.nimitz.services.StatusServicoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/status")
public class StatusServicoController {

	private StatusServicoService servicoService;

	public StatusServicoController(StatusServicoService statusServicoService) {
		this.servicoService = statusServicoService;
	}

	@GetMapping
	public ResponseEntity<List<StatusServicoDto>> getStatusAtualServicos() {
		System.out.println("Executando controler /");
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicoService.saveStatus());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/{estadoAbreviado}")
	public ResponseEntity<StatusServicoDto> getOneStatusServico(
			@PathVariable(value = "estadoAbreviado") String estadoAbreviado) {
			statusServicoService.find
				
				return null;
				
	}
}
