package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnComecar.setOnClickListener {
            val telaCadastro = Intent(this, CadastroActivity::class.java)
            startActivity(telaCadastro)
        }

        binding.tvFazerLogin.setOnClickListener {
            val telaLogin = Intent(this, LoginActivity::class.java)
            startActivity(telaLogin)
        }

    }
}