package Main;

import Enums.DistrictEnum;
import Enums.UrlEnum;

import java.util.List;

public class RentProperties {

    private String priceFrom;
    private String priceTo;
    private List<DistrictEnum> district;
    private List<UrlEnum> service;

    public List<UrlEnum> getService() {
        return service;
    }

    public void setService(List<UrlEnum> service) {
        this.service = service;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public List<DistrictEnum> getDistrict() {
        return district;
    }

    public void setDistrict(List<DistrictEnum> district) {
        this.district = district;
    }

    public String getPriceFrom() {

        return priceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }
}
