package com.example.cuidatv3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.cuidatv3.R
import kotlinx.android.synthetic.main.fragment__calculadoras.*

class Fragment_Calculadoras : Fragment(R.layout.fragment__calculadoras) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner: Spinner = spinner_alimentos
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.Comidasfrutas,
            android.R.layout.simple_spinner_item).also{adapter->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }
}