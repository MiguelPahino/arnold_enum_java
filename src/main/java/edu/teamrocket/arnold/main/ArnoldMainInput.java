package edu.teamrocket.arnold.main;

import java.util.Scanner;

import edu.teamrocket.arnold.logica.Planeta;

public class ArnoldMainInput {
	
	public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce tu peso (Por defecto 60.0): ");
        String pesoInput = scanner.nextLine(); 
        double peso;
        try {
            peso = Double.parseDouble(pesoInput);
        } catch (NumberFormatException e) {
            peso = 60.0;
        }

        
        System.out.println("Introduce un planeta:");
        String inputPlaneta = scanner.nextLine().toUpperCase(); 
        Planeta planeta; 

        
        
        try {
            planeta = Planeta.valueOf(inputPlaneta);
        }
        catch (IllegalArgumentException e) { 
            planeta = Planeta.EARTH;
            System.out.println("Planeta no valido, se usará por defecto la Tierra");
        }

        System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
    
        scanner.close();
    }

}