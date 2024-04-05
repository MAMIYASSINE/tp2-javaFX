package javafx.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

public class RegistrationFormController {

    @FXML
    private Button btn;

    @FXML
    private TextField email;

    @FXML
    private TextField fullName;

    @FXML
    private PasswordField password;
    
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
    String ch="Welcome";
    Window owner = btn.getScene().getWindow();
    if(fullName.getText().isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Form Error!");
    alert.setHeaderText(null);
    alert.setContentText("Please enter your name");
    alert.initOwner(owner);
    alert.show();
    //……Vous faites le test pour tous les autres champs>
    //... …………………
    }
    else if(email.getText().isEmpty())
    {
       Alert alert = new Alert(AlertType.ERROR);
       alert.setTitle("Form Error!");
       alert.setHeaderText(null);
       alert.setContentText("Please enter your email ");
       alert.initOwner(owner);
       alert.show();

    }
    else if(password.getText().isEmpty()) {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Form Error!");
        alert.setHeaderText(null);
        alert.setContentText("Please enter your password ");
        alert.initOwner(owner);
        alert.show();
    }
    else 
    {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("registraion form");
        alert.setHeaderText(null);
        alert.setContentText("Welcome "+ fullName.getText());
        alert.initOwner(owner);
        alert.show();


        
    }
    }

}
