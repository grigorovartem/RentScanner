package WebSites;

import Interfaces.OfferParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class OLXOfferParser implements OfferParser {
    private Document htmlDocument;
    private List<String> linksOnPage = new ArrayList<>();

    @Override
    public List<String> parse(String content){
        try {

            htmlDocument = Jsoup.parse(content);
            //System.out.println(content);

            Elements offer = htmlDocument.getElementsByClass("offer");
            Elements offersOnPage = offer.select("a[href]");

            for(Element el:offersOnPage){
                linksOnPage.add(el.attr("href"));
            }
            //AboutParser aboutParser = new OLXAbout();
            //aboutParser.parseAbout();
            //System.out.println(offersOnPage.get(3).absUrl("href"));
            //System.out.println(linksOnPage.get(1));

        } catch (Exception ioe) {

            ioe.printStackTrace();
        }
        return linksOnPage;
    }

}
