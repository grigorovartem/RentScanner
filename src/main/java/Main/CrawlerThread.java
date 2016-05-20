package Main;

import Enums.UrlEnum;
import Interfaces.Processor;
import WebSites.OLXProcessor;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlerThread implements Runnable  {

    private RentProperties properties;

    public CrawlerThread(RentProperties properties) {this.properties = properties;}
        //метод выбора сервиса
    private Processor chooseOfService(RentProperties properties) {
        Processor processor = null;
        for (UrlEnum service : properties.getService())
            switch (service.name()) {
                case ("LUN"):
                    System.out.println("LUN Button");
                    break;
                case ("OLX"):
                    System.out.println(service.name());
                    processor = new OLXProcessor();
                    break;
            }
        return processor;
    }
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Thread run!");
                List<String> linksOnPage = chooseOfService(properties).process(properties);
               // MainFrame.processor.getAboutParser().parseAbout();
                //поиск новых предложений
                List<String> links = new ArrayList<>();

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
                Thread.sleep(60*1000);
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }


        }
    }
}

