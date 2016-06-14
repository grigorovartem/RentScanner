package WebSites;

import Enums.DistrictEnum;
import Interfaces.UrlBuilder;
import Main.Filter;
import Main.MainFrame;
import Main.RentProperties;
import Panels.District;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class OLXBuilder implements UrlBuilder {

    @Override
    public List<String> build(Filter filter) {
        List<String> services = new ArrayList<>();

        for (DistrictEnum district : filter.getDistrict()) {
            String url = "http://olx.ua/uk/nedvizhimost/arenda-kvartir/kiev/?search%5Bfilter_float" +
                    "_price%3Afrom%5D=" + filter.getPriceFrom() + "&search%5Bfilter_float_" +
                    "price%3Ato%5D=" + filter.getPriceTo() + "&search%5Bdistrict_id%5D=" + districtIndex(district);
            services.add(url);
            System.out.println(url);
        }
        return services;
    }

    private int districtIndex(DistrictEnum district) {
        int index = 0;

        switch (district) {
            case GOLOSEEVSKIY:
                return index = 1;
            case DARNITSKIY:
                return index = 3;
            case DESNYANSKIY:
                return index = 5;
            case DNEPROVSKIY:
                return index = 7;
            case OBOLONSKIY:
                return index = 9;
            case PECHERSKIY:
                return index = 11;
            case PODOLSKIY:
                return index = 13;
            case SVYATOSHINSKIY:
                return index = 15;
            case SOLOMENSKIY:
                return index = 17;
            default:
                return index = 19;
        }
    }
}
