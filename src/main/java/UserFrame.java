import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 19.04.16.
 */
public class UserFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setVisible(true);
            }
        });
    }
}
