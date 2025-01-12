package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.bd.BancoDeDados
import com.example.imdbookstore.databinding.ActivityExclusaoDeLivrosBinding

class ExclusaoDeLivrosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExclusaoDeLivrosBinding
    private lateinit var bancoDeDados: BancoDeDados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bancoDeDados = BancoDeDados(this)
        enableEdgeToEdge()
        binding = ActivityExclusaoDeLivrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExcluirLivro.setOnClickListener {
            var isbn = binding.etISBN3.text.toString()

            if (isbn.isNotEmpty()) {
                var livro = bancoDeDados.findByIsbn(isbn.toInt())

                if (isbn == livro.isbn.toString()) {
                    bancoDeDados.delete(isbn.toInt())
                    binding.etISBN3.setText(getString(R.string.campo_vazio))
                    Toast.makeText(this, "Livro excluído com sucesso", Toast.LENGTH_LONG).show()
                    val telaMenu = Intent(this, MenuActivity::class.java)
                    startActivity(telaMenu)
                } else {
                    Toast.makeText(this, "Livro não encontrado", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Informe o ISBN do livro", Toast.LENGTH_LONG).show()
            }
        }
    }
}