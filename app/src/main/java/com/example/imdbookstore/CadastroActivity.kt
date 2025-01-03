package com.example.imdbookstore

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCriarConta.setOnClickListener {
            var nome = binding.etNome.text.toString()
            var senha = binding.etSenha.text.toString()

            if (nome.isNotEmpty() && senha.isNotEmpty()) {
                salvarUsuario(this, senha, nome)
                Toast.makeText(this, "Cadastro feito com sucesso", Toast.LENGTH_LONG).show()
                val telaLogin = Intent(this, LoginActivity::class.java)
                startActivity(telaLogin)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun salvarUsuario(context: Context, senha: String, nomeUsuario: String) {
        val sharedPreferences = context.getSharedPreferences("Usuarios", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(senha, nomeUsuario)
        editor.apply()
    }
}