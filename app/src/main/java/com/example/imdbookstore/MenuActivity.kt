package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdbookstore.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCadastrar.setOnClickListener {
            val telaCadastro = Intent(this, CadastroDeLivrosActivity::class.java)
            startActivity(telaCadastro)
        }

        binding.tvListar.setOnClickListener {
            val telaListagem = Intent(this, ListagemDeLivrosActivity::class.java)
            startActivity(telaListagem)
        }

        binding.tvAtualizar.setOnClickListener {
            val telaAtualizacao = Intent(this, AlteracaoDeLivroActivity::class.java)
            startActivity(telaAtualizacao)
        }

        binding.tvExcluir.setOnClickListener {
            val telaExclusao = Intent(this, ExclusaoDeLivrosActivity::class.java)
            startActivity(telaExclusao)
        }
    }
}