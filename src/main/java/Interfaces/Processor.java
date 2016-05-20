package Interfaces;

import Main.RentProperties;
import org.apache.commons.io.IOUtils;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Processor {
    private static List<String> linksOnPage = new ArrayList<>();

    public abstract UrlBuilder getUrlBuilder();

    public abstract OfferParser getOfferParser();

    public abstract AboutParser getAboutParser();

    RentProperties properties;
    List<String> contents = new ArrayList<>();

    public List<String> process(RentProperties properties)throws IOException, ParseException {

        //content with Apache(String)
        CloseableHttpClient client = HttpClients.createDefault();
        for(String service:getUrlBuilder().build(properties)) {
            HttpGet httpGet = new HttpGet(service);
            CloseableHttpResponse response = client.execute(httpGet);

            contents.add(IOUtils.toString(response.getEntity().getContent()));
            response.close();
        }
        for(String content:contents) {
            linksOnPage = getOfferParser().parse(content);

        System.out.println("Found (" + linksOnPage.size() + ") offers");
        }

        //getAboutParser().parseAbout();

            return linksOnPage;
        }
    }



