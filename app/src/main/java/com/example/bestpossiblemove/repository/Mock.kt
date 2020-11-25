package com.example.bestpossiblemove.repository

import com.example.bestpossiblemove.infra.Word


class Mock {
    private val mListOfAcceptableWords = listOf<String>("Abacaxi", "Manada", "mandar", "porta", "mesa", "Dado", "Mangas", "Já", "coisas", "radiografia",
            "matemática", "Drogas", "prédios", "implementação", "computador", "balão", "Xícara", "Tédio",
            "faixa", "Livro", "deixar", "superior", "Profissão", "Reunião", "Prédios", "Montanha", "Botânica",
            "Banheiro", "Caixas", "Xingamento", "Infestação", "Cupim", "Premiada", "empanada", "Ratos",
            "Ruído", "Antecedente", "Empresa", "Emissário", "Folga", "Fratura", "Goiaba", "Gratuito",
            "Hídrico", "Homem", "Jantar", "Jogos", "Montagem", "Manual", "Nuvem", "Neve", "Operação",
            "Ontem", "Pato", "Pé", "viagem", "Queijo", "Quarto", "Quintal", "Solto", "rota", "Selva",
            "Tatuagem", "Tigre", "Uva", "Último", "Vitupério", "Voltagem", "Zangado", "Zombaria", "Dor")

    private val treatedListOfAcceptableWords = Word().treatList(mListOfAcceptableWords)

    fun checkAllLibo(word: String): List<String> {
        val results = mutableListOf<String>()
        for (s in treatedListOfAcceptableWords) {
            if (Word().areSimilar(s.toLowerCase(), word)) {
                results.add(0, s)
            }
        }
        return results
    }
}
