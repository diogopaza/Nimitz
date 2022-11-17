package com.nimitz.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimitz.services.StatusServicoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class StatusServicoController {

	private StatusServicoService servicoService;

	public StatusServicoController(StatusServicoService statusServicoService) {
		this.servicoService = statusServicoService;
	}

	@GetMapping
	public String getStatusServicos() {
		System.out.println("Executando controler /");
		return servicoService.saveStatus();
	}
}
