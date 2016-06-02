package Panels;

import Enums.DistrictEnum;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class District extends JPanel {
    private List<JCheckBox> checkboxes = new ArrayList<>();

    public District() {
        setLayout(new GridLayout(4, 3));

        for (final DistrictEnum districtEnum : DistrictEnum.values()) {
            JCheckBox jCheckbox = new JCheckBox(districtEnum.getDisplayName());
            jCheckbox.setName(districtEnum.name());
            add(jCheckbox);
            checkboxes.add(jCheckbox);
        }
    }

    public List<JCheckBox> getCheckboxes() {
        return checkboxes;
    }
}
