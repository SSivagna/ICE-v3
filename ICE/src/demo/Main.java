package demo;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import demo.security.Authenticator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application
{
	private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 200.0;
    private final double MINIMUM_WINDOW_HEIGHT = 250.0;
    
	public static void main(String[] args)
	{
		Application.launch(Main.class, (java.lang.String[])null);
	}
	
	public void start(Stage primaryStage)
	{
        try
        {
            stage = primaryStage;
            stage.setTitle("Intelligence Computer Espionnage");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            gotoConnexion();
            primaryStage.show();
        } catch (Exception ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public boolean userLogging(String password)
	{
        if (Authenticator.validate(password)) 
        {
            gotoMainPage();
        	return true;
        } else {
            return false;
        }
    }

	public void userLogout()
	{
        gotoConnexion();
    }
	
	private void gotoConnexion()
	{
        try
        {
            LoginController login = (LoginController) replaceSceneContent("Connexion.fxml");
            login.setApp(this);
        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	private void gotoMainPage()
	{
		try 
        {
		    ProfileController profile = (ProfileController) replaceSceneContent("MainPage.fxml");   
			profile.setApp(this);
        } catch (Exception ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	private Initializable replaceSceneContent(String fxml) throws Exception
	{
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally 
        {
            in.close();
        }
        Scene scene = new Scene(page, 600, 500);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
}