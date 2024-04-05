module tp2_fx_sc {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
    exports javafx.example;

	opens application to javafx.graphics, javafx.fxml;
	opens javafx.example to javafx.graphics, javafx.fxml;
}
