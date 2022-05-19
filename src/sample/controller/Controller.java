package sample.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class Controller {

    //CAJAS DE TEXTO
    @FXML private TextField txtN1;
    @FXML private TextField txtN2;
    @FXML private TextField txtN3;
    @FXML private TextField txtN4;
    //imagenes
    @FXML private ImageView img1;
    @FXML private ImageView imgPiano;




    //validamos los campos que por lo menos uno tenga algo, con cadena mayor a dos pero menor igual a tres
    public void validarCampos() {
        if (txtN1.getText().isEmpty() && txtN2.getText().isEmpty() && txtN3.getText().isEmpty() && txtN4.getText().isEmpty()){
            mensaje = "Debes escribir al menos un acorde";
            mostrarAlerts(mensaje, Alert.AlertType.WARNING);
        }
        else{
            System.out.println("todo bn");
            if (txtN1.getText().length() >=2  || txtN2.getText().length() >=2 || txtN3.getText().length() >=2  || txtN4.getText().length()>=2 ){
                System.out.println("paso filtro de longitud");
            }
            else {
                mensaje = "Alguna nota no tiene la longitud correcta :(";
                mostrarAlerts(mensaje, Alert.AlertType.ERROR);
            }
        }
    }

    //variable global para mensajes
    String mensaje="";
    //ventana para errores, advertencias e info
    public void mostrarAlerts(String mensaje, Alert.AlertType tipo){
        Alert advertencia = new Alert(tipo);
        advertencia.setHeaderText(mensaje);
        advertencia.show();
    }
}