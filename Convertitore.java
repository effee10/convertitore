package it.edu.iisgubbio.convertitore;

import java.util.Hashtable;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

public class Convertitore extends Application {

	TextField tNum = new TextField();
	TextField tBaseIn = new TextField();
	TextField tBaseOut = new TextField();
	
	Label lRis = new Label("result");
	
	public void start(Stage stage) {

		GridPane grid = new GridPane();

		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10));

		Button pConverti = new Button("converti");
		pConverti.setOnAction(e -> converti());

		grid.add(new Label("Numero da convertire"), 0, 0);
		grid.add(tNum, 0, 1);

		grid.add(new Label("Base in"), 0, 2);
		grid.add(tBaseIn, 0, 3);

		grid.add(new Label("Base out"), 0, 4);
		grid.add(tBaseOut, 0, 5);

		
		grid.add(lRis, 0, 6);
		grid.add(pConverti, 0, 7);

		Scene scene = new Scene(grid);

		stage.setScene(scene);
		stage.setTitle("Convertitore");
		stage.show();
	}

	public void converti() {
		
		String num = tNum.getText();
		
		int baseIn = Integer.parseInt(tBaseIn.getText());
		int baseOut = Integer.parseInt(tBaseOut.getText());
		
        Hashtable<Character, Integer> ht = new Hashtable<>();
        
        for (int i = 0; i < 10; i++) {
            ht.put((char)('0' + i), i);
        }
        for (int i = 10; i < 16; i++) {
            ht.put((char)('A' + i - 10), i);
        }
        
        int numeroDecimale = 0;
        for (int i = 0; i < num.length(); i++) {
            char cifra = num.charAt(i);
            int valoreCifra = ht.get(cifra);
            numeroDecimale = numeroDecimale * baseIn + valoreCifra;
        }
        
        StringBuilder risultato = new StringBuilder();
        while (numeroDecimale > 0) {
            int resto = numeroDecimale % baseOut;
            char cifra = (resto < 10) ? (char)('0' + resto) : (char)('A' + resto - 10);
            risultato.insert(0, cifra);
            numeroDecimale /= baseOut;
        }
        
        lRis.setText(risultato.toString());
    }

	public static void main(String[] args) {
		launch(args);
	}
	

}


