package com.example.imdbookstore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbookstore.R
import com.example.imdbookstore.models.Livro

class LivroAdapter(private val listaDeLivros: List<Livro>) : RecyclerView.Adapter<LivroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LivroViewHolder(layoutInflater.inflate(R.layout.item_livro, parent, false))
    }

    override fun getItemCount(): Int {
        return listaDeLivros.size
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val item = listaDeLivros[position]
        holder.render(item)
    }
}