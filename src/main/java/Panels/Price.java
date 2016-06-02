package Panels;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

public class Price extends JPanel {

    private JFormattedTextField from;
    private JFormattedTextField to;

    public Price() {
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setGroupingUsed(false);

        from = new JFormattedTextField(format);
        from.setColumns(5);

        to = new JFormattedTextField(format);
        to.setColumns(5);

        add(new Label("Цена от:"));
        add(from);
        add(new JLabel("до:"));
        add(to);
    }

    public int getFrom() {
        return Integer.parseInt(from.getText());
    }

    public int getTo() {
        return Integer.parseInt(to.getText());
    }
}
