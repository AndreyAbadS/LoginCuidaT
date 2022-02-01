package com.example.cuidatv3.fragments.tabladealimentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cuidatv3.Adaptadores.ComidaAdapter
import com.example.cuidatv3.Adaptadores.EjercicioAdapter
import com.example.cuidatv3.EjerciciosLis
import com.example.cuidatv3.Lists.ComidaList
import com.example.cuidatv3.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.fragment__content_ejer.*
import kotlinx.android.synthetic.main.fragment_contenido_frutas.*

class fragment_contenidoFrutas : Fragment(R.layout.fragment_contenido_frutas) {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("Frutas")
    var comidaAdapter: ComidaAdapter?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        val query: Query = collectionReference
        val firestoreRecyclerOptions: FirestoreRecyclerOptions<ComidaList> = FirestoreRecyclerOptions.Builder<ComidaList>()
                .setQuery(query, ComidaList::class.java)
                .build()

        comidaAdapter = ComidaAdapter(firestoreRecyclerOptions)

        recyclerView_Frutas.layoutManager = LinearLayoutManager(context)
        recyclerView_Frutas.adapter = comidaAdapter
    }

    override fun onStart() {
        super.onStart()
        comidaAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        comidaAdapter!!.stopListening()
    }
}