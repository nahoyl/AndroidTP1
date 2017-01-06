package com.iutmontpellier.dallecortb.tp1ex3;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.EventListener;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View boutonValider = findViewById(R.id.buttonValider);
        boutonValider.setOnClickListener(this);
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
        TextView nom                    = (TextView)findViewById(R.id.editTextNom);
        TextView prenom                 = (TextView)findViewById(R.id.editTextPrenom);
        String nomString                = nom.getText().toString();
        String prenomString             = prenom.getText().toString();
        boolean bLeChampNomEstVide      = nomString.length() == 0;
        boolean bLeChampPrenomEstVide   = prenomString.length() == 0;

        if ( !bLeChampNomEstVide && !bLeChampPrenomEstVide){
            afficherNomEtPrenom(nomString, prenomString);
        }
    }

    private void afficherNomEtPrenom(String nomString, String prenomString) {
        Intent intent = new Intent(this, AffichageNomPrenom.class);
        intent.putExtra("nom", nomString);
        intent.putExtra("prenom", prenomString);
        startActivity(intent);
    }
}
