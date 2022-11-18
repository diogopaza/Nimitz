package com.nimitz;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nimitz.services.StatusServicoService;

@Component
@EnableScheduling
public class VerifiyStatusController {
    private final long TEMPO_EXECUCAO = (5 * (1000 * 60));
    private final StatusServicoService statusServicoService;

    public VerifiyStatusController(StatusServicoService statusServicoService) {
        this.statusServicoService = statusServicoService;
    }

    @Scheduled(fixedDelay = TEMPO_EXECUCAO)
    public void getStatus() {
        statusServicoService.saveStatus();
        System.out.println("Executando");
    }
}
