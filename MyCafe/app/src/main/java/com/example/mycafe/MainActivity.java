package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button tambah_makan, tambah_minum, kurang_makan, kurang_minum, btn_reset, btn_buy;
    TextView tv_harga, tv_banyakmakan, tv_banyakminum, tv_ket;


    int jumlahMakanan = 0;
    int jumlahMinuman = 0;
    int totalHarga = 0;

    final int hargaMakanan = 50000;
    final int hargaMinuman = 30000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tambah_makan = findViewById(R.id.tambah_makan);
        tambah_minum = findViewById(R.id.tambah_drink);
        kurang_makan = findViewById(R.id.kurang_makan);
        kurang_minum = findViewById(R.id.kurang_drink);
        btn_buy = findViewById(R.id.btn_buy);
        btn_reset = findViewById(R.id.btn_reset);
        tv_harga = findViewById(R.id.tv_harga);
        tv_banyakmakan = findViewById(R.id.banyak_makan);
        tv_banyakminum = findViewById(R.id.banyak_drink);
        tv_ket = findViewById(R.id.tv_purchased);

        btn_reset.setOnClickListener(this);
        btn_buy.setOnClickListener(this);
        tambah_minum.setOnClickListener(this);
        kurang_makan.setOnClickListener(this);
        tambah_makan.setOnClickListener(this);
        kurang_minum.setOnClickListener(this);

        tv_ket.setText("");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_reset:
                reset();
                break;
            case R.id.btn_buy:
                buy();
                break;
            case R.id.tambah_drink:
                tambahPesanan(R.id.tambah_drink);
                break;
            case R.id.tambah_makan:
                tambahPesanan(R.id.tambah_makan);
                break;
            case R.id.kurang_drink:
                kurangPesanan(R.id.kurang_drink);
                break;
            case R.id.kurang_makan:
                kurangPesanan(R.id.kurang_makan);
                break;


        }

    }

    void reset() {
        jumlahMakanan = 0;
        jumlahMinuman = 0;
        totalHarga = 0;

        tv_banyakminum.setText("0");
        tv_banyakminum.setText("0");
        tv_ket.setText("");
        tv_harga.setText("0");
    }

    void buy() {
        tv_ket.setText("Terbeli");
        tv_ket.setTextColor(getColor(R.color.terbali));
    }

    void tambahPesanan(int nilai) {
        if (jumlahMinuman < 10) {
            if (nilai == R.id.tambah_drink) {
                jumlahMinuman++;
                totalHarga = totalHarga + hargaMinuman;
                tv_banyakminum.setText("" + jumlahMinuman);
                tv_harga.setText("" + totalHarga);
            }
        }
        if (jumlahMakanan < 10) {
            if (nilai == R.id.tambah_makan) {
                jumlahMakanan++;
                totalHarga = totalHarga + hargaMakanan;
                tv_banyakmakan.setText("" + jumlahMakanan);
                tv_harga.setText("" + totalHarga);
            }
        }


    }

    void kurangPesanan(int nilai) {
        if (jumlahMinuman > 0) {
            if (nilai == R.id.kurang_drink) {
                jumlahMinuman--;
                totalHarga = totalHarga - hargaMinuman;
                tv_banyakminum.setText("" + jumlahMinuman);
                tv_harga.setText("" + totalHarga);

            }
        }

        if (jumlahMakanan > 0) {
            if (nilai == R.id.kurang_makan) {
                jumlahMakanan--;
                totalHarga = totalHarga - hargaMakanan;
                tv_banyakmakan.setText("" + jumlahMakanan);
                tv_harga.setText("" + totalHarga);

            }
        }

    }


}
