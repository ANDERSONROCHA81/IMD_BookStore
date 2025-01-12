package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.imdbookstore.databinding.ActivityDetalhamentoDoLivroBinding

class DetalhamentoDoLivroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhamentoDoLivroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetalhamentoDoLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var informacoes = intent.extras
        var titulo = informacoes?.getString("titulo")
        var autor = informacoes?.getString("autor")
        var editora = informacoes?.getString("editora")
        var isbn = informacoes?.getInt("isbn")
        var descricao = informacoes?.getString("descricao")
        var imagem = informacoes?.getString("imagem")

        binding.tvInfoTitulo2.text = titulo
        binding.tvInfoAutor2.text = autor
        binding.tvInfoEditora2.text = editora
        binding.tvInfoISBN2.text = isbn.toString()
        binding.tvInfoDescricao2.text = descricao
        Glide.with(binding.ivInfoCapa.context).load(imagem).into(binding.ivInfoCapa)

        binding.btnVoltarLivros.setOnClickListener {
            val telaListagem = Intent(this, ListagemDeLivrosActivity::class.java)
            startActivity(telaListagem)
        }
    }
}