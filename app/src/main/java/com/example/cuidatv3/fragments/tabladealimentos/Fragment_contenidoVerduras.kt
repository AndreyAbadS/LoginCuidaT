package com.example.cuidatv3.fragments.tabladealimentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cuidatv3.Adaptadores.ComidaAdapter
import com.example.cuidatv3.Adaptadores.ComidaVerduraAdapter
import com.example.cuidatv3.Lists.ComidaList
import com.example.cuidatv3.Lists.VerdurasList
import com.example.cuidatv3.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.fragment_contenido_frutas.*
import kotlinx.android.synthetic.main.fragment_contenido_verduras.*

class fragment_contenidoVerduras : Fragment(R.layout.fragment_contenido_verduras) {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("Verduras")
    var comidaVerduraAdapter: ComidaVerduraAdapter?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
    }
    private fun setupRecyclerview() {
        val query: Query = collectionReference
        val firestoreRecyclerOptions: FirestoreRecyclerOptions<VerdurasList> = FirestoreRecyclerOptions.Builder<VerdurasList>()
                .setQuery(query, VerdurasList::class.java)
                .build()

        comidaVerduraAdapter = ComidaVerduraAdapter(firestoreRecyclerOptions)

        recyclerView_verduras.layoutManager = LinearLayoutManager(context)
        recyclerView_verduras.adapter = comidaVerduraAdapter
    }

    override fun onStart() {
        super.onStart()
        comidaVerduraAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        comidaVerduraAdapter!!.stopListening()
    }
}