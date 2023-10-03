package ufrn.edu.meuslivros

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ufrn.edu.meuslivros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnCadastra.setOnClickListener {
            val intent = Intent(this, SalvarActivity::class.java)
            startActivity(intent)
        }

        binding.btnListar.setOnClickListener {
            val intent = Intent(this, ListarLivroActivity::class.java)
            startActivity(intent)

        }

    }
}