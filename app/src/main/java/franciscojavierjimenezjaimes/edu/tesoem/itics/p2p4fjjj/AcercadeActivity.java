package franciscojavierjimenezjaimes.edu.tesoem.itics.p2p4fjjj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AcercadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);
    }
    //Método botón regresar
    public void back(View view) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

}
