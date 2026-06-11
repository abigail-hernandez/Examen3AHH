package com.example.examen3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen3.databinding.ActivityMainBinding
import com.example.examen3.model.Usuario

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = MyApplication.getDatabase(this)
        val repository = UsuarioRepository(db.usuarioDao())
        viewModel = UsuarioViewModel(repository)

    }
}