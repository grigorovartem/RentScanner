package LUN;

import Enums.DistrictEnum;
import Interfaces.UrlBuilder;
import Main.Filter;

import java.util.ArrayList;
import java.util.List;

public class LUNBuilder implements UrlBuilder{

    @Override
    public List<String> build(Filter filter) {
        List<String> services = new ArrayList<>();

        for (DistrictEnum district : filter.getDistrict()) {
            String url = "http://www.lun.ua/%D0%B0%D1%80%D0%B5%D0%BD%D0%B4%D0%B0-%D0%BA%D0%B2%D0%B0%D1%80%D1%82%D0%B8%D1%80-%D0%BA%D0%B8%D0%B5%D0%B2?" +
                    "district="+districtIndex(district)+"&priceMax="+filter.getPriceTo()+"&currency=2";
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
                return index = 2;
            case DESNYANSKIY:
                return index = 3;
            case DNEPROVSKIY:
                return index = 4;
            case OBOLONSKIY:
                return index = 5;
            case PECHERSKIY:
                return index = 6;
            case PODOLSKIY:
                return index = 7;
            case SVYATOSHINSKIY:
                return index = 8;
            case SOLOMENSKIY:
                return index = 9;
            default:
                return index = 10;
        }
    }
}
