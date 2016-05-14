/*package WebSites;

import Main.Crawler;
import Main.CrawlerThread;
import Main.RentProperties;
import org.jsoup.nodes.Element;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class OLXThread extends CrawlerThread {
    private static java.util.List<String> links = new ArrayList<>();

    @Override
    public void crawl(String url) throws IOException {
        try{
            ArrayList<Element> linksOnPage = Crawler.connect(url).select("a[href]");

            System.out.println("Found (" + linksOnPage.size() + ") links");
            if (links.size() == 0) {
                for (Element link : linksOnPage) {
                    links.add(link.absUrl("href"));
                }
            }

            for (Element link : linksOnPage) {
                if (!links.contains(link.absUrl("href"))) {
                    System.out.println(link.absUrl("href"));
                    links.add(link.absUrl("href"));
                    Desktop d = Desktop.getDesktop();
                    d.browse(new URI(link.absUrl("href")));
                }
            }}catch (URISyntaxException use){use.printStackTrace();}

    }


    @Override
    public String build() {
        String url = "http://olx.ua/uk/nedvizhimost/arenda-kvartir/kiev/?search%5Bfilter_float" +
                "_price%3Afrom%5D="+ RentProperties.getPriceFrom()+"&search%5Bfilter_float_" +
                "price%3Ato%5D="+ RentProperties.getPriceTo()+"&search%5Bdistrict_id%5D="+ RentProperties.getDistrict();
        return url;
    }
}*/
