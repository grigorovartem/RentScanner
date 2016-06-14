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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public abstract class Processor {

    public abstract UrlBuilder getUrlBuilder();

    public abstract OfferParser getOfferParser();

    public List<Offer> process(Filter filter) throws IOException, ParseException {

        List<String> contents = getContents(filter);

        return getOffers(contents);
    }

    private List<String> getContents(Filter filter) throws IOException {
        List<String> contents = new ArrayList<>();

        for (String service : getUrlBuilder().build(filter)) {
            HttpGet httpGet = new HttpGet(service);
            try (CloseableHttpClient client = HttpClients.createDefault();
                 CloseableHttpResponse response = client.execute(httpGet)) {
                contents.add(EntityUtils.toString(response.getEntity(), Charset.defaultCharset()));
            }
        }
        return contents;
    }

    private List<Offer> getOffers(List<String> contents) {
        List<Offer> offerList = new ArrayList<>();
        for (String content : contents) {
            offerList.addAll(getOfferParser().parse(content));
        }
        System.out.println("Found (" + offerList.size() + ") offers");
        return offerList;
    }
}



