package com.nimitz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nimitz.dtos.StatusServicoDto;
import com.nimitz.models.StatusServicoModel;
import com.nimitz.repositories.StatusServicoRepository;

@Service
public class StatusServicoService {
    private StatusServicoRepository statusServicoRepository;

    public StatusServicoService(StatusServicoRepository statusServicoRepository) {
        this.statusServicoRepository = statusServicoRepository;
    }

    public List<StatusServicoDto> saveStatus() {
        Document document;
        Elements elementsImpar;
        Elements elementsPar;
        List<StatusServicoDto> listStatusServicoDto = new ArrayList<>();
        try {
            document = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();
            elementsImpar = document.getElementsByClass("linhaImparCentralizada");
            for (Element tr : elementsImpar) {
                var statusServicoModel = new StatusServicoModel();
                var statusServicoDto = new StatusServicoDto();
                Elements td = tr.select("td");
                statusServicoModel.setNomeEstado(td.get(0).text());
                statusServicoModel.setAutorizacao(verifyStatus(td.get(1).select("img").attr("abs:src")));
                statusServicoModel.setRetornoAutorizacao(verifyStatus(td.get(2).select("img").attr("abs:src")));
                statusServicoModel.setInutilizacao(verifyStatus(td.get(3).select("img").attr("abs:src")));
                statusServicoModel.setConsultaProtocolo(verifyStatus(td.get(4).select("img").attr("abs:src")));
                statusServicoModel.setStatusServico(verifyStatus(td.get(5).select("img").attr("abs:src")));
                statusServicoModel.setTempoMedio(verifyStatus(td.get(6).select("img").attr("abs:src")));
                statusServicoModel.setConsultaCadastro(verifyStatus(td.get(7).select("img").attr("abs:src")));
                statusServicoModel.setRecepcaoEvento(verifyStatus(td.get(8).select("img").attr("abs:src")));
                statusServicoRepository.save(statusServicoModel);
                BeanUtils.copyProperties(statusServicoModel, statusServicoDto);
                listStatusServicoDto.add(statusServicoDto);
            }
            elementsPar = document.getElementsByClass("linhaParCentralizada");
            for (Element tr : elementsPar) {
                var statusServicoModel = new StatusServicoModel();
                var statusServicoDto = new StatusServicoDto();
                Elements td = tr.select("td");
                statusServicoModel.setNomeEstado(td.get(0).text());
                statusServicoModel.setAutorizacao(verifyStatus(td.get(1).select("img").attr("abs:src")));
                statusServicoModel.setRetornoAutorizacao(verifyStatus(td.get(2).select("img").attr("abs:src")));
                statusServicoModel.setInutilizacao(verifyStatus(td.get(3).select("img").attr("abs:src")));
                statusServicoModel.setConsultaProtocolo(verifyStatus(td.get(4).select("img").attr("abs:src")));
                statusServicoModel.setStatusServico(verifyStatus(td.get(5).select("img").attr("abs:src")));
                statusServicoModel.setTempoMedio(verifyStatus(td.get(6).select("img").attr("abs:src")));
                statusServicoModel.setConsultaCadastro(verifyStatus(td.get(7).select("img").attr("abs:src")));
                statusServicoModel.setRecepcaoEvento(verifyStatus(td.get(8).select("img").attr("abs:src")));
                statusServicoRepository.save(statusServicoModel);
                BeanUtils.copyProperties(statusServicoModel, statusServicoDto);
                listStatusServicoDto.add(statusServicoDto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao gravar no banco de dados");
        }
        return listStatusServicoDto;
    }

    public String verifyStatus(String color) {
        if (color.contains("verde")) {
            return "verde";
        } else if (color.contains("amarelo")) {
            return "amarelo";
        } else if (color.contains("vermelho")) {
            return "vermelho";
        }
        return "";
    }

    public List<Optional<StatusServicoModel>> findByNome(String nomeEstadoAbreviado) {
        return statusServicoRepository.findByNomeEstado(nomeEstadoAbreviado);
    }

    public List<StatusServicoModel> findAll() {
        return statusServicoRepository.findAll();
    }

    public List<Optional<StatusServicoModel>> findByDataVerificacao(String dataVerificacao) {
        return statusServicoRepository.findByDataVerificacao(dataVerificacao);
    }

    public void save(StatusServicoModel statusServicoModel) {
        statusServicoRepository.save(statusServicoModel);
    }

}