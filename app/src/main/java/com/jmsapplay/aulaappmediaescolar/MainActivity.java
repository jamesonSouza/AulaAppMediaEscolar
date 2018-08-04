package com.jmsapplay.aulaappmediaescolar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnCalcular;
    EditText editMateria, editNotaProva, editNotaTrabalho;
    TextView txtMedia, txtSituacao;

    double notaProva, notaTrabalho, media;
    String resultado;

    boolean dadosValidados= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editMateria = findViewById(R.id.editMateria);
        editNotaProva = findViewById(R.id.editNotaProva);
        editNotaTrabalho = findViewById(R.id.editNotaTrabalho);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtMedia = findViewById(R.id.txtResultado);
        txtSituacao=findViewById(R.id.txtSituacaoFinal);




        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    if(editNotaProva.getText().toString().length()>0){
                        notaProva = Double.parseDouble(editNotaProva.getText().toString());
                    }
                    else
                    {
                        editNotaProva.setError("!");
                        editNotaProva.requestFocus();
                        dadosValidados=false;
                    }
                    if(editNotaTrabalho.getText().toString().length()>0){
                        notaTrabalho = Double.parseDouble(editNotaTrabalho.getText().toString());
                    }
                    else
                    {
                        editNotaTrabalho.setError("!");
                        editNotaTrabalho.requestFocus();
                        dadosValidados=false;
                    }
                    if(editMateria.getText().toString().length()==0){
                          editMateria.setError("!");
                          editMateria.requestFocus();
                          dadosValidados=false;
                    }
                    else
                    {
                        dadosValidados=true;
                    }

                if(dadosValidados) {
                    media = (notaProva + notaTrabalho) / 2;
                    txtMedia.setText(String.valueOf(media));

                    if (media >= 7)
                        txtSituacao.setText("Aprovado");
                    else
                        txtSituacao.setText("Reprovado");
                }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "necessario inserir valores aos campos", Toast.LENGTH_LONG).show();
                }
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {


            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
