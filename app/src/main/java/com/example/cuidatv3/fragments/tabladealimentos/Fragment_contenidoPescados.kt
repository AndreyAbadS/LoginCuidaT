package com.example.cuidatv3.fragments.tabladealimentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cuidatv3.Adaptadores.CarnesAdapter
import com.example.cuidatv3.Lists.CarnesList
import com.example.cuidatv3.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.fragment_contenido_pescados.*
import kotlinx.android.synthetic.main.fragment_contenido_pollo.*

class fragment_contenidoPescados : Fragment(R.layout.fragment_contenido_pescados) {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("Pescado")
    var carnesAdapter: CarnesAdapter?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
    }
    private fun setupRecyclerview() {
        val query: Query = collectionReference
        val firestoreRecyclerOptions: FirestoreRecyclerOptions<CarnesList> = FirestoreRecyclerOptions.Builder<CarnesList>()
                .setQuery(query, CarnesList::class.java)
                .build()

        carnesAdapter = CarnesAdapter(firestoreRecyclerOptions)

        recyclerView_pescado.layoutManager = LinearLayoutManager(context)
        recyclerView_pescado.adapter = carnesAdapter
    }

    override fun onStart() {
        super.onStart()
        carnesAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        carnesAdapter!!.stopListening()
    }
}