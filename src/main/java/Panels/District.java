package Panels;

import Enums.DistrictEnum;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class District extends JPanel {
    private static List<JCheckBox> checkboxes = new ArrayList<>();

    public District() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (final DistrictEnum districtEnum : DistrictEnum.values()) {
            JCheckBox jCheckbox = new JCheckBox(districtEnum.getDisplayName());
            jCheckbox.setName(districtEnum.name());
            add(jCheckbox);
            checkboxes.add(jCheckbox);
        }
    }

    public static List<JCheckBox> getCheckboxes() {
        return checkboxes;
    }
}
