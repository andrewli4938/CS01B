import java.awt.EventQueue;

/**
 * @version 1.0 7-28-2020
 * @author Andrew Li
 * <br>
 * Purpose: MLSListingsApp contains the main method, which creates a Linked List of Property objects, and proceeds to
 * display them on the JTextArea on the JFrame. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-28-2020 <br>
 * Programmer: Andrew Li
 */
public class MLSListingsApp
{
    public static void main(String[] args)
    {
        PropertyList propertyList = new PropertyList();
        propertyList.initialize();
        
        EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                MLSListingsView frame = new MLSListingsView(); 
                frame.setProperties(propertyList);
                frame.setVisible(true);
            }
        });
    }
}
