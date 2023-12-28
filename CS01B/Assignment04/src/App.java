/**
 * @version 1.0 8-06-2020
 * @author Andrew Li
 * <br>
 * Purpose: App contains the main method, which initializes Message objects and calls the run() method. <br>
 * <br>
 * Revision History: <br>
 * Date: 8-06-2020 <br>
 * Programmer: Andrew Li
 */
public class App
{
    public static void main(String[] args)
    {        
        SmartCarrier sc = new SmartCarrier("San Mateo County"); 
        sc.init();
        sc.run();
    } 
}
