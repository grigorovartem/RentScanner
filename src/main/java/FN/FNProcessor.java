package FN;

import Interfaces.OfferParser;
import Interfaces.Processor;
import Interfaces.UrlBuilder;

public class FNProcessor extends Processor {

    //TODO Реализовать lun processor , и фото недвижимость процессор
    @Override
    public UrlBuilder getUrlBuilder() {
        return new FNBuilder();
    }

    @Override
    public OfferParser getOfferParser() {
        return new FNOfferParser();
    }

}
