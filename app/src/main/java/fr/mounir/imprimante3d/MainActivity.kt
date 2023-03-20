package fr.mounir.imprimante3d

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.mounir.imprimante3d.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //charger notre Repository
        val repo = FormRepository()

        //mettre à jour la liste de formes
        repo.updateData{
            // injecter le fragment dans notre boite (fragment_container)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}