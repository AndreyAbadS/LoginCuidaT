package com.example.cuidatv3.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cuidatv3.EjerciciosLis
import com.example.cuidatv3.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.item_row.view.*

class EjercicioAdapter(options: FirestoreRecyclerOptions<EjerciciosLis>) :
    FirestoreRecyclerAdapter<EjerciciosLis, EjercicioAdapter.EjercicioAdapterVH>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjercicioAdapterVH {
        return EjercicioAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false))
    }

    override fun onBindViewHolder(holder: EjercicioAdapterVH, position: Int, model: EjerciciosLis) {
        holder.bindview(model)
    }

    class EjercicioAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindview(ejercicio: EjerciciosLis){
            Glide.with(this.itemView).asGif().load(ejercicio.imageUrl).into(itemView.ImaV_FotoEjercicio)
            itemView.Tv_NomEjer.text = ejercicio.titulo
            itemView.Tv_DescripEjer1.text = ejercicio.descripcion1
            itemView.Tv_DescripEjer2.text = ejercicio.descripcion2
            itemView.Tv_DescripEjer3.text = ejercicio.descripcion3
            itemView.Tv_repeticiones.text = ejercicio.repeticiones
        }

    }

}