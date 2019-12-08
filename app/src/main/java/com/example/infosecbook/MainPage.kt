package com.example.infosecbook

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_main_page.*
import kotlinx.android.synthetic.main.fragment_main_page.view.*


class MainPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_main_page, container, false)

        view.mainPage_button.setOnClickListener {
            var bundle = Bundle()
            val v: View = i_card
            val options: ActivityOptions
                    = ActivityOptions.makeSceneTransitionAnimation(
                this.activity,
                v,
                "card_img"
                )
            bundle = options.toBundle()
            val intent: Intent = Intent(this.activity, ReadBlockActivity::class.java)
            startActivity(intent, bundle)
        }

        view.favorite_icon.setOnClickListener {
            println("Change Image")
            view.favorite_icon.setImageResource(R.drawable.ic_favorite_black_24dp)
        }
        return view
    }
}
