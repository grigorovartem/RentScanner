package Panels;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

public class Price extends JPanel {

    private static JFormattedTextField from;
    private static JFormattedTextField to;

    public Price() {
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setGroupingUsed(false);
        from = new JFormattedTextField(format);
        from.setColumns(5);
        add(new Label("Цена от:"));
        add(from);
        to = new JFormattedTextField(format);
        to.setColumns(5);
        add(new JLabel("до:"));
        add(to);
    }

    public String getFrom() {
        return from.getText();
    }

    public String getTo() {
        return to.getText();
    }
}
