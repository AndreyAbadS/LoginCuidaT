package com.example.cuidatv3.fragments.tabladealimentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cuidatv3.R
import kotlinx.android.synthetic.main.fragment__menu_carnes.*

class fragment_MenuCarnes : Fragment(R.layout.fragment__menu_carnes) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Cardview_Carnes2.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_MenuCarnes_to_fragment_contenidoCarnes)
        }

        Cardview_Pollo.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_MenuCarnes_to_fragment_contenidoPollo)
        }

        Cardview_pescados.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_MenuCarnes_to_fragment_contenidoPescados)
        }
    }
}