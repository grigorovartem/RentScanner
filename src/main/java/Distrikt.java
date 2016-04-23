import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Distrikt extends JPanel implements ActionListener {

    private static JCheckBox goloseevskiy;
    private static JCheckBox darnitskiy;
    private static JCheckBox desnyanskiy;
    private static JCheckBox dneprovskiy;
    private static JCheckBox obolonskiy;
    private static JCheckBox pecherskiy;
    private static JCheckBox podolskiy;
    private static JCheckBox svyatoshiskiy;
    private static JCheckBox solomenskiy;
    private static JCheckBox shevchenkovskiy;

    public Distrikt() {

        goloseevskiy = new JCheckBox("Голосеевский");
        goloseevskiy.addActionListener(this);
        darnitskiy = new JCheckBox("Дарницкий");
        darnitskiy.addActionListener(this);
        desnyanskiy = new JCheckBox("Деснянский");
        desnyanskiy.addActionListener(this);
        dneprovskiy = new JCheckBox("Днепровский");
        dneprovskiy.addActionListener(this);
        obolonskiy = new JCheckBox("Оболоньский");
        obolonskiy.addActionListener(this);
        pecherskiy = new JCheckBox("Печерский");
        pecherskiy.addActionListener(this);
        podolskiy = new JCheckBox("Подольский");
        podolskiy.addActionListener(this);
        svyatoshiskiy = new JCheckBox("Святошинский");
        svyatoshiskiy.addActionListener(this);
        solomenskiy = new JCheckBox("Соломенский");
        solomenskiy.addActionListener(this);
        shevchenkovskiy = new JCheckBox("Шевченковский");
        shevchenkovskiy.addActionListener(this);
    }

    public static JPanel getPanel(){

        JPanel checkPanel = new JPanel();
        checkPanel.add(goloseevskiy);
        checkPanel.add(darnitskiy);
        checkPanel.add(desnyanskiy);
        checkPanel.add(dneprovskiy);
        checkPanel.add(obolonskiy);
        checkPanel.add(pecherskiy);
        checkPanel.add(podolskiy);
        checkPanel.add(svyatoshiskiy);
        checkPanel.add(solomenskiy);
        checkPanel.add(shevchenkovskiy);
        checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.Y_AXIS));

        return checkPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(goloseevskiy.isSelected())
            System.out.println("Голосеевский");
        else if(darnitskiy.isSelected())
            System.out.println("Дарницкий");
    }
}
