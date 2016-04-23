import java.net.URISyntaxException;

public class CrawlerThread implements Runnable {

    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Thread run!");
                Crawler.crawl(
                        "http://olx.ua/uk/nedvizhimost/arenda-kvartir/kiev/?search%5Bfilter_float" +
                                "_price%3Afrom%5D="+RentProperties.getPriceFrom()+"&search%5Bfilter_float_" +
                                "price%3Ato%5D="+RentProperties.getPriceTo()+"&search%5Bdistrict_id%5D="+RentProperties.getDistrict());
                Thread.sleep(60000);
            } catch (URISyntaxException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

