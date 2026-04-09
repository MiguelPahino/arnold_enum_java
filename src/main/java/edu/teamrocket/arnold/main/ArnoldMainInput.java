package edu.teamrocket.arnold.main;

import java.util.Optional;
import java.util.Scanner;

import edu.teamrocket.arnold.logica.Planeta;

public class ArnoldMainInput {
	
	public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce tu peso: ");
        String pesoInput = scanner.nextLine(); 
        Optional<Double> peso = Optional.empty();
        
        try {
            peso = Optional.of(Double.parseDouble(pesoInput));
        } catch (NumberFormatException e) {
            peso = Optional.of(60.0);
            System.out.println("Peso no valido, se usará por defecto 60.0");
        }

        
        System.out.println("Introduce un planeta:");
        String inputPlaneta = scanner.nextLine().toUpperCase(); 
        Optional<Planeta> planeta = Optional.empty(); 

        
        
        try {
            planeta = Optional.of(Planeta.valueOf(inputPlaneta));
        }
        catch (IllegalArgumentException e) { 
            planeta = Optional.of(Planeta.EARTH);
            System.out.println("Planeta no valido, se usará por defecto la Tierra");
        }

        planeta.ifPresent(p ->  System.out.printf("Your weight on %s is %f N%n", p.name(), p.pesoSuperficie()));
    
        scanner.close();
    }

}