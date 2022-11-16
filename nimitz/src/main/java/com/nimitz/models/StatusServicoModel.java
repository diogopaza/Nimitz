package com.nimitz.models;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusServicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private UUID id;
    private String nome;
    private String autorizacao4;
    private String retornoAutorizacao4;
    private String inutilizacao4;
    private String consultaProtocolo4;
    private String statusServico4;
    private String tempoMedio;
    private String consultaCadastro4;
    private String recepcaoEvento4;
}
