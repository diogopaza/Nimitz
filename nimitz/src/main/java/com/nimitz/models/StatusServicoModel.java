package com.nimitz.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_STATUS_SERVICE")
@Primary 
public class StatusServicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
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
}
