package com.example.conexionserverpreguntasprioridad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.conexionserverpreguntasprioridad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var  adapter:PreguntasAdapter
    private val viewModel : MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        setContentView(binding.root)
        initObserver()
        viewModel.getPreguntas()
    }
    private fun initObserver() {
        viewModel.isVisible.observe(this) { isVisible ->
            if (isVisible) setVisible() else setGone()
        }


        viewModel.user.observe(this){
            //if( viewModel.user.value!=null)
            println(viewModel.user.value.toString())
                mostrarPersonas(viewModel.user.value!!)
        }
    }
    fun mostrarPersonas(user: User){
        adapter= PreguntasAdapter(user)
        binding.recyclerview.adapter=adapter
    }
    private fun setVisible(){
        binding.pbDownloading.visibility = View.VISIBLE
    }
    private fun setGone(){
        binding.pbDownloading.visibility = View.GONE
    }
}