package ufrn.edu.meuslivros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ufrn.edu.meuslivros.databinding.ActivityListarLivroBinding
import ufrn.edu.meuslivros.databinding.ActivitySalvarBinding

class ListarLivroActivity : AppCompatActivity() {
    lateinit var binding : ActivityListarLivroBinding
    lateinit var viewModel: LivroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_livro)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_listar_livro)
        viewModel = ViewModelProvider(this).get(LivroViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.livro.observe(this, Observer {
            binding.textViewTitle.text = it.titulo
            binding.textViewAutor.text = it.autor
            binding.textViewAno.text = it.ano.toString()
            binding.textViewNota.text = it.nota.toString()
        })

        viewModel.exibirLivroAtual()

        binding.buttonAnterior.setOnClickListener {
            viewModel.exibirAnterior()
        }

        binding.buttonProximo.setOnClickListener {
            viewModel.exibirProximo()
        }

    }
}