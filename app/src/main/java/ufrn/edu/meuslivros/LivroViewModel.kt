package ufrn.edu.meuslivros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ufrn.edu.meuslivros.model.Livro

class LivroViewModel : ViewModel() {
    private var _livros = MutableLiveData<List<Livro>>()
    var livros : LiveData<List<Livro>> = _livros

    private var _livro = MutableLiveData<Livro>()
    var livro : LiveData<Livro> = _livro

    fun changeLivro(livro: Livro){
        _livro.value = livro
    }

    fun addLivro(livro: Livro){
        val listLivro = _livros.value?.toMutableList() ?: mutableListOf()
        listLivro.add(livro)
        _livros.value = listLivro
    }

}