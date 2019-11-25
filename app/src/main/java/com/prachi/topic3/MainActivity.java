package com.prachi.topic3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinCountry;
    Button btnSave;
    TextView tvResult;
    EditText etName;
    AutoCompleteTextView autoCompleteTextView;
    String[] batch={"22A","22B","22C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSave=findViewById(R.id.btnSave);
        tvResult=findViewById(R.id.tvResult);
        etName=findViewById(R.id.etName);


        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);

        ArrayAdapter stringArrayAdapter=new ArrayAdapter<>(this,
                android.R.layout.select_dialog_item,
                batch


        );
        autoCompleteTextView.setAdapter(stringArrayAdapter);
        autoCompleteTextView.setThreshold(1);


        spinCountry=findViewById(R.id.spinCountry);
        String countries[]={"Nepal","India","China"};
        ArrayAdapter adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                countries
        );
        spinCountry.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty((etName.getText()))
                ) {
                    etName.setError("Please enter name");
                    return;
                }

                String name,country,batch;
                name = etName.getText().toString();
                country = spinCountry.getSelectedItem().toString();

                batch=autoCompleteTextView.getText().toString();

                String str = "Name :" + name + ",Country:" + country + ", Batch:" + batch   + "\n";
                tvResult.append(str);

            }
        });



        }




    }
