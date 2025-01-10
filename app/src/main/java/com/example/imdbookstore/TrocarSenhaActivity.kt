package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.OperacoesComUsuarios.recuperarUsuario
import com.example.imdbookstore.OperacoesComUsuarios.salvarUsuario
import com.example.imdbookstore.databinding.ActivityTrocarSenhaBinding

class TrocarSenhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrocarSenhaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTrocarSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMudarSenha.setOnClickListener {
            var nome = binding.etNome.text.toString()
            var novaSenha = binding.etNovaSenha.text.toString()
            var senhaUsuario = recuperarUsuario(this, nome)

            if (nome.isNotEmpty() && novaSenha.isNotEmpty()) {
                if (senhaUsuario.isNotEmpty()) {
                    salvarUsuario(this, novaSenha, nome)
                    Toast.makeText(this, "Senha alterada com sucesso", Toast.LENGTH_LONG).show()
                    val telaLogin = Intent(this, LoginActivity::class.java)
                    startActivity(telaLogin)
                } else {
                    Toast.makeText(this, "Usuário inexistente", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Informe o nome e a nova senha", Toast.LENGTH_LONG).show()
            }
        }
    }
}