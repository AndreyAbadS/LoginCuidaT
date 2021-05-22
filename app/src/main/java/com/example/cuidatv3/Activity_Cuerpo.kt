package com.example.cuidatv3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.cuidatv3.databinding.ActivityMainBinding
import com.example.cuidatv3.fragments.*
import kotlinx.android.synthetic.main.activity__cuerpo.*
import kotlinx.android.synthetic.main.fragment__tabla_de_alimentos.*

class Activity_Cuerpo : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fragmentEjercicio = fragment_ejercicios()
    private val fragmentTabladealimentos = Fragment_TablaDeAlimentos()
    private val fragmentCalculadoras = Fragment_Calculadoras()
    private val fragmentContenidofrutas = fragment_contenidoFrutas()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity__cuerpo)
        replaceFragments(fragmentTabladealimentos)



        Buttom_navigationBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                    R.id.TablaAlimentos -> replaceFragments(fragmentTabladealimentos)
                    R.id.Ejercicios -> replaceFragments(fragmentEjercicio)
                    R.id.Calculadoras -> replaceFragments(fragmentCalculadoras)
            }
            true
        }

    }
    private fun replaceFragments(fragment:Fragment){
        if(fragment != null){
            val transtaction = supportFragmentManager.beginTransaction()
            transtaction.replace(R.id.fragment_container,fragment)
            transtaction.commit()
        }
    }
    private fun replacefragment2(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}