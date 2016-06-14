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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainFrame extends JPanel implements ActionListener {

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_LENGTH = 500;

    private static Set<Offer> links = new HashSet<>();

    private District districtPanel;
    private Price price;
    private JSlider delay;
    private Url urlPanel;
    private JCheckBox open;

    private Thread startThread;

    public static Set<Offer> getLinks() {
        return links;
    }

    public static boolean addLink(Offer offer) {
        boolean bool = true;

        for (Offer link : links) {
            if (link.getLink().equals(offer.getLink())) {
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

        JLabel sliderLabel = new JLabel("Периодичность поиска новых предложений (мин)");

        delay = new JSlider(0, 30);
        delay.setPaintTicks(true);
        delay.setPaintLabels(true);
        delay.setMajorTickSpacing(5);
        delay.setMinorTickSpacing(1);

        open = new JCheckBox("Открывать в браузере новые предложения");

        districtPanel = new District();

        JButton start = new JButton("Start");
        start.addActionListener(this);

        add(urlPanel);
        add(price);
        add(sliderLabel);
        add(delay);
        add(districtPanel);
        add(open);
        add(start);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (startThread != null) startThread.interrupt();

        RentProperties properties = getRentProperties();

        startThread = new Thread(new CrawlerThread(properties));
        startThread.start();
    }

    private List<UrlEnum> getService() {
        List<UrlEnum> services = new ArrayList<>();
        for (JRadioButton jRadioButton : urlPanel.getRadioButtons()) {
            if (jRadioButton.isSelected()) {
                services.add(UrlEnum.valueOf(jRadioButton.getName()));
                System.out.println(jRadioButton.getName());
            }
        }
        return services;
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

    private RentProperties getRentProperties() {
        RentProperties properties = new RentProperties();
        properties.setService(getService());
        properties.setDelay(delay.getValue());

        if(open.isSelected()){
            properties.setOpenBrowser(true);
        }

        List<DistrictEnum> district = getDistricts();

        Filter filter = properties.getFilter();
        filter.setPriceFrom(price.getFrom());
        filter.setPriceTo(price.getTo());
        filter.setDistrict(district);

        return properties;
    }
}
