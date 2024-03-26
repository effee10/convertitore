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

	TextField tNumero = new TextField();
	TextField tBaseIn = new TextField();
	TextField tBaseOut = new TextField();
	
	Label lRis = new Label("result");
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();

		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10));

		Button pConverti = new Button("converti");
		pConverti.setOnAction(e -> converti());

		griglia.add(new Label("Numero da convertire"), 0, 0);
		griglia.add(tNumero, 0, 1);
		griglia.add(new Label("Base in"), 0, 2);
		griglia.add(tBaseIn, 0, 3);
		griglia.add(new Label("Base out"), 0, 4);
		griglia.add(tBaseOut, 0, 5);
		griglia.add(lRis, 0, 6);
		griglia.add(pConverti, 0, 7);

		Scene scene = new Scene(griglia);

		finestra.setScene(scene);
		finestra.setTitle("Convertitore");
		finestra.show();
	}

	public void converti() {
		
		String num = tNumero.getText();
		
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
	
// 777 su ogni cosa

}


