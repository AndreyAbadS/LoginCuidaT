package com.example.cuidatv3.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cuidatv3.Lists.CarnesList
import com.example.cuidatv3.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.item_row4.view.*

class CarnesAdapter(options: FirestoreRecyclerOptions<CarnesList>) : FirestoreRecyclerAdapter<CarnesList, CarnesAdapter.CarnesAdapterVH>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarnesAdapterVH {
        return CarnesAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.item_row4,parent,false))
    }

    override fun onBindViewHolder(holder: CarnesAdapterVH, position: Int, model: CarnesList){
        holder.bindview(model)
    }

    class CarnesAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindview(carnescomida:CarnesList){
            Glide.with(this.itemView).load(carnescomida.imageUrl).into(itemView.ImaV_Comida)
            itemView.Tv_NomAlimento.text = carnescomida.nomAlimento
            itemView.Tv_CantidadSugerida.text = carnescomida.cantidadSugerida
            itemView.Tv_Unidad.text = carnescomida.unidad
            itemView.Tv_Energia.text = carnescomida.energia
            itemView.Tv_Proteina.text = carnescomida.proteina
            itemView.Tv_Colesterol.text = carnescomida.colesterol
            itemView.Tv_PesoNeto.text = carnescomida.pesoneto
            itemView.Tv_Sodio.text = carnescomida.sodio
        }
    }
}