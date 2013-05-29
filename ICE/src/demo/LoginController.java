package demo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

public class LoginController extends AnchorPane implements Initializable 
{
    @FXML
    PasswordField password;
    @FXML
    Button login;
    @FXML
    Label errorMessage;
    @FXML
    Button logout;
    
    private Main application;   
    
    public void setApp(Main application)
    {
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        errorMessage.setText("");
        password.setPromptText("demo");
    }
    
    public void processLogin(ActionEvent event) 
    {
        if (application == null)
        {
            errorMessage.setText("Hello " + password.getText());
        } else
        {
            if (!application.userLogging(password.getText()))
            {
                errorMessage.setText("Password is incorrect");
                password.clear();
            }
        }
    }
    
    public void processLogout(ActionEvent event) 
    {
    	Platform.exit();
    }
}