package com.example.cuidatv3.fragments.Calculadoras

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.cuidatv3.R
import com.google.common.primitives.UnsignedBytes.toInt
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment__calculadoras.*
import kotlin.math.log

class Fragment_Calculadoras : Fragment(R.layout.fragment__calculadoras) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ArrayToSpinners(spinner_alimentos)
        btn_calcularIMC.setOnClickListener{
            CalcularIMC()
            verificar()
        }
    }

    fun CalcularIMC(){
        val Peso =  pesoKg_et.text.toString().toDouble()
        val Altura = alturaCm_et.text.toString().toDouble()
        val AlturaCuadra = Math.pow(Altura,2.0)
        val total = Peso * AlturaCuadra
        //tv_IMC.setText(total.toString())
    }

    fun verificar(){
        if (pesoKg_et.text.toString().isEmpty()){
            pesoKg_et.error = "Porfavor intruduce un dato en el campo"
            pesoKg_et.requestFocus()
            return
        }

        if (alturaCm_et.text.toString().isEmpty()){
            alturaCm_et.error = "Porfavor introduce un dato en el campo"
            alturaCm_et.requestFocus()
            return
        }
    }


    fun ArrayToSpinners(spinner:Spinner){
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.ComidasVerduras,
            android.R.layout.simple_spinner_item).also{adapter->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinner.adapter = adapter
        }
    }
}