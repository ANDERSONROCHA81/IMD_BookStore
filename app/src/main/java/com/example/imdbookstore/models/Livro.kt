package com.example.imdbookstore.models

data class Livro(
    var titulo: String,
    var autor: String,
    var editora: String,
    var isbn: Int,
    var descricao: String,
    var urlImagemLivro: String
)
