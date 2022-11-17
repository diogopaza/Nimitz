package com.nimitz.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.nimitz.models.StatusServicoModel;
import com.nimitz.repositories.StatusServicoRepository;

@Service
public class StatusServicoService {
    private StatusServicoRepository statusServicoRepository;

    public StatusServicoService(StatusServicoRepository statusServicoRepository) {
        this.statusServicoRepository = statusServicoRepository;
    }

    public String saveStatus() {
        System.out.println("Service Sr Senior");
        Document document;
        Elements elements;
        
        try {
            document = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();
            elements = document.getElementsByClass("linhaImparCentralizada");
            for (Element tr : elements) {
                var statusServicoModel = new StatusServicoModel();
                Elements td = tr.select("td");
                statusServicoModel.setNomeEstado(td.get(0).text());  
                statusServicoModel.setAutorizacao4(td.get(1).select("img").attr("abs:src"));
                statusServicoModel.setRetornoAutorizacao4(td.get(2).select("img").attr("abs:src"));
                statusServicoModel td.get(3).select("img").attr("abs:src");
                statusServicoModel td.get(4).select("img").attr("abs:src");
                statusServicoModel td.get(5).select("img").attr("abs:src");
                statusServicoModel td.get(6).select("img").attr("abs:src");
                statusServicoModel td.get(7).select("img").attr("abs:src");
                statusServicoModel td.get(8).select("img").attr("abs:src");               
                statusServicoRepository.save(statusServicoModel);                
            }
        } catch (Exception e) {
            System.out.println("DEU ERRO SENIOR DIOGO");
        }
        return "ok";
    }

}