package LUN;

import Interfaces.OfferParser;
import Interfaces.Processor;
import Interfaces.UrlBuilder;

public class LUNProcessor extends Processor {

    @Override
    public UrlBuilder getUrlBuilder() {
        return new LUNBuilder();
    }

    @Override
    public OfferParser getOfferParser() {
        return new LUNOfferParser();
    }

}
