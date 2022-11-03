package uts.firaIF3B;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Nama;
    EditText NomorPendaftaran;
    Spinner Pilihan;
    CheckBox Daftar;
    Button Klik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nama = findViewById(R.id.et_Nlengkap);
        NomorPendaftaran = findViewById(R.id.et_Npendaftaran);
        Pilihan = findViewById(R.id.sp_pilihan);
        Daftar = findViewById(R.id.cb_Kdaftar);
        Klik = findViewById(R.id.btn_daftar);

        Klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String NamaLengkap = Nama.getText().toString();
                String NomorOrang = NomorPendaftaran.getText().toString();
                String cetak = Daftar.getText().toString();
                String putar = String.valueOf(Pilihan.getSelectedItem());

                if (NamaLengkap.trim().equals("")) {
                    Nama.setError("Nama Tidak Boleh Kosong");
                }
                else if (NomorOrang.trim().equals("")) {
                    NomorPendaftaran.setError("Nomor Pendaftaran Tidak Boleh Kosong");
                }
                else if (!Daftar.isChecked()){
                    Toast.makeText(MainActivity.this,"Harap di isi terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
                else if (putar.equalsIgnoreCase("Jalur Pendaftaran")){
                    Toast.makeText(MainActivity.this, "Harap di pilih terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent pindah = new Intent(MainActivity.this,SecondActivity.class);
                    pindah.putExtra("Knama",NamaLengkap);
                    pindah.putExtra("Knomor",NomorOrang);
                    pindah.putExtra("Kkonfirmasi", cetak);
                    pindah.putExtra("Kpendaftaran", putar);
                    startActivity(pindah);

                }
            }
        });
    }
}