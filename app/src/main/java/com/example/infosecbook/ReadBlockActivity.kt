package com.example.infosecbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_read_block.*

class ReadBlockActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_block)

        fab.setOnClickListener {
            finish()
        }

        val listBooks = arrayListOf<String>(
            "1. Взлома мышек",
            "2. Взлом Компьютеров",
            "3. Методы обхода блокировок",
            "4. Уязвимости в сайтах",
            "5. Что такое ЭЦП",
            "6. Что такое ИБ",
            "7. Что такое Баг Хантинг",
            "8. Зачем нужны шифроваьщики",
            "9. Зачем я пишу каждую тему",
            "10.Я же мог все скопировать"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listBooks)
        listView.adapter = adapter
    }
}
