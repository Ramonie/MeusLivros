package ufrn.edu.meuslivros

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ufrn.edu.meuslivros.database.AppDatabase
import ufrn.edu.meuslivros.model.Livro
import ufrn.edu.meuslivros.repository.LivroRepository
import java.lang.Exception

class LivroViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : LivroRepository

    private var _livros = MutableLiveData<List<Livro>>()
    var livros : LiveData<List<Livro>> = _livros

    private var _livroCadastroEvent = MutableLiveData<Boolean>()
    var livroCadastroEvent : LiveData<Boolean> = _livroCadastroEvent



    private val _livro = MutableLiveData<Livro>()
    val livro : LiveData<Livro>
        get() = _livro


    init {
       val livroDao = AppDatabase.getDatabase(application).livroDao()
        repository = LivroRepository(livroDao)
        _livro.value = Livro("", "", 0.0f, 0)
        getAll()
    }


    fun getAll(){
        viewModelScope.launch(Dispatchers.IO) {
            _livros.postValue(repository.getAll())
        }

    }
    private var livroIndex = 0

    fun exibirLivroAtual() {
        if (_livros.value.isNullOrEmpty()) return 
        _livro.value = _livros.value!![livroIndex]
    }

    fun exibirProximo() {
        if (_livros.value.isNullOrEmpty()) return
        livroIndex = (livroIndex + 1) % _livros.value!!.size
        _livro.value = _livros.value!![livroIndex]
    }

    fun exibirAnterior() {
        if (_livros.value.isNullOrEmpty()) return

        livroIndex = if (livroIndex > 0) livroIndex - 1 else _livros.value!!.size - 1
        _livro.value = _livros.value!![livroIndex]
    }


     fun addLivro(){
         viewModelScope.launch(Dispatchers.IO) {
             try {
                 repository.addLivro(livro.value!!)
                 _livroCadastroEvent.postValue(true)
             }catch (e: Exception){
                 _livroCadastroEvent.postValue(false)
             }

         }
    }

}