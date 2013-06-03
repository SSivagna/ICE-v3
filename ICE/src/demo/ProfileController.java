package demo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import demo.security.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ProfileController extends AnchorPane implements Initializable 
{
	@FXML
    Label errorMessage;
	@FXML 
	TableView<User> table;
	@FXML
	TableColumn<User, String> ColName;
	@FXML
	TableColumn<User, String> ColIP;
	@FXML
    private Button Scanner;
	
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
			
		/*	if (application != null)
	        {
				final ObservableList<User> data = FXCollections.observableArrayList(
					    new User("Jacob", "Smith"),
					    new User("Isabella", "Johnson"),
					    new User("Ethan", "Williams"),
					    new User("Emma", "Jones"),
					    new User("Michael", "Brown")
					);
				table.setItems(data);
				table.autosize();
			}*/
			if (application != null)
	        {
                User a = new User("Sinthuja", "Siva");
                User b = new User("Sylvia", "Sivagna");
		
                List<User> liste = new ArrayList<User>();
                liste.add(a);
                liste.add(b);
		
                ColName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
                ColIP.setCellValueFactory(new PropertyValueFactory<User, String>("IP"));
		
                table.getItems().setAll(liste);
	        }
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub
	}
}