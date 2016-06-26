package Main;

import Enums.UrlEnum;

import java.io.Serializable;
import java.util.List;

public class RentProperties implements Serializable{

    private Filter filter = new Filter();
    private List<UrlEnum> service;
    private int delay;
    private boolean openBrowser;

    public boolean isOpenBrowser() {
        return openBrowser;
    }

    public void setOpenBrowser(boolean openBrowser) {
        this.openBrowser = openBrowser;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

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
