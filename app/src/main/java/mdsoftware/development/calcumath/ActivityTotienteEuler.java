package mdsoftware.development.calcumath;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityTotienteEuler extends AppCompatActivity {

    EditText  n;
    Button calc, calcular, passo, resumo;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totiente_euler);

        n = (EditText)findViewById(R.id.numeroEuler);
        calc = (Button)findViewById(R.id.calcularEuler);
        lv = (ListView)findViewById(R.id.lvTotEuler);

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

       ArrayList resultado =  totienteEuler.TotienteEuler(numeroN);

        int aux = resultado.size();

        resultado.add(0, "Existem "+aux+" co-primos de "+numeroN+". Eles são:");

       // ArrayList teste = new ArrayList();


        ArrayAdapter arrayAdapter = new ArrayAdapter(ActivityTotienteEuler.this,android.R.layout.simple_list_item_1,resultado);
        lv.setVisibility(View.VISIBLE);
        lv.setAdapter(arrayAdapter);

    }

}
