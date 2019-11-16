package franciscojavierjimenezjaimes.edu.tesoem.itics.p2p4fjjj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;

import franciscojavierjimenezjaimes.edu.tesoem.itics.p2p4fjjj.entidades.Color;
import franciscojavierjimenezjaimes.edu.tesoem.itics.p2p4fjjj.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {
    Spinner combocolores;
    ArrayList<String> listacolores;
    ArrayList<Color> coloresList;

    ConexionSQLiteHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        combocolores = (Spinner) findViewById(R.id.combocolores);
        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_color", null, 1);

        consultarListaColores();
        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter(this,android.R.layout.simple_spinner_item,listacolores);

        combocolores.setAdapter(adaptador);
    }

    private void consultarListaColores() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Color colors=null;
        coloresList=new ArrayList<Color>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_COLOR,null);

        while (cursor.moveToNext()){
            colors=new Color();
            colors.setId(cursor.getInt(0));
            colors.setNombre(cursor.getString(1));

            coloresList.add(colors);
        }

        obtenerLista();
    }

    private void obtenerLista() {
        listacolores=new ArrayList<String>();
        listacolores.add("Seleccione");

        for (int i=0;i<coloresList.size();i++){
            listacolores.add(coloresList.get(i).getId()+" - "+coloresList.get(i).getNombre());
        }
    }


    public void onClick(View view){
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.addcolorscreen: miIntent=new Intent(MainActivity.this,addcolorActivity.class);
            break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.acercade, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.Acercade) {
            Toast.makeText(this, "Acerca De.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AcercadeActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

}