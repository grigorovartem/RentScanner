import java.net.URISyntaxException;

public class CrawlerThread implements Runnable {

    public void run() {
        while (!Thread.interrupted()) {
            try {
                Crawler.crawl("http://olx.ua/uk/nedvizhimost/arenda-kvartir/kiev/?search%5Bfilter_float_price%3Afrom%5D=2000&search%5Bfilter_float_price%3Ato%5D=6000&search%5Bdistrict_id%5D=3");
                Thread.sleep(60000);
            } catch (URISyntaxException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

