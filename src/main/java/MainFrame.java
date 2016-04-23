import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_LENGTH = 500;

    private JPanel buttonPanel;
    private Thread startThread;

    public MainFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_LENGTH);

        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");

        buttonPanel = new JPanel();
        buttonPanel.add(start);
        buttonPanel.add(stop);

        add(buttonPanel, BorderLayout.SOUTH);
        add(Distrikt.getPanel(), BorderLayout.EAST);
        add(Price.getPanel(), BorderLayout.CENTER);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startThread = new Thread(new CrawlerThread());
                startThread.start();
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startThread.interrupt();
            }
        });
    }
}
