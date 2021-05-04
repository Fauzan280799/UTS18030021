package com.example.myuts_18030021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity3 extends AppCompatActivity {

    /******menampilkkan activity SEBELUMNNYA yang sudah dibuat******/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle bundle = getIntent().getExtras();//pembuatan obyek widget textview
        TextView I = (TextView)findViewById(R.id.Judul8);
        TextView N = (TextView)findViewById(R.id.Judul7);
        TextView K = (TextView)findViewById(R.id.Judul13);
        TextView Matakuliah = (TextView)findViewById(R.id.Judul9);
        TextView Sks = (TextView)findViewById(R.id.Judul10);
        TextView Program = (TextView)findViewById(R.id.Judul6);
        TextView Sifat = (TextView)findViewById(R.id.Judul14);
        TextView Dosen = (TextView)findViewById(R.id.Judul11);
        TextView Tanggal = (TextView)findViewById(R.id.Judul12);
        I.setText(bundle.getCharSequence("I"));//menset nilai dari widget textview
        N.setText(bundle.getCharSequence("N"));
        K.setText(bundle.getCharSequence("K"));
        Matakuliah.setText(bundle.getCharSequence("Matakuliah"));//menset nilai dari widget textview
        Sks.setText(bundle.getCharSequence("Sks"));
        Program.setText(bundle.getCharSequence("Program"));
        Dosen.setText(bundle.getCharSequence("Dosen"));//menset nilai dari widget textview
        Sifat.setText(bundle.getCharSequence("Sifat"));
        Tanggal.setText(bundle.getCharSequence("Tanggal"));

/****untuk memanggil Button exit yang nantinnya tombol exit akan keluar dari aplikasi dan apabila masuk kembali ketampilan awal***/
        Button buttonexit = (Button) findViewById(R.id.Exit);
        buttonexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(exit);
                moveTaskToBack(true);
            }
        });


    }
}