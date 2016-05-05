package Main;

import Interfaces.Offers;
import Interfaces.UrlBuilder;

import java.io.IOException;

public abstract class CrawlerThread implements Runnable, Offers, UrlBuilder {

    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Thread run!");
                this.crawl(this.build());
                Thread.sleep(60000);
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

