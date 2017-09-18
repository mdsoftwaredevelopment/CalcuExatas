package mdsoftware.development.calcumath;

import java.util.ArrayList;

/**
 * Created by killa on 9/12/2017.
 */
//IMPLEMENTAÇÃO: chamar totienteEuler com o numero N entrado pelo usuario


//O input deve ser maior que 1

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
    public ArrayList<String> TotienteEuler(int n){
        ArrayList<Integer> saida = new ArrayList<Integer>();
        for(int i=1;i<n;i++){
            if(primos(n,i)){
                saida.add(i);
            }
        }
        ArrayList<String> saidaString = new ArrayList<String>();
        int aux = saida.size()%3;
        int aux2 = saida.size()/3;
        saidaString.add((Integer.toString(saida.size())));
        for(int i=0;i<aux2*3;i=i+3){
            saidaString.add(saida.get(i)+"     -     "+saida.get(i+1)+"     -     "+saida.get(i+2));
        }
        if(aux==1){
            saidaString.add(saida.get(saida.size()-1).toString());
        }
        if(aux==2){
            saidaString.add(saida.get(saida.size()-2)+"     -     "+saida.get(saida.size()-1));
        }
        return saidaString;
    }
}
