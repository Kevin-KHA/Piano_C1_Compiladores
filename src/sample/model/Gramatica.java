package sample.model;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gramatica {

    public Gramatica() {
    }

    public String[] separarCadena(String cadena) {

        System.out.println("Gramatica: " + cadena);
        String mensaje = "";

        // String notas[] = {"RE", "SOL", "LA", "MI", "SI", "DO", "FA", "vacio","#", "b"};
        TreeSet<String> alteracion = new TreeSet<String>();
        alteracion.add("#");
        alteracion.add("b");

        String[] parts = cadena.split(" ");

        //String expresion[] = { "^(RE|SOL|LA)(#|b)?" , "^(MI|SI)(b)?", "^(DO|FA)(#)?", "^(#|b){1,1}?" };
        String expresion[] = { "^(RE|SOL|LA)" , "^(MI|SI)", "^(DO|FA)", "^(RE|SOL|LA)(#|b)?", "^(MI|SI)(b)?", "^(DO|FA)(#)?" };
        String tipos[] = {"Nota tono", "Nota semi 1", "Nota semi 2", "Nota tono con AlteracionComp", "Nota semi 1 con Alteracionb", "Nota semi 2 con Alteracion#"};

        boolean cadenaCorrecta = true;
        for (String palabra:
             parts) {
            //System.out.println(palabra);
            //if(!notas_treeset.contains(palabra)) System.out.println("error en "+palabra);
            boolean existe = false;
            int posicion_tipo = 0;
            for (int i = 0; i < expresion.length; i++) {
                Pattern pat = Pattern.compile( expresion[i] );
                Matcher mat = pat.matcher(palabra);
                if (mat.matches()) {
                    existe=true;
                    posicion_tipo=i;
                    break;
                }

            }
            if(existe){

                String msj = "palabra: ["+palabra+ "] tipos: "+tipos[posicion_tipo]+"\n";
                System.out.println(msj);
                mensaje+= msj;
            }
            else
                if ( palabra.length() > 0 ){
                    String msj = "palabra: ["+palabra+ "] No existe \n";
                    //cadenaCorrecta = false;
                    System.out.println(msj);
                    mensaje+= msj;
                }


        }
        String[] msj = {mensaje, String.valueOf(cadenaCorrecta)};
        return msj;

    }

}

