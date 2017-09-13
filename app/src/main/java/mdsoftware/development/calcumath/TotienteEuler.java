package mdsoftware.development.calcumath;

import java.util.ArrayList;

/**
 * Created by killa on 9/12/2017.
 */
//IMPLEMENTAÇÃO: chamar totienteEuler com o numero N entrado pelo usuario


public class TotienteEuler {
    private int mdc(int a, int b) {
        if (b == 0)
            return a;
        else
            return mdc(b, a % b);
    }

    private boolean primos(int a, int b)
    {

        int x = this.mdc(a, b);
        if( x == 1){
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList TotienteEuler(int n){
        ArrayList<Integer> saida = new ArrayList();
        for(int i=1;i<n;i++){
            if(primos(n,i)){
                saida.add(i);
            }
        }
        return saida;
    }
}
