/**
 * Sample Skeleton for 'es1.fxml' Controller Class
 */

package es1.gui;

import java.net.URL;
import java.util.ResourceBundle;

import es1Model.Gestione;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class es1Controller {
	
	private Gestione ges;
	
	public void setModel(Gestione ges) {
		this.ges=ges;
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="parola"
    private TextField parola; // Value injected by FXMLLoader

    @FXML // fx:id="add"
    private Button add; // Value injected by FXMLLoader

    @FXML // fx:id="messaggio"
    private TextField messaggio; // Value injected by FXMLLoader

    @FXML // fx:id="numero"
    private TextField numero; // Value injected by FXMLLoader

    @FXML
    void onAdd(ActionEvent event) {
    	int m=ges.addParola(parola.getText());
    	
    	if(m==1) {
    		messaggio.setText("successo");
    	}
    	else if(m==0) {
    		messaggio.setText("gia inserito");
    	}
    	else if(m==-1){
    		messaggio.setText("non va bene");
    	}
    	
    	numero.setText(ges.getN()+"");

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert parola != null : "fx:id=\"parola\" was not injected: check your FXML file 'es1.fxml'.";
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'es1.fxml'.";
        assert messaggio != null : "fx:id=\"messaggio\" was not injected: check your FXML file 'es1.fxml'.";
        assert numero != null : "fx:id=\"numero\" was not injected: check your FXML file 'es1.fxml'.";

    }
}
