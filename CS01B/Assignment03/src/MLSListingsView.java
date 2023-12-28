import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @version 1.0 7-28-2020
 * @author Andrew Li
 * <br>
 * Purpose: MLSListingsView class is derived from JFrame. The constructor creates a JFrame with all of the necessary buttons 
 * needed to control the output to the JTextArea in the center, including all of the listeners. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-28-2020 <br>
 * Programmer: Andrew Li
 */
public class MLSListingsView extends JFrame
{
    private static final int viewWidth = 720;
    private static final int viewHeight = 450;

    private PropertyList propertyList;

    private JComboBox<Object> comboProperty;
    private JLabel labelSearch;
    private JButton buttonGo, buttonShow, buttonCondo, buttonSFH, buttonClear;
    private JTextArea textDisplay;
    private JPanel panelSouth, panelNorth;
    private JScrollPane scrollPanel;

    String labels = String.format("%-55s%-16s%-15s%s\n", "Address", "Offered Price", "Year Built", "Extra Info");
    
    public MLSListingsView()
    {
        // create new JFrame
        setTitle("MLS Listings");
        setSize(viewWidth, viewHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] comboArray =
        { "Under 400K", "400K - 600K", "600K - 800K", "800K - 1M", "1M or more" };

        // instantiate UI components
        buttonGo = new JButton("Go");
        buttonShow = new JButton("Show All");
        buttonCondo = new JButton("Show Condo");
        buttonSFH = new JButton("Show SFH");
        buttonClear = new JButton("Clear");
        comboProperty = new JComboBox<Object>(comboArray);
        labelSearch = new JLabel("Search Property:");
        textDisplay = new JTextArea();
        panelSouth = new JPanel();
        panelNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // add UI components to frame
        // center
        textDisplay.setFont(new Font("monospaced", Font.PLAIN, 12));
        textDisplay.setText("Select one of the display options to view the property list categories.");
        textDisplay.setEditable(false);
        scrollPanel = new JScrollPane(textDisplay);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPanel);

        // south
        panelSouth.add(buttonShow);
        panelSouth.add(buttonSFH);
        panelSouth.add(buttonCondo);
        panelSouth.add(buttonClear);
        add(BorderLayout.SOUTH, panelSouth);

        // north
        panelNorth.add(labelSearch);
        panelNorth.add(comboProperty);
        panelNorth.add(buttonGo);
        add(BorderLayout.NORTH, panelNorth);

        // add listeners to UI components
        buttonShow.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                textDisplay.setText(labels);
                textDisplay.append(propertyList.getAllProperties());
            }
        });

        buttonSFH.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                textDisplay.setText(labels);
                textDisplay.append(propertyList.getSingleFamilyHouse());
            }
        });

        buttonCondo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                textDisplay.setText(labels);
                textDisplay.append(propertyList.getCondo());
            }
        });

        buttonClear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                textDisplay.selectAll();
                textDisplay.replaceSelection("");
            }
        });

        buttonGo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                textDisplay.setText(labels);
                switch(comboProperty.getSelectedIndex())
                {
                case 0: 
                    textDisplay.append(propertyList.searchByPriceRange(0, 400000));
                    break;
                case 1: 
                    textDisplay.append(propertyList.searchByPriceRange(400000, 600000));
                    break;
                case 2: 
                    textDisplay.append(propertyList.searchByPriceRange(600000, 800000));
                    break;
                case 3: 
                    textDisplay.append(propertyList.searchByPriceRange(800000, 1000000));
                    break;
                case 4:
                    textDisplay.append(propertyList.searchByPriceRange(1000000, Integer.MAX_VALUE));
                    break;
                }
            }
        });
    }

    public void setProperties(PropertyList propertyList)
    {
        this.propertyList = propertyList;
    }
}
