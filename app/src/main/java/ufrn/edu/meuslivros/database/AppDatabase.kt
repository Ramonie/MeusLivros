package ufrn.edu.meuslivros.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ufrn.edu.meuslivros.model.Livro
import ufrn.edu.meuslivros.repository.LivroDao

@Database(entities = [Livro::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun livroDao():LivroDao
}