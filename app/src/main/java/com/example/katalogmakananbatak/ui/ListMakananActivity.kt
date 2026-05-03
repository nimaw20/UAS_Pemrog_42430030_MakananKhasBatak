package com.example.katalogmakananbatak.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.katalogmakananbatak.R
import com.example.katalogmakananbatak.model.Makanan

class ListMakananActivity : AppCompatActivity() {

    private lateinit var daftarMakanan: ArrayList<Makanan>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_makanan)

        daftarMakanan = arrayListOf(
            Makanan(
                "Arsik",
                "Hidangan khas Batak yang identik dengan ikan mas berbumbu kuning, memakai rempah seperti andaliman dan asam patikala.",
                R.drawable.arsik
            ),
            Makanan(
                "Ayam Napinadar",
                "Masakan khas Batak dengan bumbu rempah kuat, terutama andaliman, bercita rasa gurih pedas.",
                R.drawable.ayam_napinadar
            ),
            Makanan(
                "Babi Panggang Karo",
                "Hidangan berupa daging babi panggang dengan kulit renyah, biasanya disajikan dengan sambal khas dan pelengkap daun singkong.",
                R.drawable.babi_panggang_karo
            ),
            Makanan(
                "Daun Ubi Tumbuk",
                "Olahan daun singkong yang ditumbuk, dikenal dalam kuliner Batak dan Sumatera Utara, serta umum dimasak dengan kuah santan berbumbu.",
                R.drawable.daun_ubi
            ),
            Makanan(
                "Ikan Tombur",
                "Masakan khas Batak berbahan ikan yang disajikan dengan bumbu khas seperti andaliman; dikenal juga sebagai na tinombur.",
                R.drawable.ikan_tombur
            ),
            Makanan(
                "Mie Gomak",
                "Hidangan khas Batak dari Sumatera Utara yang umum disajikan sebagai mie kuah atau goreng dengan bumbu rempah khas.",
                R.drawable.mie_gomak
            ),
            Makanan(
                "Saksang",
                "Makanan khas Batak dari daging yang dimasak dengan rempah dan andaliman.",
                R.drawable.saksang
            )
        )

        Log.d("DATA_ARRAY", "Jumlah data makanan: ${daftarMakanan.size}")

        val hasilCari = cariMakanan("ikan")
        Log.d("SEARCHING", "Hasil cari 'ikan':")
        for (makanan in hasilCari) {
            Log.d("SEARCHING", makanan.nama)
        }

        val urutAZ = ArrayList(daftarMakanan)
        urutAZ.sortBy { it.nama }
        Log.d("SORTING_AZ", "Urut A-Z:")
        for (makanan in urutAZ) {
            Log.d("SORTING_AZ", makanan.nama)
        }

        val urutZA = ArrayList(daftarMakanan)
        urutZA.sortByDescending { it.nama }
        Log.d("SORTING_ZA", "Urut Z-A:")
        for (makanan in urutZA) {
            Log.d("SORTING_ZA", makanan.nama)
        }
    }

    private fun cariMakanan(keyword: String): ArrayList<Makanan> {
        val hasil = arrayListOf<Makanan>()

        for (makanan in daftarMakanan) {
            if (makanan.nama.contains(keyword, ignoreCase = true) ||
                makanan.deskripsi.contains(keyword, ignoreCase = true)
            ) {
                hasil.add(makanan)
            }
        }

        return hasil
    }
}