package it.edu.iisgubbio.convertitore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Convertitore extends Application {

	TextField tNum = new TextField();
	TextField tBase = new TextField();

	Label lRis = new Label();
	Label lConv = new Label("numero da convertire");
	Label lNum = new Label();
	Label lBase = new Label("base di conv.");

	public void start(Stage stage) {

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		Button pConverti = new Button();
		pConverti.setOnAction(e -> converti());

		griglia.add(lConv, 0, 0);
		griglia.add(tNum, 0, 1);

		griglia.add(tBase, 0, 2);
		griglia.add(lBase, 0, 3);

		griglia.add(lRis, 0, 4);
		griglia.add(pConverti, 0, 5);

		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10));

		stage.setScene(scena);
		stage.setTitle("convertitore");
		stage.show();

	}

	private void converti() {

		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
