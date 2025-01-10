package com.example.imdbookstore.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbookstore.databinding.ItemLivroBinding
import com.example.imdbookstore.models.Livro

class LivroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemLivroBinding.bind(view)

    fun render(livro: Livro, onClickListener: (Livro) -> Unit) {
        binding.tvTituloLivro.text = livro.titulo
        binding.tvEditoraLivro.text = livro.editora
        binding.tvIsbnLivro.text = livro.isbn.toString()
        Glide.with(binding.ivLivro.context).load(livro.urlImagemLivro).into(binding.ivLivro)

        itemView.setOnClickListener {
            onClickListener(livro)
        }
    }
}