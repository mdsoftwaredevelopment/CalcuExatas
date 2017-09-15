package mdsoftware.development.calcumath;

/**
 * Created by killa on 9/12/2017.
 */
//IMPLEMENTAÇÃO: escolher umas das 3 funções de acordo c a escolha do usuario (exemplo, o usuario possui vértice e aresta então necessita das faces como resultado) Dica: implementar usando 3 caixas radio para
//possibilitar escolher cada uma das situações

//

public class RelacEuler {
    public int F(int v,int a){
        int f;
        f=(v-a-2)*-1;
        return f;
    }
    public int A(int v,int f){
        int a;
        a=v+f-2;
        return a;
    }
    public int V(int a,int f){
        int v;
        v=a+2-f;
        return v;
    }
}
