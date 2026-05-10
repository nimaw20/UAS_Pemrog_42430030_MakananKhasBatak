package com.example.katalogmakananbatak.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.katalogmakananbatak.R
import com.example.katalogmakananbatak.model.Makanan

class MakananAdapter(private var listMakanan: List<Makanan>) :
    RecyclerView.Adapter<MakananAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgMakanan: ImageView = view.findViewById(R.id.imgMakanan)
        val tvNama: TextView = view.findViewById(R.id.tvNamaMakanan)
        val tvDeskripsi: TextView = view.findViewById(R.id.tvDeskripsiMakanan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_makanan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val makanan = listMakanan[position]
        holder.tvNama.text = makanan.nama
        holder.tvDeskripsi.text = makanan.deskripsi
        holder.imgMakanan.setImageResource(makanan.gambar)
    }

    override fun getItemCount(): Int = listMakanan.size

    fun updateData(newList: List<Makanan>) {
        listMakanan = newList
        notifyDataSetChanged()
    }
}