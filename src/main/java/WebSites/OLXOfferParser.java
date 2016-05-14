package WebSites;

import Interfaces.OfferParser;
import Interfaces.Processor;
import Main.MainFrame;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class OLXOfferParser implements OfferParser {
    private Document htmlDocument;
    private Processor processor = MainFrame.processor;
    private List<String> linksOnPage = new ArrayList<>();

    @Override
    public List<String> parse(){
        try {

            Connection connection = Jsoup.connect(processor.getUrlBuilder().build(MainFrame.properties));
            htmlDocument = connection.get();
            System.out.println(processor.getUrlBuilder().build(MainFrame.properties));

            Elements offer = htmlDocument.getElementsByClass("offer");
            Elements offersOnPage = offer.select("a[href]");

            for(Element el:offersOnPage){
                linksOnPage.add(el.attr("href"));
            }
            System.out.println(offersOnPage.get(3).absUrl("href"));
            System.out.println(linksOnPage.get(1));

        } catch (Exception ioe) {

            ioe.printStackTrace();
        }
        return linksOnPage;
    }

}
