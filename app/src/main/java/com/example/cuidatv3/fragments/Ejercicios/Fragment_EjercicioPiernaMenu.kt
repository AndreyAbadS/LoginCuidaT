package com.example.cuidatv3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cuidatv3.R
import kotlinx.android.synthetic.main.fragment__ejercicio_pierna_menu.*

class fragment_EjercicioPiernaMenu : Fragment(R.layout.fragment__ejercicio_pierna_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardview_Cuadricep.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_EjercicioPiernaMenu_to_fragment_ContentEjer2)
        }
    }


}