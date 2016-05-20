package WebSites;

import Interfaces.AboutParser;
import Interfaces.OfferParser;
import Interfaces.UrlBuilder;
import Interfaces.Processor;

public class OLXProcessor extends Processor {
    @Override
    public UrlBuilder getUrlBuilder() {
        return new OLXBuilder();
    }

    @Override
    public OfferParser getOfferParser() {
        return new OLXOfferParser();
    }

    @Override
    public AboutParser getAboutParser() {
        return new OLXAbout();
    }

}
