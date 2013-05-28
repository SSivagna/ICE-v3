package demo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ProfileController extends AnchorPane implements Initializable 
{
    @FXML
    private Hyperlink logout;

    @FXML 
    private Label success;
    
    private Main application;
    
    public void setApp(Main application)
    {
        this.application = application;
    }
	
	public void processLogout(ActionEvent event) 
	{
        if (application == null)
        {
            return;
        }    
        application.userLogout();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub	
	}
}