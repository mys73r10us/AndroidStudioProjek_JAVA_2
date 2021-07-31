package com.example.studikasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FormActivity extends AppCompatActivity {
    database db;
    EditText nama;
    CheckBox cb1, cb2, cb3, cb4;
    TextView bangsal_penyakit;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        db = new database(this);

        nama = (EditText)findViewById(R.id.nama_txt);

        cb1 = (CheckBox)findViewById(R.id.checkBox1);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        cb3 = (CheckBox)findViewById(R.id.checkBox3);
        cb4 = (CheckBox)findViewById(R.id.checkbox4);

        Intent ba = getIntent();
        String pilihBangsal = ba.getStringExtra("Bangsal");
        String pilihPenyakit = ba.getStringExtra("Penyakit");
        bangsal_penyakit =  (TextView)findViewById(R.id.bangsal_penyakit_txt);
        bangsal_penyakit.setText("Bangsal : "+pilihBangsal+"\n"+"Penyakit : "+pilihPenyakit);

        if(pilihBangsal.equals("Bangsal Anak") && pilihPenyakit.equals("Demam Berdarah")){
            cb1.setText("Temperatur kurang dari 37");
            cb2.setText("Tingkat haemogoblin di atas 35000");
            cb3.setText("Mata tidak cekung");
            cb4.setText("Aktif");
        }else if(pilihBangsal.equals("Bangsal Anak") && pilihPenyakit.equals("Tipus")){
            cb1.setText("Temperatur kurang dari 37");
            cb2.setText("Tingkat leukosit normal");
            cb3.setText("Tidak diare");
            cb4.setText("Nafsu makan kembali");
        }else if(pilihBangsal.equals("Bangsal Dewasa") && pilihPenyakit.equals("Demam Berdarah")){
            cb1.setText("Temperatur kurang dari 36,5");
            cb2.setText("Tingkat haemogoblin di atas 30000");
            cb3.setText("Mata tidak cekung");
            cb4.setText("Aktif");
        }else if(pilihBangsal.equals("Bangsal Dewasa") && pilihPenyakit.equals("Tipus")){
            cb1.setText("Temperatur kurang dari 37");
            cb2.setText("Tingkat leukosit normal");
            cb3.setText("Tidak diare");
            cb4.setText("Nafsu makan kembali");
        }

        simpan = (Button)findViewById(R.id.simpan_btn);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNama = nama.getText().toString();
                String strcb1 = cb1.getText().toString();
                String strcb2 = cb2.getText().toString();
                String strcb3 = cb3.getText().toString();
                String strcb4 = cb4.getText().toString();
                Boolean inputData = db.insertData(strNama, strcb1, strcb2, strcb3, strcb4);
                if(inputData == true){
                    Toast.makeText(getApplicationContext(), "Data Tersimpan!", Toast.LENGTH_SHORT).show();
                    Intent intentMain = new Intent(FormActivity.this, MainActivity.class);
                    startActivity(intentMain);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Data Gagal Tersimpan!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}