package com.example.cuidatv3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.cuidatv3.databinding.ActivityMainBinding
import com.example.cuidatv3.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity__cuerpo.*
import kotlinx.android.synthetic.main.fragment__tabla_de_alimentos.*

class Activity_Cuerpo : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity__cuerpo)
        val bottomnavigationview = findViewById<BottomNavigationView>(R.id.Buttom_navigationBar) //agregar el valor del boton de navegacion
        val navController = findNavController(R.id.fragment_container) //asignar el fragmento de navegacion
        bottomnavigationview.setupWithNavController(navController)

    }
}