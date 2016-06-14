package Main;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {
    private final int DEFAULT_WIDTH = 700;
    private final int DEFAULT_LENGTH = 500;

    public UserFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_LENGTH);
        setTitle("RentScanner");

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel mainFrame = new MainFrame();
        OffersView listView = OffersView.getInstance();

        tabbedPane.add("Properties", mainFrame);
        tabbedPane.add("Offers", new JScrollPane(listView));

        add(tabbedPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserFrame userFrame = new UserFrame();

            }
        });
    }
}
