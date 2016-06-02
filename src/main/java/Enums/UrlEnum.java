package Enums;

import Interfaces.Processor;
import WebSites.LUNProcessor;
import WebSites.OLXProcessor;

public enum UrlEnum {
    OLX("OLX", new OLXProcessor()),
    LUN("LUN", new LUNProcessor());

    UrlEnum(String displayName, Processor processor) {
        this.displayName = displayName;
        this.processor = processor;
    }

    private String displayName;
    private Processor processor;

    public String getDisplayName() {
        return displayName;
    }

    public Processor getProcessor() {
        return processor;
    }
}
