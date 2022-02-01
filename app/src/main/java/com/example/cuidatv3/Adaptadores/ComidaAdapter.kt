package com.example.cuidatv3.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cuidatv3.EjerciciosLis
import com.example.cuidatv3.Lists.ComidaList
import com.example.cuidatv3.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.item_row.view.*
import kotlinx.android.synthetic.main.item_row2.view.*
//clase donde traemos la funcion FirestoreRecyclerOptions para llenarse con la lista y el ViewHolder
class ComidaAdapter(options: FirestoreRecyclerOptions<ComidaList>) : FirestoreRecyclerAdapter<ComidaList, ComidaAdapter.ComidaAdapterVH>(
    options
) {

    //Funcion donde se crea el viewHolder y se inflara la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaAdapterVH {
        return ComidaAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.item_row2,parent,false))
    }
    //Funcion donde se llenara el reciclerview
    override fun onBindViewHolder(holder: ComidaAdapterVH, position: Int, model: ComidaList) {
        holder.bindview(model)
    }

    //Clase donde se asigna los valores de la lista los que estan en la pantalla
    class ComidaAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindview(comidas:ComidaList){
            Glide.with(this.itemView).load(comidas.imageUrl).into(itemView.ImaV_Comida)
            itemView.Tv_NomAlimento.text = comidas.nomAlimento
            itemView.Tv_CantidadSugerida.text = comidas.cantidadSugerida
            itemView.Tv_Unidad.text = comidas.unidad
            itemView.Tv_Energia.text = comidas.energia
            itemView.Tv_Proteina.text = comidas.proteina
            itemView.Tv_Fibra.text = comidas.fibra
            itemView.Tv_PesoNeto.text = comidas.pesoneto
            itemView.Tv_Azucar.text = comidas.azucar
        }
    }
}