package Interfaces;

import org.apache.http.ParseException;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Processor {
    private static List<String> links = new ArrayList<>();

    public abstract UrlBuilder getUrlBuilder();

    public abstract OfferParser getOfferParser();

    public List<String> process(/*RentProperties properties*/)throws IOException, ParseException {

        List<String> linksOnPage = getOfferParser().parse();

        System.out.println("Found (" + linksOnPage.size() + ") offers");
        if (links.size() == 0) {
            for (String link : linksOnPage) {
                links.add(link);
            }
        }

        for (String link : linksOnPage) {
            if (!links.contains(link)) {
                System.out.println(link);
                links.add(link);
                Desktop d = Desktop.getDesktop();
                //d.browse(new URI(link.absUrl("href")));
            }
        }
            return links;
        }
    }



