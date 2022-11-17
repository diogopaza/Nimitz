package com.nimitz.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusServicoDto {
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
