package sample.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import sample.model.AnalizadorSintactico;
import sample.model.Gramatica;


public class Controller {

    //CAJAS DE TEXTO
    @FXML private TextField txtN1;
    @FXML private TextField txtN2;
    @FXML private TextField txtN3;
    @FXML private TextField txtN4;
    @FXML private TextArea txtarea;

    //imagenes
    @FXML private ImageView img1;
    @FXML private ImageView imgPiano;
//ffmpeg











    //---------------METODOS NO LÓGICOS PARA LA INTERFAZ--------------------------------------------------
    //validamos los campos que por lo menos uno tenga algo, con cadena mayor a dos pero menor igual a tres
    public void validarCampos() {
        if (txtN1.getText().isEmpty() && txtN2.getText().isEmpty() && txtN3.getText().isEmpty() && txtN4.getText().isEmpty()){
            mensaje = "Debes escribir al menos una nota";
            mostrarAlerts(mensaje, Alert.AlertType.WARNING);
        }
        else{
            System.out.println("todo bn");
            if (txtN1.getText().length() >=2  || txtN2.getText().length() >=2 || txtN3.getText().length() >=2  || txtN4.getText().length()>=2 ){
                System.out.println("paso filtro de longitud");
                obtenerNotas();
            }
            else {
                mensaje = "Alguna nota no tiene la longitud correcta :(";
                mostrarAlerts(mensaje, Alert.AlertType.ERROR);
            }
        }
    }
    //guardamos las notas obtenidas
    public void obtenerNotas(){
        //String notasComp = txtN1.getText() + txtN2.getText() + txtN3.getText() +txtN4.getText();
        String notasComp = txtN1.getText() +" "+ txtN2.getText() +" "+ txtN3.getText() + " "+ txtN4.getText();
        System.out.println(notasComp);
        AnalizadorSintactico sintactico = new AnalizadorSintactico();

        Gramatica gramatica = new Gramatica();
        String[] msj = gramatica.separarCadena(notasComp);
        txtarea.setText(msj[0]);

        if(msj[1]=="true"){
            //mostrarAlerts("Cadena correcta", Alert.AlertType.INFORMATION);

        }else {
            mostrarAlerts("Error gramatica", Alert.AlertType.ERROR);
        }

        boolean analizado = sintactico.ejecutarAnalizador(notasComp);
        if(!analizado){
            mostrarAlerts("Error sintactico", Alert.AlertType.ERROR);
        }else {
            mostrarAlerts("Cadena correcta", Alert.AlertType.INFORMATION);
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

    //Metodo para el boton de salir
    public void salir(){
        System. exit(1);
    }
}