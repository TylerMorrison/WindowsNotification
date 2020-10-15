import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws AWTException, MalformedURLException {
        if (SystemTray.isSupported()) 
        {
        	//Obtain only one instance of the SystemTray object
            SystemTray tray = SystemTray.getSystemTray();

            //Icon for the tray item
            Image image = Toolkit.getDefaultToolkit().createImage(new URL("https://media-exp1.licdn.com/dms/image/C560BAQH8mLo7H_WXuQ/company-logo_200_200/0?e=2159024400&v=beta&t=XzWwTpZ1F1HZ_OOj_xKkBDX9pcDvsdqOkRFU3E_C7J8"));


            TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
            
            //Let the system resize the image if needed
            trayIcon.setImageAutoSize(true);
            
            //Tooltip for the tray icon
            trayIcon.setToolTip("Visual notification demo");
            tray.add(trayIcon);

            trayIcon.displayMessage("CS 4630", "visual notification", MessageType.INFO);
        } else {
            System.err.println("System tray not supported!");
        }
    }
}