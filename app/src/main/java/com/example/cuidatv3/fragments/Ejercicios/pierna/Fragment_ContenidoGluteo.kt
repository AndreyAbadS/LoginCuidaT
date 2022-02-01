package com.example.cuidatv3.fragments.Ejercicios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cuidatv3.Adaptadores.EjercicioAdapter
import com.example.cuidatv3.EjerciciosLis
import com.example.cuidatv3.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.fragment__content_ejer.*

class fragment_ContenidoGluteo : Fragment(R.layout.fragment__contenido_gluteo) {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("EjerciciosPiernaGluteo")
    var ejercicioadapter: EjercicioAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        val query: Query = collectionReference
        val firestoreRecyclerOptions: FirestoreRecyclerOptions<EjerciciosLis> = FirestoreRecyclerOptions.Builder<EjerciciosLis>()
            .setQuery(query, EjerciciosLis::class.java)
            .build()

        ejercicioadapter = EjercicioAdapter(firestoreRecyclerOptions)

        recyclerView_Ejer.layoutManager = LinearLayoutManager(context)
        recyclerView_Ejer.adapter = ejercicioadapter
    }

    override fun onStart() {
        super.onStart()
        ejercicioadapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        ejercicioadapter!!.stopListening()
    }
}