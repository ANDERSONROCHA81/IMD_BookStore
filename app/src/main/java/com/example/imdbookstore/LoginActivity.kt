package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.OperacoesComUsuarios.recuperarUsuario
import com.example.imdbookstore.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            var nome = binding.etNome.text.toString()
            var senha = binding.etSenha.text.toString()
            var senhaUsuario = recuperarUsuario(this, nome)

            if (nome.isNotEmpty() && senha.isNotEmpty()) {
                if (senha == senhaUsuario) {
                    Toast.makeText(this, "Usuário logado com sucesso", Toast.LENGTH_LONG).show()
                    val telaMenu = Intent(this, MenuActivity::class.java)
                    startActivity(telaMenu)
                }else{
                    Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Informe o nome e a senha", Toast.LENGTH_LONG).show()
            }
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