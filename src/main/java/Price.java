import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

public class Price extends JPanel implements PropertyChangeListener {

    private static JFormattedTextField from;
    private static JFormattedTextField to;

    public  Price() {
        NumberFormat format = NumberFormat.getNumberInstance();
        from = new JFormattedTextField(format);
        from.setColumns(5);
        from.addPropertyChangeListener("value", this);
        to = new JFormattedTextField(format);
        to.setColumns(5);
        to.addPropertyChangeListener("value", this);
    }

        public static JPanel getPanel() {
            JPanel pricePanel = new JPanel();
            pricePanel.add(new JLabel("Цена от:"));
            pricePanel.add(new Price().from);
            pricePanel.add(new JLabel("до:"));
            pricePanel.add(to);

        return pricePanel;
        }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String text = from.getText();
        System.out.println(text);
    }
}
