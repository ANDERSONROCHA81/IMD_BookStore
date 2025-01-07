package com.example.imdbookstore

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.bd.BancoDeDados
import com.example.imdbookstore.databinding.ActivityCadastroDeLivrosBinding

class CadastroDeLivrosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroDeLivrosBinding
    private lateinit var bancoDeDados: BancoDeDados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCadastroDeLivrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrarLivro.setOnClickListener {
            var titulo = binding.etTitulo.text.toString()
            var autor = binding.etAutor.text.toString()
            var editora = binding.etEditora.text.toString()
            var isbn = binding.etISBN.text.toString()
            var descricao = binding.etDescricao.text.toString()
            var url = binding.etURL.text.toString()

            if (titulo.isNotEmpty() && autor.isNotEmpty() && editora.isNotEmpty()
                && isbn.isNotEmpty() && descricao.isNotEmpty() && url.isNotEmpty()
            ) {
                bancoDeDados.salvarLivro(isbn.toInt(), titulo, autor, editora, descricao, url)
                Toast.makeText(this, "Livro cadastrado com sucesso", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}