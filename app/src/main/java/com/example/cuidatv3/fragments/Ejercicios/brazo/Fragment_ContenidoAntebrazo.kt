package com.example.cuidatv3.fragments.Ejercicios

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cuidatv3.Adaptadores.EjercicioAdapter
import com.example.cuidatv3.EjerciciosLis
import com.example.cuidatv3.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.fragment__content_ejer.*
import kotlinx.android.synthetic.main.item_row.*

class fragment_ContenidoAntebrazo : Fragment(R.layout.fragment__contenido_antebrazo) {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    var ejercicioadapter: EjercicioAdapter? = null
    var layoutExpandible = layout_expandible
    private val collectionReference: CollectionReference = db.collection("EjerciciosBrazoAntebrazo")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerview()

        /*tv_Expandible.setOnClickListener{
            if (layout_expandible.visibility==View.GONE){
                TransitionManager.beginDelayedTransition(cardview_Expandible,AutoTransition())
                layout_expandible.visibility = View.VISIBLE
                tv_Expandible.text = "Mostrar menos"
            }else {
                TransitionManager.beginDelayedTransition(cardview_Expandible,AutoTransition())
                layout_expandible.visibility = View.GONE
                tv_Expandible.text = "mostrar mas"}
        }*/

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