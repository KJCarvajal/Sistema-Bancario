package Menjivar;

public abstract class Cuenta {
    public int numCuenta;
    public double saldo;
    public final double SALDO_MAX = 10_000_000;

    //retirar(double): boolean
    //          ^         ^ Lo que devuelve
    // tipo de parametro

    public boolean retirar(double monto){
        if((saldo - monto) < 0){
            return false;
        }
        this.saldo -= monto;
        return true;
    }

    public boolean depositar(double monto){
        if((monto+saldo) > SALDO_MAX){
            return false;
        }
        saldo += monto;
        return true;
    }
}
