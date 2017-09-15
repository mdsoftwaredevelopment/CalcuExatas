package mdsoftware.development.calcumath;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityTeoremaChines extends AppCompatActivity {
    EditText min, max, n, detalhes;
    Button calc, enviarDetalhes, passo, butCalculadora, resumoChines;
    ArrayList divisor = new ArrayList();
    ArrayList resto = new ArrayList();
    ListView lv;
    TextView tv;
    ImageView imgPassoChines, basicoChines;
    int contDiv =1;
    int contRest = 1;
    int contGeral = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teorema_chines);

        basicoChines = (ImageView)findViewById(R.id.basicoChines);
        resumoChines = (Button)findViewById(R.id.resumoChines);
        imgPassoChines = (ImageView)findViewById(R.id.imgPassoChines);
        butCalculadora =  (Button)findViewById(R.id.calcChines);
        passo = (Button)findViewById(R.id.passoChines);
        min = (EditText)findViewById(R.id.minChines);
        max = (EditText)findViewById(R.id.maxChines);
        n = (EditText)findViewById(R.id.numNChines);
        calc = (Button)findViewById(R.id.resultChines);
        detalhes = (EditText)findViewById(R.id.detalhesChines);
        enviarDetalhes= (Button)findViewById(R.id.butEnviarDetalhes);
        lv = (ListView)findViewById(R.id.listView);
        tv = (TextView)findViewById(R.id.textViewResultado);

        resumoChines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min.setVisibility(View.INVISIBLE);
                max.setVisibility(View.INVISIBLE);
                n.setVisibility(View.INVISIBLE);
                calc.setVisibility(View.INVISIBLE);
                imgPassoChines.setVisibility(View.INVISIBLE);
                basicoChines.setVisibility(View.VISIBLE);
                enviarDetalhes.setVisibility(View.INVISIBLE);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(detalhes.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(n.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(min.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(max.getWindowToken(), 0);
            }
        });

        passo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min.setVisibility(View.INVISIBLE);
                max.setVisibility(View.INVISIBLE);
                n.setVisibility(View.INVISIBLE);
                calc.setVisibility(View.INVISIBLE);
                imgPassoChines.setVisibility(View.VISIBLE);
                basicoChines.setVisibility(View.INVISIBLE);
                enviarDetalhes.setVisibility(View.INVISIBLE);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(detalhes.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(n.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(min.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(max.getWindowToken(), 0);
            }
        });

        butCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min.setVisibility(View.VISIBLE);
                max.setVisibility(View.VISIBLE);
                n.setVisibility(View.VISIBLE);
                calc.setVisibility(View.VISIBLE);
                imgPassoChines.setVisibility(View.INVISIBLE);
                basicoChines.setVisibility(View.INVISIBLE);
                enviarDetalhes.setVisibility(View.INVISIBLE);
                detalhes.setVisibility(View.INVISIBLE);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(detalhes.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(n.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(min.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(max.getWindowToken(), 0);
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String max, n;
               String min = ((EditText) findViewById(R.id.minChines)).getText().toString();
                max = ((EditText)findViewById(R.id.maxChines)).getText().toString();
                n = ((EditText)findViewById(R.id.numNChines)).getText().toString();

                if (min.equals(max)){
                    Toast.makeText(ActivityTeoremaChines.this, "Mínimo e máximo iguais", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(max)){
                    Toast.makeText(ActivityTeoremaChines.this, "Escreva um máximo", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(min)){
                    Toast.makeText(ActivityTeoremaChines.this, "Escreva um número mínimo", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(n)){
                    Toast.makeText(ActivityTeoremaChines.this, "Escreva o número de divisores", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Integer.parseInt(n)<=1){
                    Toast.makeText(ActivityTeoremaChines.this, "Número de divisores precisa ser maior que 1", Toast.LENGTH_SHORT).show();
                    return;
                }


                calcular(min,max,n);



            }
        });

        enviarDetalhes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(detalhes.getText().toString())){
                    Toast.makeText(ActivityTeoremaChines.this, "Escreva o divisor ou o resto.", Toast.LENGTH_SHORT).show();
                    return;
                }




                String hint = (String) detalhes.getHint();
                if (hint.contains("divisor")){

                    if (Integer.parseInt(detalhes.getText().toString())<1){
                        Toast.makeText(ActivityTeoremaChines.this, "Divisor precisa ser maior que 1", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    divisor.add(Integer.parseInt(detalhes.getText().toString()));
                    detalhes.setHint("Escreva o resto "+ contDiv++);
                    detalhes.setText("");

                }

                if (hint.contains("resto")){
                   contRest = contRest + 1;
                    resto.add(Integer.parseInt(detalhes.getText().toString()));
                    detalhes.setHint("Escreva o divisor "+contRest);
                    detalhes.setText("");

                }
                contGeral = contGeral + 1;
                if (contGeral == (Integer.parseInt(n.getText().toString()))*2){
                    gambiarraDez();
                }


                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(detalhes.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(n.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(min.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(max.getWindowToken(), 0);


            }
        });

    }

    public void calcular(String minomo,String maximo, String ns){
        min.setVisibility(View.GONE);
        max.setVisibility(View.GONE);
        n.setVisibility(View.GONE);
        calc.setVisibility(View.GONE);
        enviarDetalhes.setVisibility(View.VISIBLE);
        detalhes.setVisibility(View.VISIBLE);
      //  int auxN = Integer.parseInt(n);
       // int array1[] = new int[auxN];
       // int array2[] = new int[auxN];
    }

    public void gambiarraDez(){
        detalhes.setVisibility(View.GONE);
        enviarDetalhes.setVisibility(View.GONE);
         int array1[] = new int[Integer.parseInt(n.getText().toString())];
         int array2[] = new int[Integer.parseInt(n.getText().toString())];
        for (int i = 0; i<divisor.size();i++){
            array1[i] = (int)divisor.get(i);
            array2[i] = (int)resto.get(i);
        }

        teoremaChines teoremaChines = new teoremaChines();

        if (teoremaChines.arrayPrimo(array1,Integer.parseInt(n.getText().toString()))){
            ArrayList resultado = teoremaChines.teorema(Integer.parseInt(min.getText().toString()),Integer.parseInt(max.getText().toString()),array1,array2,Integer.parseInt(n.getText().toString()));
            ArrayAdapter arrayAdapter = new ArrayAdapter(ActivityTeoremaChines.this,android.R.layout.simple_list_item_1,resultado);
            tv.setVisibility(View.VISIBLE);
            lv.setVisibility(View.VISIBLE);
            lv.setAdapter(arrayAdapter);

            Log.i("Script","" + resultado.get(0));

        }else {

            ArrayList resultado = new ArrayList();
            resultado.add("Existe um ou mais primos entre si.");
            ArrayAdapter arrayAdapter = new ArrayAdapter(ActivityTeoremaChines.this,android.R.layout.simple_list_item_1,resultado);
            tv.setVisibility(View.VISIBLE);
            lv.setVisibility(View.VISIBLE);
            lv.setAdapter(arrayAdapter);
          //  Toast.makeText(ActivityTeoremaChines.this,"Existe um ou mais primos entre si",Toast.LENGTH_SHORT).show();
        }


    }

}
