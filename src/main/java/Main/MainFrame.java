package Main;

import Enums.DistrictEnum;
import Enums.UrlEnum;
import Panels.District;
import Panels.Price;
import Panels.Url;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainFrame extends JPanel implements ActionListener {

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_LENGTH = 500;
    private District districtPanel;
    private Price price;
    private Url urlPanel;

    private Thread startThread;

    public static boolean addLink(Offer offer, Set<Offer> links){
        boolean bool = true;

        for (Offer link:links){
            if(link.getLink().equals(offer.getLink())){
                bool = false;
                break;
            }
        }
        return bool;
    }

    public MainFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_LENGTH);
        BoxLayout mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(mainLayout);
        setAlignmentX(CENTER_ALIGNMENT);

        urlPanel = new Url();

        price = new Price();

        districtPanel = new District();

        JButton start = new JButton("Start");
        start.addActionListener(this);

        add(urlPanel);
        add(price);
        add(districtPanel);
        add(start);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (startThread != null) startThread.interrupt();

        RentProperties properties = new RentProperties();
        Filter filter = properties.getFilter();
        List<UrlEnum> services = new ArrayList<>();
        getService(properties, filter, services);
    }

    private void getService(RentProperties properties, Filter filter, List<UrlEnum> services) {
        for (JRadioButton jRadioButton : urlPanel.getRadioButtons()) {
            if (jRadioButton.isSelected()) {
                services.add(UrlEnum.valueOf(jRadioButton.getName()));
                System.out.println(jRadioButton.getName());

                properties.setService(services);
                filter.setPriceFrom(price.getFrom());
                filter.setPriceTo(price.getTo());
                List<DistrictEnum> district = getDistricts();
                filter.setDistrict(district);
                startThread = new Thread(new CrawlerThread(properties));
                startThread.start();
            }
        }
    }

    private List<DistrictEnum> getDistricts() {
        List<DistrictEnum> district = new ArrayList<>();
        for (JCheckBox checkBox : districtPanel.getCheckboxes())
            if (checkBox.isSelected()) {
                district.add(DistrictEnum.valueOf(checkBox.getName()));
                System.out.println(DistrictEnum.valueOf(checkBox.getName()));
            }
        return district;
    }
}
