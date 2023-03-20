package fr.mounir.imprimante3d.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.mounir.imprimante3d.FormModel
import fr.mounir.imprimante3d.MainActivity
import fr.mounir.imprimante3d.R

class FormAdapter(
    private val context: MainActivity,
    private val formList: ArrayList<FormModel>,
    private val layoutId: Int
    ) : RecyclerView.Adapter<FormAdapter.ViewHolder>(){

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){

        val formImage = view.findViewById<ImageView>(R.id.image_item)
        val formName:TextView? = view.findViewById(R.id.name_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = formList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentForms = formList[position]



        Glide.with(context).load(Uri.parse(currentForms.imageUrl)).into(holder.formImage)

        holder.formName?.text = currentForms.name

        if (currentForms.liked){
            holder.starIcon.setImageResource(R.drawable.ic_like)
        }
        else{
            holder.starIcon.setImageResource(R.drawable.ic_unlike)
        }

        //rajouter une interaction avec l'étoile
        holder.starIcon.setOnClickListener {
            //inverser si le bouton est like ou non
            currentForms.liked = !currentForms.liked
            //mettre a jour l'objet forme

        }
    }
}