package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imdbookstore.adapter.LivroAdapter
import com.example.imdbookstore.bd.BancoDeDados
import com.example.imdbookstore.databinding.ActivityListagemDeLivrosBinding
import com.example.imdbookstore.models.Livro

class ListagemDeLivrosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListagemDeLivrosBinding
    private lateinit var bancoDeDados: BancoDeDados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bancoDeDados = BancoDeDados(this)
        enableEdgeToEdge()
        binding = ActivityListagemDeLivrosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = binding.rvLivros
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter =
            LivroAdapter(bancoDeDados.listAll()) { livro -> onItemSelected(livro) }

        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)
    }

    fun onItemSelected(livro: Livro) {
        val telaInformacoes = Intent(this, DetalhamentoDoLivroActivity::class.java)
        telaInformacoes.putExtra("titulo", livro.titulo)
        telaInformacoes.putExtra("autor", livro.autor)
        telaInformacoes.putExtra("editora", livro.editora)
        telaInformacoes.putExtra("isbn", livro.isbn)
        telaInformacoes.putExtra("descricao", livro.descricao)
        telaInformacoes.putExtra("imagem", livro.urlImagemLivro)
        startActivity(telaInformacoes)
    }
}