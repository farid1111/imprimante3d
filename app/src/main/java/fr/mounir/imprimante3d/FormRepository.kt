package fr.mounir.imprimante3d

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.mounir.imprimante3d.FormRepository.Singleton.databaseRef
import fr.mounir.imprimante3d.FormRepository.Singleton.formList


class FormRepository {

    object Singleton {
        // se connecter a la référence formes
        val databaseRef = FirebaseDatabase.getInstance().getReference("forms")

        // creer une liste pour contenir les formes
        val formList = arrayListOf<FormModel>()
    }

    fun  updateData(callback: () -> Unit) {
        //absorber les données depuis la dataaseRef -> listes de formes
        databaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                //retirer les anciennes formes
                formList.clear()
                //récolter la liste
                for (ds in snapshot.children){
                    //construire un object forme
                    val form = ds.getValue(FormModel::class.java)
                    //vérifier que la forme n'est pas null
                    if (form != null){
                        //ajouter la forme à notre liste
                        formList.add(form)
                    }
                }
                //actionner le callback
                callback()
            }

            override fun onCancelled(error: DatabaseError) {}

        })
    }
    //mettre a jour l'objet forme en bdd
    fun updateForm(form : FormModel) = databaseRef.child(form.id).setValue(form)



}