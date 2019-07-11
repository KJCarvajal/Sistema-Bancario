package Menjivar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class lectorDeDatos {
    public static int solicitarEntero(String mensaje){
        System.out.println(mensaje);
        Scanner lector = new Scanner(System.in);
        try{
            int numero = lector.nextInt();
            return numero;
        }catch(InputMismatchException e){
            System.out.println("El dato ingresado no es valido");
            return solicitarEntero(mensaje);
        }
    }
    public static double solicitarDouble(String mensaje){
        System.out.println(mensaje);
        Scanner lector = new Scanner(System.in);
        try{
            double numero = lector.nextDouble();
            return numero;
        }catch(InputMismatchException e){
            System.out.println("El dato ingresado no es valido");
            return solicitarDouble(mensaje);
        }
    }
}
