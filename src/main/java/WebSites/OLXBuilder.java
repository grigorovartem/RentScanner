package WebSites;

import Interfaces.UrlBuilder;
import Main.RentProperties;

public class OLXBuilder implements UrlBuilder {
   // public RentProperties properties = ;

    @Override
    public String build(RentProperties properties) {
        String url = "http://olx.ua/uk/nedvizhimost/arenda-kvartir/kiev/?search%5Bfilter_float" +
                "_price%3Afrom%5D="+ properties.getPriceFrom()+"&search%5Bfilter_float_" +
                "price%3Ato%5D="+ properties.getPriceTo()+"&search%5Bdistrict_id%5D="+ properties.getDistrict();
        return url;
    }
}
