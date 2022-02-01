package com.example.cuidatv3.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cuidatv3.Lists.ComidaList
import com.example.cuidatv3.Lists.VerdurasList
import com.example.cuidatv3.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.item_row2.view.*

class ComidaVerduraAdapter(options: FirestoreRecyclerOptions<VerdurasList>) : FirestoreRecyclerAdapter<VerdurasList, ComidaVerduraAdapter.ComidaVerduraAdapterVH>(
    options
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaVerduraAdapterVH {
        return ComidaVerduraAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.item_row3,parent,false))
    }

    override fun onBindViewHolder(holder: ComidaVerduraAdapterVH, position: Int, model: VerdurasList) {
        holder.bindview(model)
    }
    class ComidaVerduraAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindview(comidas: VerdurasList){
            Glide.with(this.itemView).load(comidas.imageUrl).into(itemView.ImaV_Comida)
            itemView.Tv_NomAlimento.text = comidas.nomAlimento
            itemView.Tv_CantidadSugerida.text = comidas.cantidadSugerida
            itemView.Tv_Unidad.text = comidas.unidad
            itemView.Tv_Energia.text = comidas.energia
            itemView.Tv_Proteina.text = comidas.proteina
            itemView.Tv_Fibra.text = comidas.fibra
            itemView.Tv_PesoNeto.text = comidas.pesoneto
        }
    }

}