package Panels;

import Main.SettingsMapDB;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class Price extends JPanel {

    private JFormattedTextField from;
    private JFormattedTextField to;

    public Price() {
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setGroupingUsed(false);

        from = new JFormattedTextField(format);
        from.setColumns(5);
        from.setText(String.valueOf(SettingsMapDB.getInstance().get("RENTPROPERTIES").getFilter().getPriceFrom()));

        to = new JFormattedTextField(format);
        to.setColumns(5);
        to.setText(String.valueOf(SettingsMapDB.getInstance().get("RENTPROPERTIES").getFilter().getPriceTo()));

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
