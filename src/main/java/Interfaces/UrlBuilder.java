package Interfaces;

import Main.Filter;
import Main.RentProperties;

import java.util.List;

public interface UrlBuilder {

    List<String> build(Filter filter);

}
