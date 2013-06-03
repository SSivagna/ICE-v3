package demo;

import java.net.URL;
import java.util.ResourceBundle;

import demo.security.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ProfileController extends AnchorPane implements Initializable 
{
	@FXML
    Label errorMessage;
	@FXML 
	TableView<User> table;
	@FXML
	VBox vbox;
	
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
	
	
	public void processScan(ActionEvent event)
	{
	/*	if (application == null)
		{
			return;
		}
		else*/
		{
		/*	try
			{
				ProcessBuilder pb = new ProcessBuilder("leaptest.sh");
				final Process process = pb.start();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				PrintWriter pw = new PrintWriter(process.getOutputStream());
				String line;
				
				while ((line = br.readLine()) != null )
				{
					System.out.println(line);
					pw.println("1997");
					pw.flush();
				}
				System.out.println("Program terminated");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
			
			if (application != null)
	        {
				final ObservableList<User> data = FXCollections.observableArrayList(
					    new User("Jacob", "Smith"),
					    new User("Isabella", "Johnson"),
					    new User("Ethan", "Williams"),
					    new User("Emma", "Jones"),
					    new User("Michael", "Brown")
					);
				table.setItems(data);
	        }
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub	
	}
}