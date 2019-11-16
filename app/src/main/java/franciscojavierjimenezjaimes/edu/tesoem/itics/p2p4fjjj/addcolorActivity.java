package franciscojavierjimenezjaimes.edu.tesoem.itics.p2p4fjjj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import franciscojavierjimenezjaimes.edu.tesoem.itics.p2p4fjjj.utilidades.Utilidades;

public class addcolorActivity extends AppCompatActivity {

    EditText campoId, campoNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcolor);

        campoId = (EditText) findViewById(R.id.campoId);
        campoNombre = (EditText) findViewById(R.id.campoNombre);
    }

    //Método botón regresar
    public void back(View view) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

    public void RegistrarColor(View view) {
        RegistrarColor();
    }



    private void RegistrarColor() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_color", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_COLOR,Utilidades.CAMPO_ID,values);


            Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
        db.close();

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

