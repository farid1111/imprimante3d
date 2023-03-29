package fr.mounir.imprimante3d.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import fr.mounir.imprimante3d.MainActivity
import fr.mounir.imprimante3d.R

class AddFormFragment(
    private val context: MainActivity
) : Fragment() {

    private var uploadImage:ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_forms, container, false)

        uploadImage = view.findViewById(R.id.preview_image)

        //récupérer le bouton pour charger l image
        val pickupImageButton = view.findViewById<Button>(R.id.upload_button)

        //lorsqu'on clique dessus ça ouvre les images du telephone
        pickupImageButton.setOnClickListener { pickupImage() }

        return view
    }
    private fun pickupImage() {
        val intent = Intent()
        intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select picture"), 47)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 47 && resultCode == Activity.RESULT_OK){

            if(data == null || data.data == null) return

            val selectedImage = data.data

            uploadImage?.setImageURI(selectedImage)


        }
    }
}