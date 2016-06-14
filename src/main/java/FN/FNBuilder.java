package FN;

import Enums.DistrictEnum;
import Interfaces.UrlBuilder;
import Main.Filter;

import java.util.ArrayList;
import java.util.List;

public class FNBuilder implements UrlBuilder{

    @Override
    public List<String> build(Filter filter) {
        List<String> services = new ArrayList<>();

        for (DistrictEnum district : filter.getDistrict()) {
            String url = "http://fn.ua/listing.php?parent_id%5B0%5D=1&parent_id%5B1%5D=9&parent_id%5B2%5D=51&" +
                    "parent_id%5B3%5D="+districtIndex(district)+
                    "&pricemin="+filter.getPriceFrom()+"&pricemax="+filter.getPriceTo()+"&pricecur=1&rooms=0&stxt=";
            services.add(url);
            System.out.println(url);
        }
        return services;
    }

    private int districtIndex(DistrictEnum district) {
        int index = 0;

        switch (district) {
            case GOLOSEEVSKIY:
                return index = 54;
            case DARNITSKIY:
                return index = 55;
            case DESNYANSKIY:
                return index = 56;
            case DNEPROVSKIY:
                return index = 57;
            case OBOLONSKIY:
                return index = 58;
            case PECHERSKIY:
                return index = 59;
            case PODOLSKIY:
                return index = 60;
            case SVYATOSHINSKIY:
                return index = 61;
            case SOLOMENSKIY:
                return index = 62;
            default:
                return index = 63;
        }
    }
}
