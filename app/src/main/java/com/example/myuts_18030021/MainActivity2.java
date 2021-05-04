package com.example.myuts_18030021;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    //untuk menentukkan variable data yang akan dipakai untuk menampilkan data
    Button Tanggal;
    Button btn;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat DateFormat;
    TextView I;
    TextView N;
    TextView K;
    EditText Matakuliah;
    EditText Sks;
    EditText Sifat;
    EditText Program;
    EditText Dosen;

    /******menampilkkan activity pertama yang dibuat ke layout kedua******/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();//pembuatan obyek widget textview
        TextView Nim = (TextView) findViewById(R.id.I);
        TextView Nama = (TextView) findViewById(R.id.N);
        TextView Kelas = (TextView) findViewById(R.id.K);
        Nim.setText(bundle.getCharSequence("Nim"));//menset nilai dari widget textview
        Nama.setText(bundle.getCharSequence("Nama"));
        Kelas.setText(bundle.getCharSequence("Kelas"));

        /****untuk memanggil Button reset yang nantinnya tombol reset akan kembali ke menu awal ketampilan utama***/
        Button buttonreset = (Button) findViewById(R.id.Reset);
        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reset = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(reset);
            }
        });

        /******Pembuattan Proses Button Tanggal Menjadi DatetimePicker******/
        Tanggal = (Button) findViewById(R.id.Tanggal);
        DateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
    }//penentuan method class dan pembuatan format Datetimrpicker

    private void showDateDialog() {
        Calendar calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                Tanggal.setText(DateFormat.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

        //untuk menampilkkan tampilan id
        findAllViewsId();
        btn.setOnClickListener(this);
    }
    //membuat variabel layout yang nantinya akan dikirim ke layout hasil akhir/ untuk proses penghubung
    private void findAllViewsId() {
        btn = (Button) findViewById(R.id.Submit);
        I = (TextView) findViewById(R.id.I);
        N = (TextView) findViewById(R.id.N);
        K = (TextView) findViewById(R.id.K);
        Matakuliah = (EditText) findViewById(R.id.Matakuliah);
        Sks = (EditText) findViewById(R.id.Sks);
        Sifat = (EditText) findViewById(R.id.Sifat);
        Program = (EditText) findViewById(R.id.Program);
        Dosen = (EditText) findViewById(R.id.Dosen);
        Tanggal = (Button) findViewById(R.id.Tanggal);

    }
    //proses dilakukannya penghubungan antara layout 2 dan hasil akhir
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);//untuk membuat obyek bundle dan menyisipkan tipe data string ke obyek
        Bundle bundle = new Bundle();
        bundle.putString("I", I.getText().toString());
        bundle.putString("N", N.getText().toString());
        bundle.putString("K", K.getText().toString());
        bundle.putString("Matakuliah", Matakuliah.getText().toString());
        bundle.putString("Sks", Sks.getText().toString());
        bundle.putString("Sifat", Sifat.getText().toString());
        bundle.putString("Program", Program.getText().toString());
        bundle.putString("Dosen", Dosen.getText().toString());
        bundle.putString("Tanggal", Tanggal.getText().toString());
        intent.putExtras(bundle); //untuk menambahkan bundle intent
        startActivity(intent); //untuk melakukkan proses menghubungkkan halaman selanjutnya
    }
}

