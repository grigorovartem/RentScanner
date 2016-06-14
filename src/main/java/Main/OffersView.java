package Main;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static java.awt.BorderLayout.*;

public final class OffersView extends JPanel implements ActionListener{

    private static OffersView _instance = null;
    private Map<Offer, JCheckBox> offerMap = new HashMap<>();

    private JButton openButton;
    private GridBagConstraints constraintsPrice;
    private GridBagConstraints constraintsDescription;
    private GridBagConstraints constraintsOpen;
    private GridBagConstraints constraintsButton;
    private GridBagLayout bagLayout;

    private OffersView(){

        bagLayout = new GridBagLayout();
        setLayout(bagLayout);
        constraintsPrice = new GridBagConstraints();
        constraintsDescription = new GridBagConstraints();
        constraintsOpen = new GridBagConstraints();
        constraintsButton = new GridBagConstraints();

        constraintsPrice.anchor = GridBagConstraints.NORTH;
        constraintsPrice.fill   = GridBagConstraints.NONE;
        constraintsPrice.gridheight = 1;
        constraintsPrice.gridwidth  = 1;
        constraintsPrice.gridx = 0;
        constraintsPrice.gridy = GridBagConstraints.RELATIVE;
        constraintsPrice.insets = new Insets(10, 10, 10, 10);
        constraintsPrice.ipadx = 0;
        constraintsPrice.ipady = 0;
        constraintsPrice.weightx = 0.25;
        constraintsPrice.weighty = 0.0;

        constraintsDescription.anchor = GridBagConstraints.NORTH;
        constraintsDescription.fill   = GridBagConstraints.HORIZONTAL;
        constraintsDescription.gridheight = 1;
        constraintsDescription.gridwidth  = 1;
        constraintsDescription.gridx = 1;
        constraintsDescription.gridy = GridBagConstraints.RELATIVE;
        constraintsDescription.insets = new Insets(10, 10, 10, 10);
        constraintsDescription.ipadx = 0;
        constraintsDescription.ipady = 0;
        constraintsDescription.weightx = 0.5;
        constraintsDescription.weighty = 0.0;

        constraintsOpen.anchor = GridBagConstraints.NORTH;
        constraintsOpen.fill   = GridBagConstraints.NONE;
        constraintsOpen.gridheight = 1;;
        constraintsOpen.gridwidth  = 1;
        constraintsOpen.gridx = 2;
        constraintsOpen.gridy = GridBagConstraints.RELATIVE;
        constraintsOpen.insets = new Insets(10, 10, 10, 10);
        constraintsOpen.ipadx = 0;
        constraintsOpen.ipady = 0;
        constraintsOpen.weightx = 0.25;
        constraintsOpen.weighty = 0.0;

        constraintsButton.anchor = GridBagConstraints.PAGE_END;
        constraintsButton.fill   = GridBagConstraints.HORIZONTAL;
        constraintsButton.gridheight = 1;;
        constraintsButton.gridwidth  = 3;
        constraintsButton.gridx = 0;
        constraintsButton.gridy = GridBagConstraints.PAGE_END;
        constraintsButton.insets = new Insets(10, 10, 10, 10);
        constraintsButton.ipadx = 0;
        constraintsButton.ipady = 0;
        constraintsButton.weightx = 1.0;
        constraintsButton.weighty = 0.0;

        openButton = new JButton("Открыть в браузере");
        openButton.addActionListener(this);
        bagLayout.setConstraints(openButton, constraintsButton);
        add(openButton);

    }

    public static synchronized OffersView getInstance() {
        if (_instance == null)
            _instance = new OffersView();
        return _instance;
    }

    public void addOffersView(Offer offer){

        OffersView offersView = OffersView.getInstance();
        JLabel newOfferPrice = new JLabel("<html>"+offer.getPrice()+"</html>");
        JTextArea newOfferDescription = new JTextArea(offer.getDescription());//("<html>"+offer.getDescription()+"</html>");
        newOfferDescription.setLineWrap(true);
        JCheckBox openCheckBox = new JCheckBox();
        offersView.offerMap.put(offer, openCheckBox);

            offersView.bagLayout.setConstraints(newOfferPrice, constraintsPrice);
            offersView.bagLayout.setConstraints(newOfferDescription, constraintsDescription);
            offersView.bagLayout.setConstraints(openCheckBox, constraintsOpen);
            offersView.add(newOfferPrice);
            offersView.add(newOfferDescription);
            offersView.add(openCheckBox);
            offersView.revalidate();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Map.Entry entry : offerMap.entrySet()){
            JCheckBox openCheckBox = (JCheckBox) entry.getValue();
            if(openCheckBox.isSelected()){
                Desktop d = Desktop.getDesktop();
                Offer offer = (Offer) entry.getKey();
                try {
                    d.browse(new URI(offer.getLink()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
