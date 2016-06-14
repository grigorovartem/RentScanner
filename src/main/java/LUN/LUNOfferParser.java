package LUN;

import Interfaces.OfferParser;
import Main.Offer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class LUNOfferParser implements OfferParser{
    private Document htmlDocument;
    private List<Offer> offerList = new ArrayList<>();

    @Override
    public List<Offer> parse(String content){
        try {

            htmlDocument = Jsoup.parse(content);
            Elements offers = htmlDocument.getElementsByClass("obj");

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
        offer.setLink("http://www.lun.ua"+element.select("a[href]").attr("href"));
        offer.setPrice(element.getElementsByClass("obj-price").text());
        offer.setDescription(element.getElementsByClass("wrap").text());

        return offer;
    }
}
