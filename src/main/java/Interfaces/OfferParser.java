package Interfaces;

import java.util.ArrayList;
import java.util.List;

public interface OfferParser {
     List<String> links = new ArrayList<>();

     List<String> parse(String content);

}
