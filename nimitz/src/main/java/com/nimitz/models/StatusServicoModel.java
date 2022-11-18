package com.nimitz.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TB_STATUS_SERVICE")
public class StatusServicoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nomeEstado;
    private String autorizacao;
    private String retornoAutorizacao;
    private String inutilizacao;
    private String consultaProtocolo;
    private String statusServico;
    private String tempoMedio;
    private String consultaCadastro;
    private String recepcaoEvento;
    private String dataVerificacao;

    @PrePersist
    public void setDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dataAtual =  LocalDateTime.now();
        this.dataVerificacao = dataAtual.format(dateTimeFormatter);        
    }
}
