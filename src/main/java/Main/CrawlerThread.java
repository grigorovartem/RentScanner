package Main;

import Enums.UrlEnum;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;

public class CrawlerThread implements Runnable {

    private RentProperties properties;
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
                    if (MainFrame.getLinks().isEmpty()) {
                        System.out.println("Empty");
                        MainFrame.getLinks().addAll(offerList);
                    }

                    System.out.println(MainFrame.getLinks().size() + "Links");

                    for (Offer link : offerList) {
                        //FIXME Посмотреть что такое mapdb и сделать сохранение в файл через mapdb
                        //FIXME Это просто и в файл сразу)

                        if (MainFrame.addLink(link)) {
                            System.out.println(link.getLink());
                            newOffers.add(link);
                            MainFrame.getLinks().add(link);
                            OffersView offersView = OffersView.getInstance();
                            offersView.addOffersView(link);
                            openOffers(link);
                        }
                    }
                }
                System.out.println(newOffers.size() + "NewOffers");
                Thread.sleep(properties.getDelay() * 60000);
            } catch (IOException | InterruptedException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void openOffers(Offer link) throws IOException, URISyntaxException {
        if(properties.isOpenBrowser()){
            Desktop d = Desktop.getDesktop();
            d.browse(new URI(link.getLink()));
        }
    }
}

