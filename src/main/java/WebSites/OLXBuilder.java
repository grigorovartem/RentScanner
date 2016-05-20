package WebSites;

import Enums.DistrictEnum;
import Interfaces.UrlBuilder;
import Main.MainFrame;
import Main.RentProperties;
import Panels.District;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class OLXBuilder implements UrlBuilder {

    @Override
    public List<String> build(RentProperties properties) {
        List<String> services = new ArrayList<>();

        for (DistrictEnum district : properties.getDistrict()) {
            String url = "http://olx.ua/uk/nedvizhimost/arenda-kvartir/kiev/?search%5Bfilter_float" +
                    "_price%3Afrom%5D=" + properties.getPriceFrom() + "&search%5Bfilter_float_" +
                    "price%3Ato%5D=" + properties.getPriceTo() + "&search%5Bdistrict_id%5D=" + districtIndex(district);
            services.add(url);
        }
            return services;
        }

    private int districtIndex(DistrictEnum district) {
        int index = 0;

        if (district.name().equals("GOLOSEEVSKIY")) {
            index = 1;
        } else if (district.name().equals("DARNITSKIY")) {
            index = 3;
        }else if (district.name().equals("DESNYANSKIY")) {
            index = 5;
        }else if (district.name().equals("DNEPROVSKIY")) {
            index = 7;
        }else if (district.name().equals("OBOLONSKIY")) {
            index = 9;
        }else if (district.name().equals("PECHERSKIY")) {
            index = 11;
        }else if (district.name().equals("PODOLSKIY")) {
            index = 13;
        }else if (district.name().equals("SVYATOSHINSKIY")) {
            index = 15;
        }else if (district.name().equals("SOLOMENSKIY")) {
            index = 17;
        }else if (district.name().equals("SHEVCHENKOVSKIY")) {
            index = 19;
        }

        return index;
    }
}
