package com.iutmontpellier.dallecortb.tp1ex3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.iutmontpellier.dallecortb.tp1ex3.R;


public class AffichageNomPrenom extends Activity implements View.OnClickListener {

    private String prenomString;
    private String nomString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_nom_prenom);
        remplirLesDonnees();

        Button btnGalerie = (Button)findViewById(R.id.boutonAfficherGalerie);
        btnGalerie.setOnClickListener(this);
    }

    private void remplirLesDonnees() {
        Intent intent       = getIntent();

        prenomString = intent.getStringExtra(MainActivity.PRENOM);
        TextView prenomView = (TextView)findViewById(R.id.textViewPrenom);
        prenomView.setText(prenomString);

        nomString = intent.getStringExtra(MainActivity.NOM);
        TextView nomView = (TextView)findViewById(R.id.textViewNom);
        nomView.setText(nomString);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_affichage_nom_prenom, menu);
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


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.boutonAfficherGalerie){
            afficherGalerie();
        }
    }

    private void afficherGalerie() {
        Intent intent = new Intent(this, ImageScrollerActivity.class );
        intent.putExtra(MainActivity.NOM,       nomString);
        intent.putExtra(MainActivity.PRENOM,    prenomString);
        startActivity(intent);
    }
}
