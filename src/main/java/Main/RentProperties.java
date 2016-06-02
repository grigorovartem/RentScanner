package Main;

import Enums.UrlEnum;

import java.util.List;

public class RentProperties {

    private Filter filter = new Filter();
    private List<UrlEnum> service;

    public Filter getFilter() {
        return filter;
    }

    public List<UrlEnum> getService() {
        return service;
    }

    public void setService(List<UrlEnum> service) {
        this.service = service;
    }
}
