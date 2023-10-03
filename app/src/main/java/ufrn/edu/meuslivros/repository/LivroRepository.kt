package ufrn.edu.meuslivros.repository

import ufrn.edu.meuslivros.dao.LivroDao
import ufrn.edu.meuslivros.model.Livro

class LivroRepository(private val livroDao: LivroDao) {

     fun getAll(): List<Livro> {
        return livroDao.getAll()
    }

     fun addLivro(livro: Livro) {
        livroDao.insert(livro)
    }
}