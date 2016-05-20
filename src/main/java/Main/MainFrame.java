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

public class MainFrame extends JPanel implements ActionListener {

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_LENGTH = 500;
    private final District districtPanel;
    private final Price price;
    private final Url urlPanel;

    private JPanel buttonPanel;
    private Thread startThread;

    public MainFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_LENGTH);

        JButton start = new JButton("Start");

        buttonPanel = new JPanel();
        buttonPanel.add(start);
        start.addActionListener(this);

        add(buttonPanel, BorderLayout.SOUTH);
        districtPanel = new District();
        add(districtPanel, BorderLayout.EAST);
        price = new Price();
        add(price, BorderLayout.CENTER);
        urlPanel = new Url();
        add(urlPanel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (startThread != null) startThread.interrupt();

        RentProperties properties = new RentProperties();
        List<UrlEnum> services = new ArrayList<>();
        for (JRadioButton jRadioButton : urlPanel.getRadioButtons()) {
            if (jRadioButton.isSelected())
                services.add(UrlEnum.valueOf(jRadioButton.getName()));
                System.out.println(jRadioButton.getName());

            properties.setService(services);
            properties.setPriceFrom(price.getFrom());
            properties.setPriceTo(price.getTo());
            List<DistrictEnum> district = new ArrayList<>();
            for(JCheckBox checkBox:District.getCheckboxes())
                if(checkBox.isSelected()){
                    district.add(DistrictEnum.valueOf(checkBox.getName()));
                    System.out.println(DistrictEnum.valueOf(checkBox.getName()));}
            properties.setDistrict(district);
            startThread = new Thread(new CrawlerThread(properties));
            startThread.start();
        }
    }
}
