package com.example.cuidatv3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cuidatv3.R
import kotlinx.android.synthetic.main.fragment__ejercicio_pierna_menu.*
import kotlinx.android.synthetic.main.fragment__ejercicios_brazo_menu.*

// TODO: Rename parameter arguments, choose names that match

class fragment_EjerciciosBrazoMenu : Fragment(R.layout.fragment__ejercicios_brazo_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardview_bicep.setOnClickListener {
            //findNavController().navigate()
        }

        cardview_hombro.setOnClickListener {
            //findNavController().navigate()
        }

        cardview_tricep.setOnClickListener {
            //findNavController().navigate()
        }

        cardview_hombro.setOnClickListener{
            //findNavController().navigate()
        }
    }
}