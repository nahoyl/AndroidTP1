package com.iutmontpellier.dallecortb.tp1ex3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.EventListener;


public class MainActivity extends Activity implements View.OnClickListener {


    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View boutonValider = findViewById(R.id.boutonValider);
        boutonValider.setOnClickListener(this);
        MainActivity.context = getApplicationContext();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id== R.id.boutonValider) {
            TextView nom = (TextView) findViewById(R.id.editTextNom);
            TextView prenom = (TextView) findViewById(R.id.editTextPrenom);
            String nomString = nom.getText().toString();
            String prenomString = prenom.getText().toString();
            boolean bLeChampNomEstVide = nomString.length() == 0;
            boolean bLeChampPrenomEstVide = prenomString.length() == 0;

            if (!bLeChampNomEstVide && !bLeChampPrenomEstVide) {
                afficherNomEtPrenom(nomString, prenomString);
            } else {
                afficherUnMessageDAlerte();
            }
        }
    }

    private void afficherUnMessageDAlerte() {
        TextView info = (TextView)findViewById(R.id.infoText);
        info.setText(R.string.erreurChampsNomOuPrenomVides);
        info.setTextColor(Color.RED);
    }

    private void afficherNomEtPrenom(String nomString, String prenomString) {
        Intent intent = new Intent(this, AffichageNomPrenom.class);
        intent.putExtra(NOM, nomString);
        intent.putExtra(PRENOM, prenomString);
        startActivity(intent);
    }

    public static Context getContext(){
        return MainActivity.context;
    }
}
