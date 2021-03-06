package sample.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalizadorSintactico {

    Stack pila = new Stack();

    public AnalizadorSintactico(){}

    public boolean ejecutarAnalizador(String cadena) {
        String[] parts = cadena.split(" ");
        pila.push("ACORDE");

        ArrayList<String> separado =separarAletraciones(parts);
        return tablaPredictiva(separado);

    }

    public ArrayList<String> separarAletraciones(String[] parts){
        System.out.println("Separa alteracion: ");
        String alteraciones[] = { "^(RE|SOL|LA)[(#|b)]", "^(MI|SI)[(b|#)]", "^(DO|FA)[(#|b)]" };
        ArrayList<String> parteRefactorizada = new ArrayList<>();
        String[] datos;
        boolean agregado = false;

        for (String palabra:
                parts) {
            System.out.println("palabra> "+palabra);
            for (int i = 0; i < alteraciones.length; i++) {
                //System.out.println("Itera");
                Pattern pat = Pattern.compile( alteraciones[i] );
                Matcher mat = pat.matcher(palabra);
                if (mat.matches()) {
                    System.out.println(">> Entra al march: "+palabra);

                    char[] palabra_caracteres = palabra.toCharArray();
                    int posi = palabra_caracteres.length;
                    String alteracion = String.valueOf(palabra_caracteres[posi-1]);

                    String[] reglasNuevas = palabra.split(alteracion);
                    //String dato = String.valueOf( palabra_caracteres[posi] );

                    System.out.println("******* reglas    : "+reglasNuevas[0]);
                    System.out.println("******* alteracion: "+alteracion);

                    parteRefactorizada.add(reglasNuevas[0]);
                    parteRefactorizada.add( alteracion);
                    agregado=true;

                }else{
                    System.out.println("No tiene alteracion correcta::: "+palabra);
                    System.out.println("i ="+i);
                    System.out.println(agregado);
                    if(i == alteraciones.length - 1 && !agregado){
                        System.out.println("No alteracion for::: "+palabra);
                        System.out.println("Entra SI# --");
                        //parteRefactorizada.add(palabra);
                        agregado=false;
                    }
                }
            }
            System.out.println("Entro match? :"+agregado);
            if(!agregado){
                System.out.println("Agregado false: "+palabra);
                parteRefactorizada.add(palabra);
                agregado=false;
            }
            if(agregado){
                agregado=false;
            }
        }

        System.out.println("  \n\n**********************************************************************************  ");
        for (int i = 0; i < parteRefactorizada.size(); i++) {
            System.out.println("en cadena: "+parteRefactorizada.get(i));
        }
        parteRefactorizada.add("$");
        return parteRefactorizada;
    }


    public boolean tablaPredictiva(ArrayList<String> parts){
        System.out.println("Tabla predictiva");

        String terminales[] = {"RE", "SOL", "LA", "MI", "SI", "DO", "FA", "#", "b", "$"};
        String reglas[] = {"ACORDE", "Notas", "NotaTono", "NotaSemi1", "NotaSemi2", "AlteracionComp", "Alteracion#", "Alteracionb", "Resto"};

        String[][] tabla_matriz = new String[9][10];
        TablaPredictiva tabla = new TablaPredictiva();
        tabla.getTabla(tabla_matriz);

        System.out.println("\n\n\n>>>>>>>>>>>>>>>>>>>>>>> Logica tabla: <<<<<<<<<<<<<<<<<<<<<< ");
        return logica_tabla_pila(tabla_matriz, parts);

    }

    public boolean logica_tabla_pila( String[][] tabla_matriz, ArrayList<String> parts ){
        ArrayList<String> terminales = new ArrayList<>(Arrays.asList("RE", "SOL", "LA", "MI", "SI", "DO", "FA", "#", "b", "$"));
        ArrayList<String> reglas = new ArrayList<>(Arrays.asList("ACORDE","Notas", "NotaTono", "NotaSemi1", "NotaSemi2", "AlteracionComp", "Alteracion#", "Alteracionb", "Resto"));

        System.out.println(">>>>>>>>>>>>>>>>>> cadena para tabla <<<<<<<<<<<<<<<<<<<<<<<<<<<< ");
        int banderaReglasConta = 0;
        int apuntador = 0;
        String cadenaValidando ="";
            do{
                System.out.println("Apunta: "+parts.get(apuntador)+" -> Pila:"+pila);
                try{
                    if(pila.peek().equals(parts.get(apuntador)) ){
                        System.out.println(parts.get(apuntador) + " : " +pila);
                        System.out.println("es terminal");
                        cadenaValidando+= "  "+parts.get(apuntador);
                        apuntador++;
                        pila.pop();
                    }
                    else{

                        int fila = terminales.indexOf(parts.get(apuntador));
                        int columna = reglas.indexOf(pila.peek());

                        String reglaDeMatriz = tabla_matriz[columna][fila];

                        if(reglaDeMatriz==null){
                            System.out.println(">> Error: "+reglaDeMatriz);
                            cadenaValidando+= "  "+parts.get(apuntador);
                            System.out.println(cadenaValidando + "<-");
                            return false;
                        }

                        if(reglaDeMatriz.equals("??") || parts.get(apuntador).equals("$")){
                            pila.pop();
                        }else{
                            pila.pop();
                            String[] reglasNuevas = reglaDeMatriz.split(" ");

                            for (int j = reglasNuevas.length; j > 0; j--) {
                                pila.push(reglasNuevas[j-1]);
                            }
                        }
                    }
                }catch (Exception e){
                    System.out.println("Error en cadena");
                    return false;
                }
            }while (!pila.isEmpty());
        System.out.println("pila vacia? "+pila.isEmpty());
        return true;

    }

}
