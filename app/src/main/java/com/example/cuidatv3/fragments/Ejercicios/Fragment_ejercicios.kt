package com.example.cuidatv3.fragments.Ejercicios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cuidatv3.R
import kotlinx.android.synthetic.main.fragment_ejercicios.*


class fragment_ejercicios : Fragment(R.layout.fragment_ejercicios) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Cardview_Pierna.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_ejercicios_to_fragment_EjercicioPiernaMenu)
        }

        Cardview_brazo.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_ejercicios_to_fragment_EjerciciosBrazoMenu)
        }
    }
}