package mdsoftware.development.calcumath;

/**
 * Created by killa on 9/12/2017.
 */

public class teoremaChines {


    private int mdc(int a, int b) {git check-ignore -v -- myFileNotPushed
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

    private boolean arrayPrimo(int[] div,int n)
    {
        boolean primo = true;

        for(int i=0;i<n;i++)
        {

            for(int j=0;j<n;j++)
            {

                if(i==j)
                {

                }
                else
                {

                    if(this.primos(div[i], div[j]) == true)
                    {

                    }
                    else
                    {

                        primo = false;

                    }

                }

            }

        }

        return primo;

    }

    private int teorema(int min, int max, int[] div, int[] resto, int n)
    {

        int[] colunas = new int[n];
        int[] m = new int[n];
        int[] mm = new int[n];

        for(int i=0;i<n;i++)
        {

            colunas[i] = resto[i];
            System.out.println("Coluna do n "+div[i]+" com valor "+colunas[i]);

        }


        for(int i=0;i<n;i++)
        {

            int aux = 1;

            for(int j=0;j<n;j++)
            {

                if(j==i)
                {



                }
                else
                {

                    aux = aux * div[j];

                }

            }
            m[i] = aux;
            colunas[i] = colunas[i] * aux;
            System.out.println("Coluna do n "+div[i]+" com valor "+colunas[i]+" e aux "+aux);

        }

        for(int i=0;i<n;i++)
        {

            mm[i] = m[i]%div[i];
            System.out.println("Coluna do n "+div[i]+" onde "+m[i]+" modulo "+div[i]+" e congruo a "+mm[i]);
        }


        for(int i=0;i<n;i++)
        {
            int aux = 0;
            int multi = 0;
            while(aux%div[i]!=1)
            {

                multi = multi + 1;
                aux = m[i] * multi;

            }

            mm[i] = multi;
            colunas[i] = colunas[i] * mm[i];
            System.out.println("Coluna do n "+div[i]+" possui MM = "+mm[i]);

        }

        int soma = 0;
        for(int i=0;i<n;i++)
        {

            soma = soma + colunas[i];

        }

        System.out.println("Soma da tabela = "+soma);
        int multiDiv = 1;

        for(int i=0;i<n;i++)
        {

            multiDiv = multiDiv * div[i];

        }

        System.out.println("Modulo final = "+multiDiv);
        int congruFinal = soma%multiDiv;
        System.out.println("Valor da congruencia entre "+soma+" e "+multiDiv+" é igual a "+congruFinal);

        int somaFinal= congruFinal;
        int i = 0;

        System.out.println("Soma final = "+somaFinal);
        while((somaFinal > max) || (somaFinal < min))
        {
            i = i + 1;
            somaFinal = congruFinal + (multiDiv * i);

        }

        System.out.println("Valor final = "+somaFinal);

        return somaFinal;
    }

}
