package sample.controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.model.AnalizadorSintactico;
import sample.model.Gramatica;
import sample.model.Piano;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller extends Thread implements Initializable {

    //CAJAS DE TEXTO
    @FXML private TextField txtN1;
    @FXML private TextArea txtarea;

    //imagenes
    @FXML private ImageView Do;
    @FXML private ImageView Re;
    @FXML private ImageView Mi;
    @FXML private ImageView Fa;
    @FXML private ImageView Sol;
    @FXML private ImageView La;
    @FXML private ImageView Si;
    @FXML private ImageView Do_Re;
    @FXML private ImageView Re_Mi;
    @FXML private ImageView Fa_Sol;
    @FXML private ImageView Sol_La;
    @FXML private ImageView La_Si;




    //---------------METODOS NO LÓGICOS PARA LA INTERFAZ--------------------------------------------------
    //validamos los campos que por lo menos uno tenga algo, con cadena mayor a dos pero menor igual a tres
    public void validarCampos() {
        if (txtN1.getText().isEmpty()){
            mensaje = "Debes escribir al menos una nota";
            mostrarAlerts(mensaje, Alert.AlertType.WARNING);
        }
        else{
            System.out.println("todo bn");
            if (txtN1.getText().length() >=1){
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

        String notasComp = txtN1.getText();
        System.out.println(notasComp);
        AnalizadorSintactico sintactico = new AnalizadorSintactico();
        Gramatica gramatica = new Gramatica();
        String[] msj = gramatica.separarCadena(notasComp);
        txtarea.setText(msj[0]);

        if(msj[1]=="true"){
            //mostrarAlerts("Cadena correcta true", Alert.AlertType.INFORMATION);
            boolean analizado = sintactico.ejecutarAnalizador(notasComp);
            if(!analizado){
                //mostrarAlerts("Error sintactico", Alert.AlertType.ERROR);
                mostrarAlerts("Error sintactico", Alert.AlertType.ERROR);
            }else {
                //mostrarAlerts("Interpretando...", Alert.AlertType.INFORMATION);
                //LAMAR DESDE AQUI
                interpretarNotas(notasComp);
            }

        }else {
            //mostrarAlerts("Error gramatica", Alert.AlertType.ERROR);
            mostrarAlerts("Error lexico", Alert.AlertType.ERROR);
        }



    }
    //NOTAS NATURALES (BLANCAS)
    private final Piano DO = new Piano("src/sample/wav/DO.wav");
    private final Piano RE = new Piano("src/sample/wav/RE.wav");
    private final Piano MI = new Piano("src/sample/wav/MI.wav");
    private final Piano FA = new Piano("src/sample/wav/FA.wav");
    private final Piano SOL = new Piano("src/sample/wav/SOL.wav");
    private final Piano LA = new Piano("src/sample/wav/LA.wav");
    private final Piano SI = new Piano("src/sample/wav/SI.wav");

    //SEMITONOS (NEGRAS)
    private final Piano SEMITONO_DO_RE = new Piano("src/sample/wav/DO#_REb.wav");
    private final Piano SEMITONO_RE_MI = new Piano("src/sample/wav/RE#_MIb.wav");
    private final Piano SEMITONO_FA_SOL = new Piano("src/sample/wav/FA#_SOLb.wav");
    private final Piano SEMITONO_SOL_LA = new Piano("src/sample/wav/SOL#_LAb.wav");
    private final Piano SEMITONO_LA_SI = new Piano("src/sample/wav/LA#_SIb.wav");


    @FXML private Label lbl1;
    public void interpretarNotas(String notas){
        System.out.println("metodo de interpretar notas");
        String[] conjuntoNotas = notas.split(" ");
        for (int i = 0; i < conjuntoNotas.length; i++) {
            try{
                if(conjuntoNotas[i].equals("DO")){
                    Do.setVisible(true);
                    DO.play();
                    Thread.sleep(1600);
                }
                else if(conjuntoNotas[i].equals("DO#") || conjuntoNotas[i].equals("REb")){
                    Do_Re.setVisible(true);
                    SEMITONO_DO_RE.play();
                    Thread.sleep(1600);
                }
                else if(conjuntoNotas[i].equals("RE")){
                    Re.setVisible(true);
                    RE.play();
                    Thread.sleep(1600);
                }
                else if(conjuntoNotas[i].equals("RE#")|| conjuntoNotas[i].equals("MIb")){
                    Re_Mi.setVisible(true);
                    SEMITONO_RE_MI.play();
                    Thread.sleep(1600);
                }

                else if(conjuntoNotas[i].equals("MI")){
                    Mi.setVisible(true);
                    MI.play();
                    Thread.sleep(1600);
                }

                else if(conjuntoNotas[i].equals("FA")){
                    Fa.setVisible(true);
                    FA.play();
                    Thread.sleep(1600);
                }
                else if(conjuntoNotas[i].equals("FA#") || conjuntoNotas[i].equals("SOLb")){
                    Fa_Sol.setVisible(true);
                    SEMITONO_FA_SOL.play();
                    Thread.sleep(1600);
                }
                else if(conjuntoNotas[i].equals("SOL")){
                    Sol.setVisible(true);
                    SOL.play();
                    Thread.sleep(1600);
                }
                else if(conjuntoNotas[i].equals("SOL#") || conjuntoNotas[i].equals("LAb")){
                    Sol_La.setVisible(true);
                    SEMITONO_SOL_LA.play();
                    Thread.sleep(1600);
                }
                else if(conjuntoNotas[i].equals("LA")){
                    La.setVisible(true);
                    LA.play();
                    Thread.sleep(1600);
                }
                else if(conjuntoNotas[i].equals("LA#") || conjuntoNotas[i].equals("SIb")){
                    La_Si.setVisible(true);
                    SEMITONO_LA_SI.play();
                    Thread.sleep(1600);
                }
                else if(conjuntoNotas[i].equals("SI")){
                    Si.setVisible(true);
                    SI.play();
                    Thread.sleep(1600);
                }
            }
            catch(Exception e) {
                System.out.println(e);
            }

        }
    }

    public void reset(){
        txtarea.setText("");
        txtN1.setText("");
        Do.setVisible(false);
        Do_Re.setVisible(false);
        Re.setVisible(false);
        Re_Mi.setVisible(false);
        Mi.setVisible(false);
        Fa.setVisible(false);
        Fa_Sol.setVisible(false);
        Sol.setVisible(false);
        Sol_La.setVisible(false);
        La.setVisible(false);
        La_Si.setVisible(false);
        Si.setVisible(false);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}