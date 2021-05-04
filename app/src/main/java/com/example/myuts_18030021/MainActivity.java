package com.example.myuts_18030021;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Menentukkan Variabelnnya
    Button button;
    RadioGroup genderRadioGroup;
    EditText Nim;
    EditText Nama;

    /******memanggil activity pertama dibuat******/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //untuk menampilkkan tampilan id
        findAllViewsId();
        button.setOnClickListener(this);
    }
    //membuat variabel layout untuk proses penghubung
    private void findAllViewsId() {
        button = (Button) findViewById(R.id.Send);
        Nim = (EditText) findViewById(R.id.Nim);
        Nama = (EditText) findViewById(R.id.Nama);
        genderRadioGroup = (RadioGroup) findViewById(R.id.Kelas);
    }
    //proses dilakukannya penghubungan antara layout pertama dan kedua dimana proses yang akan ditentukkan
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);//untuk membuat obyek bundle dan menyisipkan tipe data string ke obyek
        Bundle bundle = new Bundle();
        bundle.putString("Nim", Nim.getText().toString());
        bundle.putString("Nama", Nama.getText().toString());
        int id = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton)findViewById(id);
        bundle.putString("Kelas",radioButton.getText().toString());
        intent.putExtras(bundle); //untuk menambahkan bundle intent
        startActivity(intent); //untu melakukkan proses menghubungkkan halaman selanjutnya

    }
}


