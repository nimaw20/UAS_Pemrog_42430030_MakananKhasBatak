package com.example.katalogmakananbatak.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.katalogmakananbatak.R
import com.example.katalogmakananbatak.model.Makanan

class ListMakananActivity : AppCompatActivity() {

    private val TAG = "42430030"
    private lateinit var daftarMakanan: ArrayList<Makanan>
    private lateinit var currentList: ArrayList<Makanan>
    private lateinit var adapter: MakananAdapter
    private lateinit var etSearch: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_makanan)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Daftar Makanan Batak"

        // Inisialisasi Data
        initData()
        currentList = ArrayList(daftarMakanan)

        // Setup RecyclerView
        val rvMakanan: RecyclerView = findViewById(R.id.rvMakanan)
        rvMakanan.layoutManager = LinearLayoutManager(this)
        adapter = MakananAdapter(currentList)
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

        // Setup Sorting Features (Bubble Sort)
        val btnSortAZ: Button = findViewById(R.id.btnSortAZ)
        val btnSortZA: Button = findViewById(R.id.btnSortZA)

        btnSortAZ.setOnClickListener {
            bubbleSort(true)
        }

        btnSortZA.setOnClickListener {
            bubbleSort(false)
        }
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
     */
    private fun linearSearch(query: String) {
        Log.d(TAG, "Melakukan pencarian Linear Search untuk: $query")
        
        currentList.clear()
        if (query.isEmpty()) {
            currentList.addAll(daftarMakanan)
        } else {
            for (item in daftarMakanan) {
                if (item.nama.contains(query, ignoreCase = true) || 
                    item.deskripsi.contains(query, ignoreCase = true)) {
                    currentList.add(item)
                }
            }
        }

        Log.d(TAG, "Linear Search selesai. Ditemukan ${currentList.size} hasil.")
        adapter.updateData(currentList)
    }

    /**
     * Implementasi Algoritma Bubble Sort
     * @param ascending true untuk A-Z, false untuk Z-A
     */
    private fun bubbleSort(ascending: Boolean) {
        Log.d(TAG, "Melakukan Bubble Sort - Ascending: $ascending")
        val n = currentList.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                val compare = currentList[j].nama.compareTo(currentList[j + 1].nama, ignoreCase = true)
                
                val shouldSwap = if (ascending) {
                    compare > 0
                } else {
                    compare < 0
                }

                if (shouldSwap) {
                    // Swap elements
                    val temp = currentList[j]
                    currentList[j] = currentList[j + 1]
                    currentList[j + 1] = temp
                }
            }
        }
        
        Log.d(TAG, "Bubble Sort selesai.")
        adapter.notifyDataSetChanged()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}