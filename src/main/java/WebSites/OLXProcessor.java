package WebSites;

import Interfaces.OfferParser;
import Interfaces.Processor;
import Interfaces.UrlBuilder;

public class OLXProcessor extends Processor {
    @Override
    public UrlBuilder getUrlBuilder() {
        return new OLXBuilder();
    }

    @Override
    public OfferParser getOfferParser() {
        return new OLXOfferParser();
    }

}
