package fr.mounir.imprimante3d.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.mounir.imprimante3d.FormModel
import fr.mounir.imprimante3d.FormRepository.Singleton.formList
import fr.mounir.imprimante3d.MainActivity
import fr.mounir.imprimante3d.R
import fr.mounir.imprimante3d.adapter.FormAdapter
import fr.mounir.imprimante3d.adapter.FormItemDecoration

class HomeFragment(

    private val context : MainActivity
) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // récupérer le recyclerview

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = FormAdapter(context, formList, R.layout.item_horizontal_form)

        // récupérer le recyclerview
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = FormAdapter(context, formList, R.layout.item_vertical_form)
        verticalRecyclerView.addItemDecoration(FormItemDecoration())


        return view
    }
}