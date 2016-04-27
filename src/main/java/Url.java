import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Url extends JPanel {

    private List<JRadioButton> radioButtons = new ArrayList<>();

    public Url(){
        for (final UrlEnum urlEnum : UrlEnum.values()) {
            JRadioButton jRadioButton = new JRadioButton(urlEnum.getDisplayName());
            add(jRadioButton);
            radioButtons.add(jRadioButton);
        }
    }

    public List<JRadioButton> getRadioButtons() {
        return radioButtons;
    }
}
