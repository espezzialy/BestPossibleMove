package com.example.bestpossiblemove.ui

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.bestpossiblemove.R
import com.example.bestpossiblemove.infra.Word
import com.example.bestpossiblemove.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var results = listOf<String>()
    var resultsPoints = listOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)
        setTitle("Monta Palavras")

    }

    override fun onClick(v: View) {
        val text = Word().treatText(edit_text.text.toString())
        if (text.length in 1..15) {
            prepareScreen()
            results = Mock().checkAllLibo(text)
            setAnswers(results, text)
        } else {
            Toast.makeText(applicationContext, "Somente de 1 a  15 letras", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAnswers(results: List<String>, text: String) {
        if (!results.isEmpty()) {
            resultsPoints = Word().calcPointsResult(results)
            val indexCorrect = resultsPoints.indexOf(resultsPoints.max())
            val textResult = results.elementAt(indexCorrect)
            val textLeftOver = Word().textLeftOver(text, textResult)
            val textPoints = getString(R.string.palavra_de_d_pontos, resultsPoints.max())
            texto_pontuacao.text = textPoints
            showResult(textResult, result_layout)
            showResult(textLeftOver, leftover_layout)
        } else {
            texto_pontuacao.text = getString(R.string.palavra_de_d_pontos, 0)
            showResult(text, leftover_layout)
        }
    }

    private fun showResult(textResult: String, layout: LinearLayout) {
        for (c in textResult) {
            val button: Button = Button(this)
            if (textResult.length > 7) {
                button.layoutParams = (LinearLayout.LayoutParams(30.dp, 30.dp))
                button.textSize = 8f
            } else button.layoutParams = (LinearLayout.LayoutParams(48.dp, 48.dp))

            button.text = c.toString()
            button.setTextColor(resources.getColor(R.color.black))
            button.isEnabled = false
            layout.addView(button)
        }
    }

    private fun prepareScreen() {
        tip_text.visibility = View.GONE
        result_view.visibility = View.VISIBLE
        result_layout.removeAllViews()
        leftover_layout.removeAllViews()
    }
}

