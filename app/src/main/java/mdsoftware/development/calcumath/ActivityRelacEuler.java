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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityRelacEuler extends AppCompatActivity {

    String[] opçoes = new String[]{"O que deseja descobrir?","Faces","Arestas","Vértices"};
    Spinner sp;
    String resposta;
    EditText dado1, dado2;
    Button calcular;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relac_euler);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityRelacEuler.this,android.R.layout.simple_spinner_item,opçoes ){};
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp = (Spinner)findViewById(R.id.spinner);
        sp.setAdapter(adapter);

        dado1 = (EditText)findViewById(R.id.dadoRelacEuler);
        dado2 = (EditText)findViewById(R.id.dadoRelacEuler2);
        calcular = (Button)findViewById(R.id.calcularRelacEuler);
        tv = (TextView)findViewById(R.id.respostaRelacEuler);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resposta = opçoes[position];

                if (resposta.equals("Faces")){
                    dado1.setText("");
                    dado1.setHint("Escreva o número de arestas");
                    dado2.setText("");
                    dado2.setHint("Escreva o número de vértices");


                }

                if (resposta.equals("Vértices")){
                    dado1.setText("");
                    dado1.setHint("Escreva o número de arestas");
                    dado2.setText("");
                    dado2.setHint("Escreva o número de faces");

                }

                if (resposta.equals("Arestas")){
                    dado1.setText("");
                    dado1.setHint("Escreva o número de vértices");
                    dado2.setText("");
                    dado2.setHint("Escreva o número de faces");

                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dado1 = (EditText)findViewById(R.id.dadoRelacEuler);
                dado2 = (EditText)findViewById(R.id.dadoRelacEuler2);

                calcular();


                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(dado1.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(dado2.getWindowToken(), 0);
            }
        });



    }

    public void calcular(){
        String aux1 = dado1.getText().toString().trim();
        String aux2 = dado2.getText().toString().trim();

        RelacEuler relacEuler = new RelacEuler();

        if (resposta.equals("O que deseja descobrir?")){
            Toast.makeText(this, "Você esqueceu de selecionar uma função", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(aux1)) {
            Toast.makeText(this, "Você esqueceu de uma informação", Toast.LENGTH_LONG).show();
            return;
        }

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(aux2)) {
            Toast.makeText(this, "Você esqueceu de uma informação", Toast.LENGTH_LONG).show();
            return;
        }

        int n1 = Integer.parseInt(dado1.getText().toString().trim());
        int n2 =  Integer.parseInt(dado2.getText().toString().trim());

        if (!(n1 >1)){
            Toast.makeText(this, "O número digitado deve ser maior que 1", Toast.LENGTH_LONG).show();
            return;
        }

        if (!(n2 >1)){
            Toast.makeText(this, "O número digitado deve ser maior que 1", Toast.LENGTH_LONG).show();
            return;
        }



        if (resposta.equals("Faces")){
            /*
            dado1.setText("");
            dado1.setHint("Escreva o número de arestas");
            dado2.setText("");
            dado2.setHint("Escreva o número de vértices");
            */
           // relacEuler.F(n2,n1);
            tv.setText("Existe "+relacEuler.F(n1,n2) + " " + resposta);

        }

        if (resposta.equals("Vértices")){
            /*
            dado1.setText("");
            dado1.setHint("Escreva o número de arestas");
            dado2.setText("");
            dado2.setHint("Escreva o número de faces");
            */
         //  relacEuler.V(n1,n2);
            tv.setText("Existe "+relacEuler.V(n1,n2) + " " + resposta);

        }

        if (resposta.equals("Arestas")){
            /*
            dado1.setText("");
            dado1.setHint("Escreva o número de vértices");
            dado2.setText("");
            dado2.setHint("Escreva o número de faces");
            */
            tv.setText("Existe "+relacEuler.A(n1,n2) + " " + resposta);

        }


        if (resposta.equals("O que deseja descobrir?")){
            dado1.setText("");
            dado2.setText("");
            Toast.makeText(ActivityRelacEuler.this,"Selecione uma função",Toast.LENGTH_SHORT).show();
            return;
        }


    }
}
