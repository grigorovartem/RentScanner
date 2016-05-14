package WebSites;

import Interfaces.UrlBuilder;
import Main.MainFrame;
import Main.RentProperties;
import Panels.District;

import javax.swing.*;

public class OLXBuilder implements UrlBuilder {
   // public RentProperties properties = ;

    @Override
    public String build(RentProperties properties) {
        String url = "http://olx.ua/uk/nedvizhimost/arenda-kvartir/kiev/?search%5Bfilter_float" +
                "_price%3Afrom%5D="+ properties.getPriceFrom()+"&search%5Bfilter_float_" +
                "price%3Ato%5D="+ properties.getPriceTo()+"&search%5Bdistrict_id%5D="+ properties.getDistrict();
        return url;
    }

    @Override
    public void chooseOfDistrict(){
    for (int i = 0; i<District.getCheckboxes().size(); i++) {
        if (District.getCheckboxes().get(i).isSelected()) {

            MainFrame.properties.setDistrict(i*2+1);
            System.out.println(MainFrame.properties.getDistrict());
        }
        }
    }
}
