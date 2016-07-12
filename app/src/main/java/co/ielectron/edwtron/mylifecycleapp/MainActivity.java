package co.ielectron.edwtron.mylifecycleapp;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Ejemplo del ciclo de vida de las actividades
 *
 * para comprender mejor en que momentos se llaman a las metodos de la actividad
 *
 * onCreate()
 * onStart()
 * onResume()
 * onRestart()
 * onPause()
 * onStop()
 *
 *
 */

public class MainActivity extends AppCompatActivity {
    static final String datico = "";
    private int dato;
    private TextView lblDato, lblDatoSinSalvar;
    EditText txtdato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblDato = (TextView) findViewById(R.id.lblDato);
        lblDatoSinSalvar = (TextView) findViewById(R.id.lblDatoSinSalvar);
        txtdato = (EditText) findViewById(R.id.txtDato);

        if (savedInstanceState != null) {
            // Restore value of members from saved state

            lblDato.setText(savedInstanceState.getString(datico));

        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(datico, lblDato.getText().toString());
        super.onSaveInstanceState(outState);
    }



    public void incrementar(View view){
        if (!TextUtils.isEmpty(txtdato.getText().toString())){
            dato = Integer.parseInt(txtdato.getText().toString());
            dato++;
            // Este dato es salvado cuando se reorienta el dispositivo con el metodo onSaveInstanceState()
            lblDato.setText("Valor incrementado : " + dato);
            // Este dato no se salva
            lblDatoSinSalvar.setText("Otro Valor incrementado : " + dato);

        }else{
            txtdato.setError("Ingrese un Valor");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast toast = Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast toast = Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast toast = Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast toast = Toast.makeText(this, "OnReStart", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void otra(View view){
        //lanzamos otra activity
        Intent intent = new Intent(this, OtraActivity.class);
        startActivity(intent);
    }
}
