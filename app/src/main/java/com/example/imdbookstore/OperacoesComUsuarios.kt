package com.example.imdbookstore

import android.content.Context

object OperacoesComUsuarios {

    fun salvarUsuario(context: Context, senha: String, nomeUsuario: String) {
        val sharedPreferences = context.getSharedPreferences("Usuarios", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(nomeUsuario, senha)
        editor.apply()
    }

    fun recuperarUsuario(context: Context, nomeUsuario: String): String {
        val sheredPreferences = context.getSharedPreferences("Usuarios", Context.MODE_PRIVATE)
        val usuario = sheredPreferences.getString(nomeUsuario, null)
        return usuario.toString()
    }

    fun excluirUsuario(context: Context, nomeUsuario: String) {
        val sharedPreferences = context.getSharedPreferences("Usuarios", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove(nomeUsuario)
        editor.apply()
    }
}