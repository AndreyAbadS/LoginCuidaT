package com.example.cuidatv3.fragments.tabladealimentos
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cuidatv3.R
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.fragment__tabla_de_alimentos.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Fragment_TablaDeAlimentos : Fragment(R.layout.fragment__tabla_de_alimentos) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Funciones para que cuando el usuario pulse las imagenes los lleve a los sub-menus
        Cardview_Frutas.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_TablaDeAlimentos_to_fragment_contenidoFrutas)
        }

        Cardview_Carnes.setOnClickListener {
           findNavController().navigate(R.id.action_fragment_TablaDeAlimentos_to_fragment_MenuCarnes)
        }

        Cardview_Verduras.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_TablaDeAlimentos_to_fragment_contenidoVerduras)
        }

    }
}