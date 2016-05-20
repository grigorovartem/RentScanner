package Panels;

import Enums.UrlEnum;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Url extends JPanel {

    private List<JRadioButton> radioButtons = new ArrayList<>();

    public Url(){
        for (final UrlEnum urlEnum : UrlEnum.values()) {
            JRadioButton jRadioButton = new JRadioButton(urlEnum.getDisplayName());
            jRadioButton.setName(urlEnum.name());
            add(jRadioButton);
            radioButtons.add(jRadioButton);
        }
    }

    public List<JRadioButton> getRadioButtons() {
        return radioButtons;
    }
}
