package com.example.imdbookstore.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbookstore.R
import com.example.imdbookstore.databinding.ItemLivroBinding
import com.example.imdbookstore.models.Livro

class LivroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemLivroBinding.bind(view)

//    val imagem = view.findViewById<ImageView>(R.id.ivLivro)
//    val titulo = view.findViewById<TextView>(R.id.tvTituloLivro)
//    val editora = view.findViewById<TextView>(R.id.tvEditoraLivro)
//    val autor = view.findViewById<TextView>(R.id.tvAutorLivro)

    fun render(livro: Livro){
//        titulo.text = livro.titulo
//        editora.text = livro.editora
//        autor.text = livro.autor
        binding.tvTituloLivro.text = livro.titulo
        binding.tvEditoraLivro.text = livro.editora
        binding.tvIsbnLivro.text = livro.isbn.toString()
        Glide.with(binding.ivLivro.context).load(livro.urlImagemLivro).into(binding.ivLivro)
    }
}