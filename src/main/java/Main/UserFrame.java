package Main;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_LENGTH = 500;
    public static JPanel about;
    public UserFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_LENGTH);
        setTitle("RentScanner");
        MainFrame mainFrame = new MainFrame();
        JTabbedPane tabbedPane = new JTabbedPane();
        this.add(tabbedPane);
        tabbedPane.add("Properties", mainFrame);
        about = new JPanel();
        tabbedPane.add("About", about);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserFrame userFrame = new UserFrame();

            }
        });
    }
}
