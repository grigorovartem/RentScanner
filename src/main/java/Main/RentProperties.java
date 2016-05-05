package Main;

/**
 * Created by User on 23.04.16.
 */
public class RentProperties {

    private static String priceFrom;
    private static String priceTo;
    private static int district;

    public static String getPriceTo() {
        return priceTo;
    }

    public static void setPriceTo(String priceTo) {
        RentProperties.priceTo = priceTo;
    }

    public static int getDistrict() {
        return district;
    }

    public static void setDistrict(int district) {
        RentProperties.district = district;
    }

    public static String getPriceFrom() {

        return priceFrom;
    }

    public static void setPriceFrom(String priceFrom) {
        RentProperties.priceFrom = priceFrom;
    }
}
