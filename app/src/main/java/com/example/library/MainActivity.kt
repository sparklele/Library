package com.example.library

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.library.databinding.ActivityMainBinding
import com.example.library.ui.theme.LibraryTheme

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var books : MutableList<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        books = mutableListOf(
            Book(R.drawable.solitude,"One Hundred Years of Solitude","Gabriel Garcia Marqez",4.5f),
            Book(R.drawable.nostra,"Terra Nostra","Terra Nostra",3.0f),
            Book(R.drawable.angels,"Angels & Demons","Dan Brown",4.0f),
            Book(R.drawable.sword,"The Sword Thief","Peter Lerangis",2.0f),
            Book(R.drawable.inferno,"Inferno","Dan Brown",4.5f),
            Book(R.drawable.blood,"Bloodline","James Rollins",2.0f),
            Book(R.drawable.spirits,"The House of the Spirits","Isabel Allende",3.0f),
            Book(R.drawable.humming,"The Hummingbird's Daughter","Luis Alberto Urrea",3.5f)
        )


        val bookAdapter = MyAdapter(books)
        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = bookAdapter



        binding.topBarLT.topAppBar.setOnMenuItemClickListener{
            Toast.makeText(this,R.string.bell,Toast.LENGTH_SHORT).show()
            true
        }

        binding.topBarLT.topAppBar.setNavigationOnClickListener{
            binding.drawerLT.open()
        }

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.review -> {
                    Toast.makeText(this,R.string.review_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLT.close()
                    true
                }
                R.id.fav -> {
                    Toast.makeText(this,R.string.fav_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLT.close()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this,R.string.search_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLT.close()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this,R.string.profile_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLT.close()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this,R.string.settings_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLT.close()
                    true
                }
                else -> false
            }
        }

    }
}