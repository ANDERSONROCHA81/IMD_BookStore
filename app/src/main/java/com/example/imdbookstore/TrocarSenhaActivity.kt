package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.databinding.ActivityTrocarSenhaBinding

class TrocarSenhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrocarSenhaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTrocarSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMudarSenha.setOnClickListener {
            val telaLogin = Intent(this, LoginActivity::class.java)
            startActivity(telaLogin)
        }
    }
}