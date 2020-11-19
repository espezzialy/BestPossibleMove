package com.example.bestpossiblemove

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var list = arrayListOf<String>("Abacaxi", "Manada", "mandar", "porta", "mesa", "Dado", "Mangas", "Já", "coisas", "radiografia",
        "matemática", "Drogas", "prédios", "implementação", "computador", "balão", "Xícara", "Tédio",
        "faixa", "Livro", "deixar", "superior", "Profissão", "Reunião", "Prédios", "Montanha", "Botânica",
        "Banheiro", "Caixas", "Xingamento", "Infestação", "Cupim", "Premiada", "empanada", "Ratos",
        "Ruído", "Antecedente", "Empresa", "Emissário", "Folga", "Fratura", "Goiaba", "Gratuito",
        "Hídrico", "Homem", "Jantar", "Jogos", "Montagem", "Manual", "Nuvem", "Neve", "Operação",
        "Ontem", "Pato", "Pé", "viagem", "Queijo", "Quarto", "Quintal", "Solto", "rota", "Selva",
        "Tatuagem", "Tigre", "Uva", "Último", "Vitupério", "Voltagem", "Zangado", "Zombaria", "Dor")

    var results = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)



    }

    override fun onClick(v: View) {
        val text = edit_text.text.toString()
        checkAllLibo(text)
    }

    private fun checkAllLibo(word: String) {
        for(s in list){
            if (areSimilar(s.toLowerCase(), word)) {
                results.add(0,s)
            }
        }
    }



    private fun areSimilar(one: String, two: String): Boolean {
        val map = HashMap<Char, Int>()
        val rest = mutableListOf<Char>()

        for (c in one.toCharArray())
            if (map.containsKey(c))
                map[c] = map[c]!! + 1
            else
                map[c] = 1

        for (c in two.toCharArray())
            if (!map.containsKey(c))
                rest.add(0,c)
            else {
                map[c] = map[c]!! - 1

                if (map[c] == 0)
                    map.remove(c)
            }
        return map.isEmpty()
    }




//    private fun areAnagrams(one: String, two: String): Boolean {
//        val map = HashMap<Char, Int>()
//        val rest = mutableListOf<Char>()
//
//        for (c in one.toCharArray())
//            if (map.containsKey(c))
//                map[c] = map[c]!! + 1
//            else
//                map[c] = 1
//
//        for (c in two.toCharArray())
//            if (!map.containsKey(c))
//                rest.add(0,c)
//            else {
//                map[c] = map[c]!! - 1
//
//                if (map[c] == 0)
//                    map.remove(c)
//            }
//        return map.isEmpty()
//    }
}