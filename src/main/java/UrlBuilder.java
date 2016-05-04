
public interface UrlBuilder {

    public String priceFrom = RentProperties.getPriceFrom();
    public String priceTo = RentProperties.getPriceTo();
    public int district = RentProperties.getDistrict();

    public void build();
}
