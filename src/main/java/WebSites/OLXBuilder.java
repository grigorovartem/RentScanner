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
                index = 1;
                break;
            case DARNITSKIY:
                index = 3;
                break;
            case DESNYANSKIY:
                index = 5;
                break;
            case DNEPROVSKIY:
                index = 7;
                break;
            case OBOLONSKIY:
                index = 9;
                break;
            case PECHERSKIY:
                index = 11;
                break;
            case PODOLSKIY:
                index = 13;
                break;
            case SVYATOSHINSKIY:
                index = 15;
                break;
            case SOLOMENSKIY:
                index = 17;
                break;
            case SHEVCHENKOVSKIY:
                index = 19;
        }
        return index;
    }
}
