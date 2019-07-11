package Menjivar;

import java.util.ArrayList;
import java.util.Random;

public class Principal {

    public static void main(String[] args){
        ArrayList<Cuenta> cuentas = new ArrayList();
        int numCuentaBusqueda;

        System.out.println("**********************************\n" +
                           "\tBienvenido\n" +
                           "**********************************");
        while(true) {
            System.out.print("*****BANCO ATLANTIDA*****\n" +
                    "\t1. Crear una cuenta\n" +
                    "\t2. Depositar\n" +
                    "\t3. Retirar\n" +
                    "\t4. Mostrar saldo de la cuenta\n" +
                    "\t5. Mostrar cuentas\n" +
                    "\t6. Salir\n");
            int opcion = lectorDeDatos.solicitarEntero("Ingrese una opcion: ");

            switch(opcion){
                case 1:
                    System.out.println("***********CREACION DE CUENTA**********\n");
                    Random rand = new Random();
                    int numeroCuenta = rand.nextInt(1000);
                    System.out.println("Su numero de cuenta sera: " + numeroCuenta);

                    System.out.print("Que tipo de cuenta desea crear?\n" +
                            "\t1. Cuenta de ahorro\n" +
                            "\t2. Cuenta de Largo plazo\n");
                    int tipoCuenta = lectorDeDatos.solicitarEntero("\tIngrese su opcion: ");

                    double saldo = lectorDeDatos.solicitarDouble("\nIngrese el saldo inicial: ");

                    if(tipoCuenta == 1){
                        cuentaAhorro nuevaCuenta = new cuentaAhorro(); //Crea el objeto
                        nuevaCuenta.numCuenta = numeroCuenta;          //Define el num de cuenta aleatorio
                        nuevaCuenta.saldo = saldo;                     //Define el saldo introducido del usuario
                        cuentas.add(nuevaCuenta);                      //Introduce esa cuenta al arreglo dinamico

                    } else if(tipoCuenta == 2){
                        cuentaLargoPlazo nuevaCuenta = new cuentaLargoPlazo();
                        nuevaCuenta.numCuenta = numeroCuenta;
                        nuevaCuenta.saldo = saldo;
                        cuentas.add(nuevaCuenta);

                    } else{
                        System.out.println("Tipo de cuenta no existente\n");
                    }
                    System.out.println("La cuenta ha sido creada exitosamente\n");
                    break;
                case 2:
                    System.out.println("***********DEPOSITAR**********\n");

                    if(cuentas.isEmpty()){
                        System.out.println(">>> No existe ninguna cuenta creada <<<");
                    } else {
                        for (Cuenta c :cuentas) {
                            do{
                                numCuentaBusqueda = lectorDeDatos.solicitarEntero("Numero de cuenta del depositante: ");

                                if(numCuentaBusqueda == c.numCuenta){

                                    double montoDeposito = lectorDeDatos.solicitarDouble("Ingrese el monto a depositar: ");

                                    System.out.println("\tSaldo anterior: $" + c.saldo);
                                    if(!c.depositar(montoDeposito)){
                                        System.out.println("El deposito sobrepasa los limites de ingreso");
                                    } else {
                                        System.out.println("\tSaldo monto:   +$" + montoDeposito);
                                        System.out.println("\tSaldo actual:   $" + c.saldo);
                                        System.out.println("\n--> El retiro fue exitoso");
                                        System.out.println("\tPara salir presione (-1)");
                                    }
                                } else{
                                    System.out.println(">>> Numero de cuenta no existente, para salir presiona (-1) <<<");
                                }
                            } while(numCuentaBusqueda != -1);
                        }
                    }
                    break;
                case 3: //Retirar
                    System.out.println("***********RETIRAR**********\n");
                    if(cuentas.isEmpty()){
                        System.out.println(">>> No existe ninguna cuenta creada <<<");
                    } else{
                        for (Cuenta c:cuentas) {
                            do{
                                numCuentaBusqueda = lectorDeDatos.solicitarEntero("Numero de cuenta del usuario: ");

                                if(numCuentaBusqueda == c.numCuenta){
                                    double montoRetiro = lectorDeDatos.solicitarDouble("Ingrese el monto a retirar $: ");

                                    System.out.println("\tSaldo anterior: $" + c.saldo);
                                    if(!c.retirar(montoRetiro)){  //Aqui mando el monto del retiro al metodo
                                        System.out.println("El retiro es mayor a la cantidad actual $:" + c.saldo);
                                    } else {
                                        System.out.println("\tSaldo monto:   -$" + montoRetiro);
                                        System.out.println("\tSaldo actual:   $" + c.saldo);
                                        System.out.println("\n--> El retiro fue exitoso");
                                        System.out.println("\tPara salir presione (-1)");
                                    }
                                } else {
                                    System.out.println(">>> Numero de cuenta no existente, para salir presiona (-1) <<<");
                                }
                            } while(numCuentaBusqueda != -1);
                        }
                    }
                    break;
                case 4: //Mostrar el saldo de la cuenta
                    System.out.println("***********SALDO DE LA CUENTA**********\n");
                    if(cuentas.isEmpty()){
                        System.out.println("-- No hay cuentas --");
                    } else {
                        for(Cuenta c: cuentas){
                            do{
                                numCuentaBusqueda = lectorDeDatos.solicitarEntero("Ingrese el numero de cuenta: ");

                                if(numCuentaBusqueda == c.numCuenta){
                                    System.out.println("> Num de cuenta: " + c.numCuenta);
                                    System.out.println("> Saldo: "  + c.saldo);

                                    if(c instanceof cuentaAhorro){
                                        System.out.println("> Tipo de cuenta: Cuenta de Ahorro\n");
                                        System.out.println("\tPara salir presione (-1)");

                                    } else if(c instanceof cuentaLargoPlazo) {
                                        System.out.println("> Tipo de cuenta: Cuenta a Largo Plazo\n");
                                        System.out.println("\tPara salir presione (-1)");
                                    }
                                } else {
                                    System.out.println(">>> Numero de cuenta no existente, para salir presiona (-1) <<<");
                                }
                            } while(numCuentaBusqueda != -1);
                        }
                    }
                    numCuentaBusqueda = 0; //Para que su valor quede vacio
                    break;
                case 5:
                    if(cuentas.isEmpty()){ //<-- Para revisar si la cuenta esta vacia
                        System.out.println("---------- No hay cuentas ----------\n");
                    } else {
                        System.out.println("***********MOSTRAR CUENTAS**********\n");
                    }
                    for(Cuenta c: cuentas){
                        String tipo = ""; //<-- se inicializa como un string vacio para que no tire error
                        if(c instanceof cuentaAhorro) {
                            tipo = "Cuenta de Ahorro";

                        } else if(c instanceof cuentaLargoPlazo) {
                            tipo = "cuenta a Largo Plazo";
                        }

                        System.out.println("> Num. de Cuenta: " + c.numCuenta + " --> " + tipo);
                    }
                    break;
                case 6:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opción no valida");
            }
            if(opcion == 6){ //<-- Para salir del ciclo while
                break;
            }
        }
    }
}