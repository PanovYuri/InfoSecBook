package com.example.infosecbook

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_test.*
import java.io.IOException

class TestActivity : AppCompatActivity() {
    lateinit var test:List<Test>
    var qPos:Int = 0
    val answers = arrayListOf<ArrayList<Boolean>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        test = Gson().fromJson(getStringFromAssets(), Array<Test>::class.java).toList()
        setNextQuest()
        qPos++

        add_answer_btn.setOnClickListener {
            answers.add(arrayListOf(
                ans_1.isChecked,
                ans_2.isChecked,
                ans_3.isChecked)
            )
            if (qPos + 1 == 6) {
                Toast.makeText(this,
                    "" + getResultTest(), Toast.LENGTH_SHORT).show()
            } else {
                setNextQuest()
                qPos++
            }
        }
    }

    private fun setNextQuest() {
        val nowQ = test[qPos]
        title_test_actvity.text = nowQ.title

        ans_1.text = nowQ.questions[0].text
        ans_2.text = nowQ.questions[1].text
        ans_3.text = nowQ.questions[2].text

        ans_1.isChecked = false
        ans_2.isChecked = false
        ans_3.isChecked = false
    }

    private fun getResultTest():Int {
        var countResult = 0
        val arrOfTrue = arrayListOf<ArrayList<Boolean>>()
        for (i in 0 until 5) {
            val arr = arrayListOf<Boolean>()
            test[i].questions.forEach { el ->
                arr.add(el.is_true)
            }
            arrOfTrue.add(arr)
        }

        for (i in 0 until 5) {
            if (equelsArray(answers[i], arrOfTrue[i]))
                countResult++
        }

        return countResult
    }

    private fun equelsArray(arr1: ArrayList<Boolean>, arr2:ArrayList<Boolean>):Boolean {
        for (i in arr1.indices) {
            if (arr1[i] != arr2[i])
                return false
        }

        return true
    }

    private fun getStringFromAssets(): String {
        var json: String? = null
        try {
            val inputStream = assets.open("test.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            json = String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return json!!.trimIndent()
    }

    data class Test(val title:String, val questions:ArrayList<Question>)
    data class Question(val text:String, val is_true:Boolean)
}
