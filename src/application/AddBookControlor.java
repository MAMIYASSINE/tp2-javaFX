package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AddBookControlor implements Initializable {

	@FXML
	private TableColumn<Person, String> E_tab;

	@FXML
	private TableColumn<Person, String> N_tab;

	@FXML
	private TableColumn<Person, String> P_tab;

	@FXML
	private Button addBtn;

	@FXML
	private TextField email;

	@FXML
	private Button exportBTN;

	@FXML
	private Button importBTN;

	@FXML
	private TextField nom;

	@FXML
	private TextField prenom;

	@FXML
	private Button quitter;

	@FXML
	private Button removeBTN;

	@FXML
	private TableView<Person> tab;

	private DataClass data;

	public static boolean isEmailAdress(String email) {
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
		Matcher m = p.matcher(email.toUpperCase());
		return m.matches();
	}

	@FXML
	void addBtn(ActionEvent event) {

		Window owner = addBtn.getScene().getWindow();
//		if (prenom.getText().isEmpty()) {
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.setTitle("Form Error!");
//			alert.setHeaderText(null);
//			alert.setContentText("Remplir tous les champs !");
//			alert.initOwner(owner);
//			alert.show();
//			
//		} else if (nom.getText().isEmpty()) {
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.setTitle("Form Error!");
//			alert.setHeaderText(null);
//			alert.setContentText("Remplir tous les champs !");
//			alert.initOwner(owner);
//			alert.show();
//			
//		} else if (email.getText().isEmpty()) {
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.setTitle("Form Error!");
//			alert.setHeaderText(null);
//			alert.setContentText("Remplir tous les champs !");
//			alert.initOwner(owner);
//			alert.show();
//		}else if(! AddBookControlor.isEmailAdress(email.getText())) {
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.setTitle("Form Error!");
//			alert.setHeaderText(null);
//			alert.setContentText(email.getText()+": Email incorrect!");
//			alert.initOwner(owner);
//			alert.show();
		if (prenom.getText().isEmpty() || nom.getText().isEmpty() || email.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Form Error!");
			alert.setHeaderText(null);
			alert.setContentText("Remplir tous les champs !");
			alert.initOwner(owner);
			alert.show();
		} else if (!isEmailAdress(email.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Form Error!");
			alert.setHeaderText(null);
			alert.setContentText(email.getText() + ": Email incorrect!");
			alert.initOwner(owner);
			alert.show();
		} else {

			Person p=new Person(prenom.getText(),nom.getText(),email.getText());
			tab.getItems().add(p);
			prenom.clear();
            nom.clear();
            email.clear();
		}

	}

	@FXML
	void exportBTN(ActionEvent event) {
		Window owner = exportBTN.getScene().getWindow();
		data.setExportList(tab.getItems());

	}

	@FXML
	void importBTN(ActionEvent event) {
		
		Window owner = importBTN.getScene().getWindow();
		tab.getItems().addAll(data.getImportList());
		//(data.getImportList());

		
	}

	@FXML
	void quitter(ActionEvent event) {

		 Stage stage = (Stage) quitter.getScene().getWindow();
		   stage.close();
	}

	@FXML
	void remove(ActionEvent event) {

		Window owner = removeBTN.getScene().getWindow();
		Person p = tab.getSelectionModel().getSelectedItem();
		if(p != null) {
			tab.getItems().remove(p);
		}
		

		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		data = new DataClass();
		P_tab.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
	    N_tab.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
	    E_tab.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
	    
		
		//tab.setEditable(true);

	}

}
