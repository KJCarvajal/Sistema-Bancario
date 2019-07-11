package Menjivar;

public class cuentaLargoPlazo extends Cuenta{
    public final double PENALTI = .05;

    public boolean retirar(double monto){
        monto += (monto * PENALTI);
        return super.retirar(monto);

    }
}
