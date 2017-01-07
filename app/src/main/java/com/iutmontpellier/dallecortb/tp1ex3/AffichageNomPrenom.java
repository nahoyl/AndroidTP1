package com.iutmontpellier.dallecortb.tp1ex3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.iutmontpellier.dallecortb.tp1ex3.R;


public class AffichageNomPrenom extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_nom_prenom);

        remplirLesDonnees();
    }

    private void remplirLesDonnees() {
        Intent intent       = getIntent();

        String prenomString = intent.getStringExtra(MainActivity.PRENOM);
        TextView prenomView = (TextView)findViewById(R.id.textViewPrenom);
        prenomView.setText(prenomString);

        String nomString = intent.getStringExtra(MainActivity.NOM);
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
}
