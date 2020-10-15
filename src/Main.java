import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

	@SuppressWarnings("deprecation")
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Pane pane = new Pane();
		
		
		Scene scene = new Scene(pane);
		
		windowsFlashNotification(scene, primaryStage);
		windowsTrayNotification();
		windowsSoundNotification();
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Windows Notification");
		primaryStage.show();
		
	}
	
	private void windowsTrayNotification() throws MalformedURLException, AWTException {
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
	}//end of windowsNotification
	
	private void windowsFlashNotification(Scene scene, Stage stage) {
		TimelineBuilder.create().keyFrames(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            	stage.toFront();
            }
        })).cycleCount(Timeline.INDEFINITE).build().play();
	}//end of windowsFlashNotification
	
	private void windowsSoundNotification()
	{
		Media sound = new Media(new File("C:\\Users\\Tyler\\eclipse-workspace\\Windows Notification\\src\\juntos-607.mp3").toURI().toString());
		MediaPlayer mp = new MediaPlayer(sound);
		TimelineBuilder.create().keyFrames(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            	mp.play();
            }
        })).cycleCount(Timeline.INDEFINITE).build().play();
	}
}//end of Main