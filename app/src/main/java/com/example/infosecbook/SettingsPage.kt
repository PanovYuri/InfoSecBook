package com.example.infosecbook

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_settings_page.*
import kotlinx.android.synthetic.main.fragment_settings_page.view.*


class SettingsPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings_page, container, false)
        view.openTest.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            startActivity(intent)
        }
        return view
    }

}
