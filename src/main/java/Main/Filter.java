package Main;


import Enums.DistrictEnum;

import java.util.List;

public class Filter {

    private int priceFrom;
    private int priceTo;
    private List<DistrictEnum> district;

    public int getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(int priceTo) {
        this.priceTo = priceTo;
    }

    public List<DistrictEnum> getDistrict() {
        return district;
    }

    public void setDistrict(List<DistrictEnum> district) {
        this.district = district;
    }

    public int getPriceFrom() {

        return priceFrom;
    }

    public void setPriceFrom(int priceFrom) {
        this.priceFrom = priceFrom;
    }
}
