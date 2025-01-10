package com.example.imdbookstore.bd

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.imdbookstore.models.Livro

class BancoDeDados(contexto: Context) : SQLiteOpenHelper(contexto, NOME, null, VERSAO) {

    companion object {
        private const val NOME = "dblivraria"
        private const val VERSAO = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
                CREATE TABLE livros(
                isbn INTEGER PRIMARY KEY,
                titulo TEXT,
                autor TEXT,
                editora TEXT,
                descricao TEXT,
                urlImagemLivro TEXT
                )
            """
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun save(
        isbn: Int,
        titulo: String,
        autor: String,
        editora: String,
        descricao: String,
        urlImagemLivro: String
    ): Long {
        val banco = this.writableDatabase
        val container = ContentValues()
        container.put("isbn", isbn)
        container.put("titulo", titulo)
        container.put("autor", autor)
        container.put("editora", editora)
        container.put("descricao", descricao)
        container.put("urlImagemLivro", urlImagemLivro)
        var resultado = banco.insert("livros", null, container)
        banco.close()
        return resultado
    }

    fun listAll(): ArrayList<Livro> {
        val banco = this.readableDatabase
        var cursor = banco.rawQuery("SELECT * FROM livros", null)
        var array = ArrayList<Livro>()
        if (cursor.count > 0) {
            cursor.moveToFirst()
            do {
                var isbn = cursor.getInt(0)
                var titulo = cursor.getString(1)
                var autor = cursor.getString(2)
                var editora = cursor.getString(3)
                var descricao = cursor.getString(4)
                var urlImagemLivro = cursor.getString(5)
                array.add(Livro(titulo, autor, editora, isbn, descricao, urlImagemLivro))
            } while (cursor.moveToNext())
        }
        cursor.close()
        banco.close()
        return array
    }

    fun update(
        isbn: Int,
        titulo: String,
        autor: String,
        editora: String,
        descricao: String,
        urlImagemLivro: String
    ): Int {
        val banco = this.writableDatabase
        val container = ContentValues()
        container.put("isbn", isbn)
        container.put("titulo", titulo)
        container.put("autor", autor)
        container.put("editora", editora)
        container.put("descricao", descricao)
        container.put("urlImagemLivro", urlImagemLivro)
        var result = banco.update("livros", container, "isbn=$isbn", null)
        banco.close()
        return result
    }

    fun findByIsbn(isbn: Int): Livro {
        val banco = this.readableDatabase
        var cursor = banco.rawQuery("SELECT * FROM livros WHERE isbn=$isbn", null)
        var livro = Livro("", "", "", 0, "", "")
        if (cursor.count > 0) {
            cursor.moveToFirst()
            do {
                var titulo = cursor.getString(1)
                var autor = cursor.getString(2)
                var editora = cursor.getString(3)
                var descricao = cursor.getString(4)
                var urlImagemLivro = cursor.getString(5)
                livro = Livro(titulo, autor, editora, isbn, descricao, urlImagemLivro)
            } while (cursor.moveToNext())
        }
        cursor.close()
        banco.close()
        return livro;
    }

    fun delete(isbn: Int): Int {
        val banco = this.writableDatabase
        var resultado = banco.delete("livros", "isbn = $isbn", null)
        banco.close()
        return resultado
    }
}