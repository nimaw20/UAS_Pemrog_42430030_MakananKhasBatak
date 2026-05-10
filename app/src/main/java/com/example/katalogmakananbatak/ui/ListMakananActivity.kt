package com.example.katalogmakananbatak.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.katalogmakananbatak.R
import com.example.katalogmakananbatak.model.Makanan

class ListMakananActivity : AppCompatActivity() {

    private val TAG = "42430030"
    private lateinit var daftarMakanan: ArrayList<Makanan>
    private lateinit var adapter: MakananAdapter
    private lateinit var etSearch: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_makanan)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Daftar Makanan Batak"

        // Inisialisasi Data
        initData()

        // Setup RecyclerView
        val rvMakanan: RecyclerView = findViewById(R.id.rvMakanan)
        rvMakanan.layoutManager = LinearLayoutManager(this)
        adapter = MakananAdapter(daftarMakanan)
        rvMakanan.adapter = adapter

        // Setup Search Feature (Linear Search)
        etSearch = findViewById(R.id.etSearch)
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString()
                linearSearch(query)
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun initData() {
        daftarMakanan = arrayListOf(
            Makanan("Arsik", "Ikan mas berbumbu kuning dengan andaliman.", R.drawable.arsik),
            Makanan("Ayam Napinadar", "Ayam bakar bumbu andaliman dan darah ayam.", R.drawable.ayam_napinadar),
            Makanan("Babi Panggang Karo", "Daging babi panggang renyah khas Karo.", R.drawable.babi_panggang_karo),
            Makanan("Daun Ubi Tumbuk", "Sayur daun singkong tumbuk bersantan.", R.drawable.daun_ubi),
            Makanan("Ikan Tombur", "Ikan bakar/rebus dengan sambal andaliman.", R.drawable.ikan_tombur),
            Makanan("Mie Gomak", "Spaghetti ala Batak dengan bumbu kacang/santan.", R.drawable.mie_gomak),
            Makanan("Saksang", "Olahan daging berbumbu rempah dan andaliman.", R.drawable.saksang)
        )
    }

    /**
     * Implementasi Algoritma Linear Search
     * Mencari data satu per satu dari awal hingga akhir list
     */
    private fun linearSearch(query: String) {
        Log.d(TAG, "Melakukan pencarian Linear Search untuk: $query")
        
        val hasilPencarian = ArrayList<Makanan>()

        for (item in daftarMakanan) {
            // Memeriksa apakah nama atau deskripsi mengandung kata kunci (Case Insensitive)
            if (item.nama.contains(query, ignoreCase = true) || 
                item.deskripsi.contains(query, ignoreCase = true)) {
                hasilPencarian.add(item)
            }
        }

        Log.d(TAG, "Linear Search selesai. Ditemukan ${hasilPencarian.size} hasil.")
        adapter.updateData(hasilPencarian)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}