import java.util.Scanner;
import java.util.InputMismatchException;

public class Executable {
    
    public static void main(String [] args){
        Temperature temperature = new Temperature();
        
        System.out.println("Convertisseur de temperatures\n -> Entrer un nombre (temperature en degré Celcius)\n -> Entrer autre chose pour quitter");
        Scanner sc = new Scanner(System.in);
        boolean quitte = false;
        double tempC;
        while (!quitte){
            try{
                tempC = sc.nextDouble();
                temperature.setvaleurCelcius(tempC);
                System.out.println(temperature);
            }
            catch(InputMismatchException e){
                quitte = true;
            }
        }
    }
}

