package ufrn.edu.meuslivros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import ufrn.edu.meuslivros.databinding.ActivitySalvarBinding
import ufrn.edu.meuslivros.model.Livro

class SalvarActivity : AppCompatActivity() {
   lateinit var binding : ActivitySalvarBinding
    lateinit var viewModel: LivroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salvar)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_salvar)
        viewModel = ViewModelProvider(this).get(LivroViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.livros.observe(this, Observer {
            Log.i("testeee", it.toString())
        })
        viewModel.livroCadastroEvent.observe(this, Observer {
            if (it){
                Snackbar.make(binding.btnSalvar, "Livro cadastrado com sucesso", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(binding.btnSalvar, "Erro ao cadastrar o livro", Snackbar.LENGTH_SHORT).show()
            }
        })


        binding.btnCancelar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        binding.btnSalvar.setOnClickListener {
            viewModel.addLivro()
        }
    }
}