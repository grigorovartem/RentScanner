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
        for (JCheckBox jCheckbox : districtPanel.getCheckboxes()) {
            if (jCheckbox.isSelected()) {
                System.out.println("YO-HO-HO!!!");
                RentProperties.setDistrict(1);
            }
        }
        RentProperties.setPriceFrom(price.getFrom());
        RentProperties.setPriceTo(price.getTo());

        if (startThread == null) {
            startThread = new Thread(new CrawlerThread());
            startThread.start();
        } else startThread.interrupt();
    }
}
