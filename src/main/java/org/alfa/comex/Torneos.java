package comex;

import java.util.ArrayList;
import java.util.Arrays;

public class Torneos {
    public static ArrayList<ArrayList<String>> organizarYincana(ArrayList<String> equipos) {
    	
        ArrayList<ArrayList<String>> fullMatch = new ArrayList<>();
        int numEquipos = equipos.size();
        
        if (numEquipos%2 != 0) {
        	equipos.add("X"); // Agregar equipo "Descansa" si el número de equipos es impar
        	numEquipos++;
        }
        
        int numRondas = numEquipos-1;
        int mitadEquipos = numEquipos/2;
        
        for (int n = 0; n < numRondas; n++) {
            ArrayList<String> matches = new ArrayList<>();
            for (int i = 0; i < mitadEquipos; i++) {
                String eq1 = equipos.get(i);
                String eq2 = equipos.get(numEquipos - 1 - i);
                matches.add(eq1 + " vs " + eq2);
            }
            
            fullMatch.add(matches);
            pivotePrimerElementoRotar(equipos);
        }
        
        return fullMatch;
    }

    private static void pivotePrimerElementoRotar(ArrayList<String> subEquipos) {
    	   String temp = subEquipos.remove(subEquipos.size() - 1);
    	   subEquipos.add(1, temp);
    }

    public static void main(String[] args) {
    	
        ArrayList<String> equiposA = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<ArrayList<String>> evento = organizarYincana(equiposA);
        System.out.println("\nMapa de grupos:\n");
        
        for (ArrayList<String> e : evento) {
            System.out.println(e);
        }

        ArrayList<String> equiposB = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        ArrayList<ArrayList<String>> evento2 = organizarYincana(equiposB);
        System.out.println("\nMapa de grupos:\n");
        for (ArrayList<String> e : evento2) {
            System.out.println(e);
        }
        
        ArrayList<String> equiposC = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        ArrayList<ArrayList<String>> evento3 = organizarYincana(equiposC);
        System.out.println("\nMapa de grupos:\n");
        for (ArrayList<String> e : evento3) {
            System.out.println(e);
        }
    }
}
