package Enums;

import FN.FNProcessor;
import Interfaces.Processor;
import LUN.LUNProcessor;
import WebSites.OLXProcessor;

public enum UrlEnum {
    OLX("OLX", new OLXProcessor()),
    LUN("LUN", new LUNProcessor()),
    FN("FN", new FNProcessor());

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
