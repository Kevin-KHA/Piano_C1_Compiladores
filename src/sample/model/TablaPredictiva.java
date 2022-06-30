package sample.model;

import java.lang.reflect.Array;
import java.util.HashMap;

public class TablaPredictiva {

    public TablaPredictiva(){}

    public void getTabla(String[][] tabla_matriz){
        System.out.println("Tabla predictiva");
        crearTabla(tabla_matriz);
    }

    public void crearTabla(String[][] tabla_matriz){

        System.out.println("\nCreando tabla____________");
        tabla_matriz[0][0] = "Notas Resto";
        tabla_matriz[0][1] = "Notas Resto";
        tabla_matriz[0][2] = "Notas Resto";
        tabla_matriz[0][3] = "Notas Resto";
        tabla_matriz[0][4] = "Notas Resto";
        tabla_matriz[0][5] = "Notas Resto";
        tabla_matriz[0][6] = "Notas Resto";

        tabla_matriz[1][0] = "NotaTono AlteracionComp";
        tabla_matriz[1][1] = "NotaTono AlteracionComp";
        tabla_matriz[1][2] = "NotaTono AlteracionComp";
        tabla_matriz[1][3] = "NotaSemi1 Alteracionb";
        tabla_matriz[1][4] = "NotaSemi1 Alteracionb";
        tabla_matriz[1][5] = "NotaSemi2 Alteracion#";
        tabla_matriz[1][6] = "NotaSemi2 Alteracion#";

        tabla_matriz[2][0] = "RE";
        tabla_matriz[2][1] = "SOL";
        tabla_matriz[2][2] = "LA";

        tabla_matriz[3][3] = "MI";
        tabla_matriz[3][4] = "SI";

        tabla_matriz[4][5] = "DO";
        tabla_matriz[4][6] = "FA";

        tabla_matriz[5][0] = "ε";
        tabla_matriz[5][1] = "ε";
        tabla_matriz[5][2] = "ε";
        tabla_matriz[5][3] = "ε";
        tabla_matriz[5][4] = "ε";
        tabla_matriz[5][5] = "ε";
        tabla_matriz[5][6] = "ε";
        tabla_matriz[5][7] = "#";
        tabla_matriz[5][8] = "b";
        tabla_matriz[5][9] = "ε";

        tabla_matriz[6][0] = "ε";
        tabla_matriz[6][1] = "ε";
        tabla_matriz[6][2] = "ε";
        tabla_matriz[6][3] = "ε";
        tabla_matriz[6][4] = "ε";
        tabla_matriz[6][5] = "ε";
        tabla_matriz[6][6] = "ε";
        tabla_matriz[6][7] = "#";
        tabla_matriz[6][9] = "ε";

        tabla_matriz[7][0] = "ε";
        tabla_matriz[7][1] = "ε";
        tabla_matriz[7][2] = "ε";
        tabla_matriz[7][3] = "ε";
        tabla_matriz[7][4] = "ε";
        tabla_matriz[7][5] = "ε";
        tabla_matriz[7][6] = "ε";
        tabla_matriz[7][8] = "b";
        tabla_matriz[7][9] = "ε";

        tabla_matriz[8][0] = "Notas Resto";
        tabla_matriz[8][1] = "Notas Resto";
        tabla_matriz[8][2] = "Notas Resto";
        tabla_matriz[8][3] = "Notas Resto";
        tabla_matriz[8][4] = "Notas Resto";
        tabla_matriz[8][5] = "Notas Resto";
        tabla_matriz[8][6] = "Notas Resto";
        tabla_matriz[8][9] = "ε";

    }
}
