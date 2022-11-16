package com.nimitz.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class StatusServicoController {
    @GetMapping
    public String getStatusServicos(){
        Document document;
        try {
			document = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();
			Elements trs = document.getElementsByClass("linhaImparCentralizada");
			for (Element tr : trs) {
				Elements td = tr.select("td");
				System.out.println(td.size());
				System.out.println(td.get(0).text());
				for (int i = 1; i < td.size(); i++) {
					String result =  td.get(i).select("img").attr("abs:src");
                    if (result.contains("verde")){
                        System.out.println("sim");
                    }else{
                        System.out.println("nao");

                    }                     				
				}
			}
		} catch (Exception e) {
			System.out.println("DEU ERRO SENIOR DIOGO");
		}
        return "Diogo senior";
    }
}
