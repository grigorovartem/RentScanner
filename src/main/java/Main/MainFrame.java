package Main;

import Interfaces.Processor;
import Interfaces.UrlBuilder;
import Panels.District;
import Panels.Price;
import Panels.Url;
import WebSites.OLXBuilder;
import WebSites.OLXProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_LENGTH = 500;
    private final District districtPanel;
    private final Price price;
    private final Url urlPanel;

    private JPanel buttonPanel;
    private Thread startThread;
    public static RentProperties properties = new RentProperties();
    public static Processor processor;

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

        for (JRadioButton jRadioButton : urlPanel.getRadioButtons()) {
            if (jRadioButton.isSelected())
                switch (jRadioButton.getActionCommand()) {
                    case ("LUN"):
                        System.out.println("LUN Button");
                        break;
                    case ("OLX"):
                        System.out.println("OLX Button");
                        processor = new OLXProcessor();
                        break;
                }
            /*for (JCheckBox jCheckbox : districtPanel.getCheckboxes()) {
                if (jCheckbox.isSelected()) {
                    System.out.println("YO-HO-HO!!!");
                    properties.setDistrict(1);
                }
            }*/
            properties.setPriceFrom(price.getFrom());
            properties.setPriceTo(price.getTo());
            processor.getUrlBuilder().chooseOfDistrict();
            startThread = new Thread(new CrawlerThread());
            startThread.start();
        }
    }
}
