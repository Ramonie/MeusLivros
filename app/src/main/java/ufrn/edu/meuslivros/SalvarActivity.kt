package ufrn.edu.meuslivros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
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

        var livro : Livro = Livro()
        livro.ano = binding.editTextano.text.toString().toInt()
    }
}