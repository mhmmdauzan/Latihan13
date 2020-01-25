package id.ac.poliban.mi.auzan.latihan13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referensi variable ke object view
        final EditText etFirstName = findViewById(R.id.etFirstName);
        final EditText etLastName = findViewById(R.id.etLastName);
        Button btSave = findViewById(R.id.btSave);
        final Button btLoad = findViewById(R.id.btLoad);
        final TextView tvResult = findViewById(R.id.tvResult);

        //event handling
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();

                String lname, fname;
                lname = etLastName.getText().toString();
                fname = etFirstName.getText().toString();

                edit.putString("lname", lname);
                edit.putString("fname", fname);
                edit.apply();

                Toast.makeText(MainActivity.this, "data has been saved it", Toast.LENGTH_SHORT).show();
            }
        });

        btLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);

                String lname = sp.getString("lname", "na");
                String fname = sp.getString("fname", "na");
                tvResult.setText(String.format("%s %s", fname, lname));
            }
        });
    }
}
