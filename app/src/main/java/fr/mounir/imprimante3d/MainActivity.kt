package fr.mounir.imprimante3d

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.mounir.imprimante3d.fragments.AddFormFragment
import fr.mounir.imprimante3d.fragments.FormsFragment
import fr.mounir.imprimante3d.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment(this),R.string.home_page_title)

        //importer le bootmNavigationView
        val navigationView = findViewById<BottomNavigationView>(R.id.navigation_view)
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_page -> {
                    loadFragment(HomeFragment(this), R.string.home_page_title)
                    return@setOnNavigationItemSelectedListener true

                }
                R.id.form_page -> {
                    loadFragment(FormsFragment(this), R.string.form_page_title)
                    return@setOnNavigationItemSelectedListener true

                }
                R.id.add_form_page -> {
                    loadFragment(AddFormFragment(this), R.string.add_form_page_title)
                    return@setOnNavigationItemSelectedListener true

                }

                else -> false

            }

        }
    }

    private fun loadFragment(fragment: Fragment, string: Int) {
        //charger notre Repository
        val repo = FormRepository()

        //actualiser le titre de la page
        findViewById<TextView>(R.id.page_title).text = resources.getString(string)

        //mettre à jour la liste de formes
        repo.updateData{
            // injecter le fragment dans notre boite (fragment_container)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}