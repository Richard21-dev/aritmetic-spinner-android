package com.example.spinneraritmetico;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText et2;
    EditText et1;
    public static double isNumber(String number){
        double input =.0;
        try{
            if(number!=null)
                input=Double.parseDouble(number);
        }catch (NumberFormatException nfe){
        }
        return input;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView tVResult= (TextView) findViewById(R.id.txtResult);
         et1= (EditText) findViewById(R.id.et1);
         et2= (EditText) findViewById(R.id.et2);
         //Objeto Spinner
        Spinner combo_Opciones= (Spinner) findViewById(R.id.spinner);
        //Objeto ArrayAdapter
        ArrayAdapter<CharSequence> adapt= ArrayAdapter.createFromResource(this,
                R.array.comboOpcion, android.R.layout.simple_spinner_item);
        combo_Opciones.setAdapter(adapt);

        combo_Opciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                double n1= isNumber(et1.getText().toString());
                double n2= isNumber(et2.getText().toString());

                switch (i){
                    case 1:
                        double sum= n1+n2;
                        tVResult.setText(String.valueOf(sum));
                        break;
                    case 2:
                        double rest= n1-n2;
                        tVResult.setText(String.valueOf(rest));
                        break;
                    case 3:
                        double div= n1/n2;
                        tVResult.setText(String.valueOf(div));
                        break;
                    case 4:
                        double prod= n1*n2;
                        tVResult.setText(String.valueOf(prod));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}