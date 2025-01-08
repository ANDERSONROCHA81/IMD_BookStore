package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.bd.BancoDeDados
import com.example.imdbookstore.databinding.ActivityAlteracaoDeLivroBinding

class AlteracaoDeLivroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlteracaoDeLivroBinding
    private lateinit var bancoDeDados: BancoDeDados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bancoDeDados = BancoDeDados(this)
        enableEdgeToEdge()
        binding = ActivityAlteracaoDeLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAtualizarLivro.setOnClickListener {
            var titulo = binding.etTitulo2.text.toString()
            var autor = binding.etAutor2.text.toString()
            var editora = binding.etEditora2.text.toString()
            var isbn = binding.etISBN2.text.toString()
            var descricao = binding.etDescricao2.text.toString()
            var url = binding.etURL2.text.toString()
            var livro = bancoDeDados.findByIsbn(isbn.toInt())

            if (titulo.isNotEmpty() && autor.isNotEmpty() && editora.isNotEmpty()
                && isbn.isNotEmpty() && descricao.isNotEmpty() && url.isNotEmpty()
            ) {
                if (livro.isbn == isbn.toInt()) {
                    bancoDeDados.update(isbn.toInt(), titulo, autor, editora, descricao, url)
                    binding.etTitulo2.setText(getString(R.string.campo_vazio))
                    binding.etAutor2.setText(getString(R.string.campo_vazio))
                    binding.etEditora2.setText(getString(R.string.campo_vazio))
                    binding.etISBN2.setText(getString(R.string.campo_vazio))
                    binding.etDescricao2.setText(getString(R.string.campo_vazio))
                    binding.etURL2.setText(getString(R.string.campo_vazio))
                    Toast.makeText(this, "Livro alterado com sucesso", Toast.LENGTH_LONG).show()
                    val telaMenu = Intent(this, MenuActivity::class.java)
                    startActivity(telaMenu)
                } else {
                    Toast.makeText(this, "Livro não encontrado", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}