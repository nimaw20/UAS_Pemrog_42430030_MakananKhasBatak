package com.example.katalogmakananbatak.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.katalogmakananbatak.R

class TambahMakananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_makanan)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Tambah Makanan"

        val etNama: EditText = findViewById(R.id.etNama)
        val etAsal: EditText = findViewById(R.id.etAsal)
        val etHarga: EditText = findViewById(R.id.etHarga)
        val etDeskripsi: EditText = findViewById(R.id.etDeskripsi)
        val btnSimpan: Button = findViewById(R.id.btnSimpan)
        val btnReset: Button = findViewById(R.id.btnReset)

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            if (nama.isNotEmpty()) {
                Toast.makeText(this, "Data $nama berhasil disimpan", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                etNama.error = "Nama tidak boleh kosong"
            }
        }

        btnReset.setOnClickListener {
            etNama.text.clear()
            etAsal.text.clear()
            etHarga.text.clear()
            etDeskripsi.text.clear()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}