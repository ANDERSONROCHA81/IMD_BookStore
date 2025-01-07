package com.example.imdbookstore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imdbookstore.adapter.LivroAdapter
import com.example.imdbookstore.bd.BancoDeDados
import com.example.imdbookstore.databinding.ActivityListagemDeLivrosBinding

class ListagemDeLivrosActivity : AppCompatActivity() {

    lateinit var binding: ActivityListagemDeLivrosBinding
    lateinit var bancoDeDados: BancoDeDados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListagemDeLivrosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = binding.rvLivros
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LivroAdapter(bancoDeDados.listarTodosOsLivros())
    }
}