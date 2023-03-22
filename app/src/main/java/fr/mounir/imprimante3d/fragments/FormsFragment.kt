package fr.mounir.imprimante3d.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.mounir.imprimante3d.FormModel
import fr.mounir.imprimante3d.FormRepository.Singleton.formList
import fr.mounir.imprimante3d.MainActivity
import fr.mounir.imprimante3d.R
import fr.mounir.imprimante3d.adapter.FormAdapter
import fr.mounir.imprimante3d.adapter.FormItemDecoration

class FormsFragment(
    private val context : MainActivity
)
    : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_forms, container, false)

        val formsRecyclerView = view.findViewById<RecyclerView>(R.id.forms_recycler_list)
        formsRecyclerView.adapter = FormAdapter(context, formList.filter { it.liked } as ArrayList<FormModel>, R.layout.item_vertical_form)
        formsRecyclerView.layoutManager = LinearLayoutManager(context)
        formsRecyclerView.addItemDecoration(FormItemDecoration())

        return view
    }
}