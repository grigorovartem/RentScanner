package Main;

/**
 * Created by User on 23.04.16.
 */
public class RentProperties {

    private String priceFrom;
    private String priceTo;
    private int district;

    public String getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getPriceFrom() {

        return priceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }
}
