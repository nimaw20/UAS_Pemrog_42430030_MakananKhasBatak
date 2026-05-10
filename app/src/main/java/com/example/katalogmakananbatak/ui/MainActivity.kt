package com.example.katalogmakananbatak.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.katalogmakananbatak.R

class MainActivity : AppCompatActivity() {
    
    private val TAG = "42430030"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        Log.d(TAG, "Aplikasi Makanan Khas Batak dijalankan - NIM: 42430030")
        
        try {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error setting window insets: ${e.message}")
        }

        // Inisialisasi Button
        val btnLihatKatalog: Button = findViewById(R.id.btnLihatKatalog)
        val btnTambahData: Button = findViewById(R.id.btnTambahData)
        val btnTentang: Button = findViewById(R.id.btnTentang)

        // Set Click Listeners
        btnLihatKatalog.setOnClickListener {
            Log.d(TAG, "Tombol Lihat Katalog diklik")
            try {
                val intent = Intent(this, ListMakananActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e(TAG, "Gagal membuka ListMakananActivity: ${e.message}")
                Toast.makeText(this, "Terjadi kesalahan sistem", Toast.LENGTH_SHORT).show()
            }
        }

        btnTambahData.setOnClickListener {
            Log.d(TAG, "Tombol Tambah Data diklik")
            try {
                val intent = Intent(this, TambahMakananActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e(TAG, "Gagal membuka TambahMakananActivity: ${e.message}")
                Toast.makeText(this, "Gagal memuat formulir", Toast.LENGTH_SHORT).show()
            }
        }

        btnTentang.setOnClickListener {
            Log.d(TAG, "Tombol Tentang Aplikasi diklik")
            try {
                val intent = Intent(this, TentangActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e(TAG, "Gagal membuka TentangActivity: ${e.message}")
                Toast.makeText(this, "Halaman tidak ditemukan", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity onResume - Kembali ke menu utama")
    }
}