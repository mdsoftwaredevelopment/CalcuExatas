package mdsoftware.development.calcumath;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class bhaskaraprincipal extends AppCompatActivity {

    ImageView textResumo, textPasso;
    ImageButton resumo, calcular;
    Button passo, calc;
    EditText auxEquação;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_bhaskara);

        resumo = (ImageButton)findViewById(R.id.butResumo);
         passo = (Button) findViewById(R.id.ativarPasso);
          calc = (Button)findViewById(R.id.ativarCalc);
        calcular = (ImageButton)findViewById(R.id.buscarEQ);
         textPasso = (ImageView)findViewById(R.id.textPassoBhas);
        auxEquação = (EditText)findViewById(R.id.equaçao);
     //   final ImageView textPasso = (ImageView)findViewById(R.id.textPassoBhas);
         textResumo = (ImageView)findViewById(R.id.textResumoBhas);
        tv = (TextView)findViewById(R.id.resultadoBhasc) ;



        passo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               textResumo.setVisibility(View.GONE);
                textPasso.setVisibility(View.VISIBLE);
                calcular.setVisibility(View.GONE);
                auxEquação.setVisibility(View.GONE);
                tv.setVisibility(View.GONE);


                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(auxEquação.getWindowToken(), 0);

       //        textPasso.setVisibility(View.VISIBLE);
                Log.i("SCRIPT", "ENTROU NO CLick");
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResumo.setVisibility(View.GONE);
                textPasso.setVisibility(View.GONE);
                calcular.setVisibility(View.VISIBLE);
                auxEquação.setVisibility(View.VISIBLE);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(auxEquação.getWindowToken(), 0);
            }
        });

        resumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textPasso.setVisibility(View.GONE);
                textResumo.setVisibility(View.VISIBLE);
                calcular.setVisibility(View.GONE);
                auxEquação.setVisibility(View.GONE);
                tv.setVisibility(View.GONE);
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(auxEquação.getWindowToken(), 0);
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auxEquação = (EditText)findViewById(R.id.equaçao);
                String eq = auxEquação.getText().toString();
                String menor[] = new String[3];
            //   " x² - 5x + 6 = 0 "

                eq = eq.replace("x2","x²");

                if (!(eq.contains("²"))){
                    Toast.makeText(bhaskaraprincipal.this,"Não é uma equação do 2° Grau ",Toast.LENGTH_SHORT).show();
                    tv.setVisibility(View.GONE);
                    return;
                }

// x2 + 12x - 13

                if (eq.contains("x")){
                //    "   2x² + 5x + 3 = 0 "
                    //   x² - x - 30
                    String aux[] = new String[3];
                    eq= eq.replace(" ","").replace("²","").replace("=0","").trim();
                    aux = eq.split("x");

              // 2 +5 + 3

                    int a, c = 0;
                    double b;

                    try {
                    if (aux[0].trim().equals("-")){
                        aux[0] = "-1";
                    }
                    } catch (ArrayIndexOutOfBoundsException j){
                        Toast.makeText(bhaskaraprincipal.this,"Escreva uma equação com os 3 termos ",Toast.LENGTH_SHORT).show();
                        tv.setVisibility(View.GONE);
                        return;
                    }

                    if ( aux[1].trim().equals("-")){
                        aux[1] = "-1";
                    }

                    try {


                    if (aux[2].equals("")){
                        String z = aux[0];
                        String y = aux[1];
                        aux[2] = aux[1];
                        aux[1] = aux[0];
                        aux[0] = "1";

                    }
                    } catch (ArrayIndexOutOfBoundsException j){
                        Toast.makeText(bhaskaraprincipal.this,"Escreva uma equação com os 3 termos ",Toast.LENGTH_SHORT).show();
                        tv.setVisibility(View.GONE);
                        return;
                    }


                    try {
                        a = Integer.parseInt(aux[0]);
                    }catch (NumberFormatException i){
                        a = 1;

                        try {
                            b = Double.parseDouble(aux[1]);
                        }catch (NumberFormatException j){
                            a = 1;
                            b = 1;
                            c = Integer.parseInt(aux[2]);
                        }
                    }

                    try {
                        b = Double.parseDouble(aux[1]);
                    }catch (NumberFormatException i){
                        b=1;
                        try {
                            a = Integer.parseInt(aux[0]);
                         }catch (NumberFormatException k) {
                            a = 1;
                            b = 1;
                            c = Integer.parseInt(aux[2]);
                        }

                    }
                    try {
                    c = Integer.parseInt(aux[2]);
                    } catch (ArrayIndexOutOfBoundsException j){
                        Toast.makeText(bhaskaraprincipal.this,"Escreva uma equação com os 3 termos ",Toast.LENGTH_SHORT).show();
                        tv.setVisibility(View.GONE);
                        return;
                    }


                    double potencia = Math.pow(b,2);
                    double delta =  (4*a*c);
                    double result =  Math.sqrt(potencia - delta) ;

                    Double x1 = ( (b*-1) + result)/(2*a);
                    Double x2 = ((b*-1) - result)/(2*a);
                    /*

                    a = aux[0]
                    b = aux[1]
                    c = aux[2]

                     */


                    Log.i("Script_Resultado","potencia"+ potencia + "delta" + delta + "Result" + "  " + result + "  " +x1+ " " +x2 );
                    tv.setVisibility(View.VISIBLE);
                    tv.setText("Raizes: "+x1 +" e "+x2);

                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(auxEquação.getWindowToken(), 0);
                }else{
                    Toast.makeText(bhaskaraprincipal.this,"Escreva a parte literal com 'x' ",Toast.LENGTH_SHORT).show();
                    tv.setVisibility(View.GONE);
                    return;
                  //  tv.setVisibility(View.VISIBLE);
                   // tv.setText("Escreva a equação usando a letra x");
                }







/*


                if ((eq.contains("+")) && (!(eq.contains("-"))) ){
                    // "   2x² + 5x + 3 = 0 "
                   eq= eq.replace(" ","").replace("²","").replace("x","").replace("=0","").replace("+","a").trim();
                    //2.5.3
                    String aux[] = new String[3];
                    aux = eq.split("a");

                    int a, b, c = 0;
                    try {
                        a = Integer.parseInt(aux[0]);
                    }catch (NumberFormatException i){
                        a = 1;
                        b = Integer.parseInt(aux[1]);
                        c = Integer.parseInt(aux[2]);
                    }

                    try {
                        b = Integer.parseInt(aux[1]);
                    }catch (NumberFormatException i){
                        a = Integer.parseInt(aux[0]);
                        b = 1;
                        c = Integer.parseInt(aux[2]);
                    }

                    c = Integer.parseInt(aux[2]);


                    a = 2;
                    b = 5;
                    c = 3;
                    /*Math.pow(x, y);

                    Legenda:
                    x = base
                    y = potência


                    double potencia = Math.pow(b,2);
                    double delta =  (4*a*c);
                    double result =  Math.sqrt(potencia - delta) ;

                    Double x1 = (-b + result)/(2*a);
                    Double x2 = (-b - result)/(2*a);
                    /*

                    a = aux[0]
                    b = aux[1]
                    c = aux[2]

                Log.i("Script_Resultado","potencia"+ potencia + "delta" + delta + "Result" + result +x1+ " " +x2 );

                }

                     */
                /*
                /*

                if ((eq.contains("-")) && (!(eq.contains("+"))) ){
                    eq = eq.replace(" ","").replace("²","").replace("x","").replace("=0","").replace("-","a").trim();
                    //2.5.3
                    String aux[] = new String[3];
                    aux = eq.split("a");

                    int a, b, c = 0;
                    try {
                        a = Integer.parseInt(aux[0]);
                    }catch (NumberFormatException i){
                        a = 1;
                        b = Integer.parseInt(aux[1]);
                        c = Integer.parseInt(aux[2]);
                    }

                    try {
                        b = Integer.parseInt(aux[1]);
                    }catch (NumberFormatException i){
                        a = Integer.parseInt(aux[0]);
                        b = 1;
                        c = Integer.parseInt(aux[2]);
                    }

                    c = Integer.parseInt(aux[2]);

/*
                    a = 2;
                    b = 5;
                    c = 3;
                    /*Math.pow(x, y);

                    Legenda:
                    x = base
                    y = potência


                    double potencia = Math.pow(b,2);
                    double delta =  (4*a*c);
                    double result =  Math.sqrt(potencia - delta) ;

                    Double x1 = (-b + result)/(2*a);
                    Double x2 = (-b - result)/(2*a);

                    Log.i("Script_Resultado",""+x1+ " " +x2);
                }

  */

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(auxEquação.getWindowToken(), 0);
            }
        });

    }

    public void voltar(View view) {
        Intent intent = new Intent(this, matematica.class);
        startActivity(intent);
        finish();
    }

}
