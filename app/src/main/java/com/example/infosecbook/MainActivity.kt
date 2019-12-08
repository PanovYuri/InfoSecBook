package com.example.infosecbook

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.SearchView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_main_page.*

class MainActivity : AppCompatActivity() {


    private val mainPageFragment: Fragment = MainPage()
    private val bookMarkPage: Fragment = BookMarkPage()
    private val settingsPage: Fragment = SettingsPage()
    private val fm = supportFragmentManager!!
    private var active: Fragment = mainPageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        replaceFragment(mainPageFragment)
        bottom_navigation.selectedItemId = R.id.bn_main
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.bn_main -> {
                    replaceFragment(mainPageFragment)
                    println("Main Page Open")
                    true
                }

                R.id.bn_bookmark -> {
                    replaceFragment(bookMarkPage)
                    println("BookMark Open")
                    true
                }

                R.id.bn_settins -> {
                    replaceFragment(settingsPage)
                    println("Settings Page Open")
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment:Fragment) =
        fm.beginTransaction()
            .replace(R.id.fragment_layout, fragment)
            .commit()
}
