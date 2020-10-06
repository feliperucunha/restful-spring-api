package com.felipecunha.viasoft.webscrapper.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Scrapper {
    public Scrapper() throws IOException {
        String url = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx";
        Document page = Jsoup.connect(url).userAgent("Viasoft Scrapper").get();

        String table = "tbody > tr";
        Elements tableElements = page.select(table);
        ArrayList<String> tableTitles = new ArrayList<>();

        for (Element e:tableElements) {
            tableTitles.add(e.text());
        }

        for (String s:tableTitles) {
            System.out.println(s);
        }
    }
}
