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
        checkPanel.add(new Distrikt().goloseevskiy);
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
            RentProperties.setDistrict(1);
        else if(darnitskiy.isSelected())
            RentProperties.setDistrict(3);
        else if(desnyanskiy.isSelected())
            RentProperties.setDistrict(5);
        else if(dneprovskiy.isSelected())
            RentProperties.setDistrict(7);
        else if(obolonskiy.isSelected())
            RentProperties.setDistrict(9);
        else if(pecherskiy.isSelected())
            RentProperties.setDistrict(11);
        else if(podolskiy.isSelected())
            RentProperties.setDistrict(13);
        else if(svyatoshiskiy.isSelected())
            RentProperties.setDistrict(15);
        else if(solomenskiy.isSelected())
            RentProperties.setDistrict(17);
        else if(shevchenkovskiy.isSelected())
            RentProperties.setDistrict(19);
    }
}
