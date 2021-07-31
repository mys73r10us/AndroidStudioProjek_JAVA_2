package com.example.studikasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner bangsal_spn, penyakit_spn;
    Button simpan;

    ArrayList<String> arrayList_bangsal;
    ArrayAdapter<String> arrayAdapter_bangsal;

    ArrayList<String> arrayList_penyakit;
    ArrayAdapter<String> arrayAdapter_penyakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bangsal_spn = (Spinner)findViewById(R.id.bangsal_spin);
        penyakit_spn = (Spinner)findViewById(R.id.penyakit_spin);

        simpan = (Button)findViewById(R.id.next_btn);

        arrayList_bangsal = new ArrayList<>();
        arrayList_bangsal.add("Bangsal Anak");
        arrayList_bangsal.add("Bangsal Dewasa");

        arrayAdapter_bangsal = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_bangsal);
        bangsal_spn.setAdapter(arrayAdapter_bangsal);

        arrayList_penyakit = new ArrayList<>();
        arrayList_penyakit.add("Demam Berdarah");
        arrayList_penyakit.add("Tipus");

        arrayAdapter_penyakit = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_penyakit);
        penyakit_spn.setAdapter(arrayAdapter_penyakit);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pilihBangsal = bangsal_spn.getSelectedItem().toString();
                String pilihPenyakit = penyakit_spn.getSelectedItem().toString();

                Intent intentForm = new Intent(MainActivity.this, FormActivity.class);

                intentForm.putExtra("Bangsal", pilihBangsal);
                intentForm.putExtra("Penyakit", pilihPenyakit);

                startActivity(intentForm);
                finish();


            }
        });


    }
}