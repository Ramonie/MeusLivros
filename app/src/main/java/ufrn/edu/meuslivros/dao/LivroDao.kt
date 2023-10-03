package ufrn.edu.meuslivros.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ufrn.edu.meuslivros.model.Livro

@Dao
interface LivroDao {

    @Insert
     fun insert(livro: Livro)

    @Query("SELECT * FROM Livro")
     fun getAll(): List<Livro>

}