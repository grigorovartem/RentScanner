package Interfaces;

import Main.Filter;
import Main.Offer;
import Main.RentProperties;
import org.apache.commons.io.IOUtils;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Processor {

    public abstract UrlBuilder getUrlBuilder();

    public abstract OfferParser getOfferParser();

    public List<Offer> process(Filter filter)throws IOException, ParseException {

        List<String> contents = new ArrayList<>();
        //FIXME почему клиент не в try-with-resources
        //FIXME отформатировать код через ctrl+alt+L
        //FIXME разнести в приватные методы получение контекта всех страниц и парсинг их
        CloseableHttpClient client = HttpClients.createDefault();
        for(String service:getUrlBuilder().build(filter)) {
            HttpGet httpGet = new HttpGet(service);
            try(CloseableHttpResponse response = client.execute(httpGet)){
            contents.add(EntityUtils.toString(response.getEntity()));

        }}
        List<Offer> offerList = new ArrayList<>();
        for(String content:contents) {
            //FIXME Не будет работать. Каждый раз заменяешь результат.
            offerList = getOfferParser().parse(content);
        }
        System.out.println("Found (" + offerList.size() + ") offers");

            return offerList;
        }
    }



