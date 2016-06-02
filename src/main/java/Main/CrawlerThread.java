package Main;

import Enums.UrlEnum;
import WebSites.OffersView;

import java.io.IOException;
import java.util.*;
import java.util.List;

public class CrawlerThread implements Runnable {

    private static final int DELAY_SECONDS = 60;
    private RentProperties properties;
    private Set<Offer> links = new HashSet<>();
    private Set<Offer> newOffers = new HashSet<>();

    public CrawlerThread(RentProperties properties) {
        this.properties = properties;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Thread run!");
                List<Offer> offerList = null;
                for (UrlEnum service : properties.getService()) {
                    offerList = service.getProcessor().process(properties.getFilter());
                    if (links.isEmpty()) {
                        System.out.println("Empty");
                        links.addAll(offerList);
                    }

                    System.out.println(links.size() + "Links");

                    for (Offer link : offerList) {
                        if (MainFrame.addLink(link, links)) {
                            System.out.println(link.getLink());
                            newOffers.add(link);
                            links.add(link);
                            OffersView olxAbout = OffersView.getInstance();
                            olxAbout.addOffersView(link);
                        }
                    }
                }
                System.out.println(newOffers.size() + "NewOffers");

                Thread.sleep(DELAY_SECONDS * 1000);
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }


        }
    }
}

