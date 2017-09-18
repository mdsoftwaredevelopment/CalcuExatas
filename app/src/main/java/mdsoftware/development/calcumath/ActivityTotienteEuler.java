package mdsoftware.development.calcumath;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityTotienteEuler extends AppCompatActivity {

    EditText  n;
   Button calculadora, passo, resumo;
    ImageView imgResumo, imgPasso;
    Button calc;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totiente_euler);

        n = (EditText)findViewById(R.id.numeroEuler);
        calc = (Button)findViewById(R.id.calcularEuler);
        lv = (ListView)findViewById(R.id.lvTotEuler);

        imgResumo = (ImageView)findViewById(R.id.imgTotienteResumo);
        imgPasso = (ImageView)findViewById(R.id.imgTotientePasso);



        calculadora = (Button)findViewById(R.id.calcTotEuler);
        passo = (Button)findViewById(R.id.passoEuler);
        resumo = (Button)findViewById(R.id.basicTotientEuler);







        calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n.setVisibility(View.VISIBLE);
                calc.setVisibility(View.VISIBLE);
                lv.setVisibility(View.VISIBLE);
                imgPasso.setVisibility(View.GONE);
                imgResumo.setVisibility(View.GONE);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(n.getWindowToken(), 0);

            }
        });

        passo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n.setVisibility(View.GONE);
                calc.setVisibility(View.GONE);
                lv.setVisibility(View.GONE);
                imgPasso.setVisibility(View.VISIBLE);
                imgResumo.setVisibility(View.GONE);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(n.getWindowToken(), 0);

            }
        });

        resumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n.setVisibility(View.GONE);
                calc.setVisibility(View.GONE);
                lv.setVisibility(View.GONE);
                imgPasso.setVisibility(View.GONE);
                imgResumo.setVisibility(View.VISIBLE);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(n.getWindowToken(), 0);
            }
        });


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = (EditText)findViewById(R.id.numeroEuler);
                calcular();


                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(n.getWindowToken(), 0);
            }
        });

    }

    public void calcular(){
      String auxN = n.getText().toString();
        TotienteEuler totienteEuler = new TotienteEuler();

        if (TextUtils.isEmpty(auxN)){
            Toast.makeText(ActivityTotienteEuler.this, "Escreva um número", Toast.LENGTH_SHORT).show();
            return;

        }

        int numeroN = Integer.parseInt(auxN);

        if (numeroN<=1){
           Toast.makeText(ActivityTotienteEuler.this, "O número precisa ser maior que 1", Toast.LENGTH_SHORT).show();
            return;
        }

       ArrayList resultado =  totienteEuler.TotienteEuler(numeroN);

//        String aux = Integer.toString(resultado.size());
        String aux = (String) resultado.get(0);
       resultado.remove(0);


        resultado.add(0, "Existem "+aux+" co-primos de "+numeroN+". Eles são:");


        lv.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        ArrayAdapter arrayAdapter = new ArrayAdapter(ActivityTotienteEuler.this,android.R.layout.simple_list_item_1,resultado);
        lv.setVisibility(View.VISIBLE);
        lv.setAdapter(arrayAdapter);




    }



}
