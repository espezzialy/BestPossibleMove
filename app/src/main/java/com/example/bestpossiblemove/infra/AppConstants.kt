package com.example.bestpossiblemove.infra

class AppConstants private constructor(){
    object SPECIAL_LETTERS {
        val specialLettersA = listOf('á', 'â', 'à', 'ã')
        val specialLettersE = listOf('é', 'è', 'ê')
        val specialLettersI = listOf('í', 'î', 'ì')
        val specialLettersO = listOf('ô', 'ó', 'ò', 'õ')
        val specialLettersU = listOf('ú', 'û', 'ù')
        val specialLettersC = listOf('ç')
    }

    object LETTERS_POINTS {
        val onePoint = listOf('e', 'a', 'i', 'o', 'n', 'r', 't', 'l', 's', 'u')
        val twoPoints = listOf('w', 'd', 'g')
        val threePoints = listOf('b', 'c', 'm', 'p')
        val fourPoints = listOf('f', 'h', 'v')
        val eightPoints = listOf('j', 'x')
        val tenPoints = listOf('q', 'z')
    }
}