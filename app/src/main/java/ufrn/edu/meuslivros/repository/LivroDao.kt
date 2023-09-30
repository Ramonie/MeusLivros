package ufrn.edu.meuslivros.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import ufrn.edu.meuslivros.model.Livro


    @Dao
    interface LivroDao {

        @Insert
        fun inserirUnicoCarro(Livro1: Livro): Long
        @Insert
        fun inserir(Livro1: Livro)

        @Update
        fun atualiza(Livro1: Livro)

        @Delete
        fun removerCarro(Livro1: Livro)

    }