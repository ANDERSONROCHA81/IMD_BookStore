package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

        }

        binding.tvEsqueceuSenha.setOnClickListener {
            val telaMudarSenha = Intent(this, TrocarSenhaActivity::class.java)
            startActivity(telaMudarSenha)
        }

        binding.btnCriarConta.setOnClickListener {
            val telaCadastro = Intent(this, CadastroActivity::class.java)
            startActivity(telaCadastro)
        }
    }
}