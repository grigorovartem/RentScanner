package FN;

import Interfaces.OfferParser;
import Main.Offer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class FNOfferParser implements OfferParser{
    private Document htmlDocument;
    private List<Offer> offerList = new ArrayList<>();

    @Override
    public List<Offer> parse(String content){
        try {

            htmlDocument = Jsoup.parse(content, "UTF-8");
            Elements offers = htmlDocument.getElementsByClass("offer-desc");

            for (Element element : offers){
                offerList.add(extractOffer(element));
            }

        } catch (Exception ioe) {

            ioe.printStackTrace();
        }
        return offerList;
    }

    private Offer extractOffer (Element element){
        Offer offer = new Offer();
        offer.setLink("http://fn.ua/"+element.select("a[href]").attr("href"));
        offer.setPrice(element.getElementsByClass("price").text());
        offer.setDescription(element.getElementsByTag("p").text());

        return offer;
    }
}
