package com.example.bestpossiblemove.infra

class Word {

    fun calcPointsResult(list: List<String>): MutableList<Int> {
        var resultpointslist = mutableListOf<Int>()
        for (s in list) {
            resultpointslist.add(calcPointsWord(s))
        }
        return resultpointslist
    }

    fun calcPointsWord(word: String): Int {
        var result = 0
        for (c in word) {
            result +=
                    calcPointsChar(c)
        }
        return result
    }

    fun calcPointsChar(char: Char): Int {
        return when {
            AppConstants.LETTERS_POINTS.onePoint.contains(char) -> 1
            AppConstants.LETTERS_POINTS.twoPoints.contains(char) -> 2
            AppConstants.LETTERS_POINTS.threePoints.contains(char) -> 3
            AppConstants.LETTERS_POINTS.fourPoints.contains(char) -> 4
            AppConstants.LETTERS_POINTS.eightPoints.contains(char) -> 8
            AppConstants.LETTERS_POINTS.tenPoints.contains(char) -> 10
            else -> 0
        }
    }

    fun textLeftOver(text: String, textResult: String): String {
        val result = text.replace(textResult.toRegex(), "")
        return result
    }

    fun treatList(list: List<String>): MutableList<String> {
        val listOut = mutableListOf<String>()
        for (s in list) {
            listOut.add(0, treatText(s))
        }
        return listOut
    }


    fun treatText(textIn: String): String {
        var textOut = textIn.toLowerCase()
        textOut = textOut.replace("\\s".toRegex(), "")
        for (c in textOut) {
            val charAux = treatSpecialLetter(c)
            val forOutput = textOut.replace(c, charAux, false)
            textOut = forOutput
        }
        return textOut
    }

    fun treatSpecialLetter(char: Char): Char {
        return when {
            AppConstants.SPECIAL_LETTERS.specialLettersA.contains(char) -> 'a'
            AppConstants.SPECIAL_LETTERS.specialLettersE.contains(char) -> 'e'
            AppConstants.SPECIAL_LETTERS.specialLettersI.contains(char) -> 'i'
            AppConstants.SPECIAL_LETTERS.specialLettersO.contains(char) -> 'o'
            AppConstants.SPECIAL_LETTERS.specialLettersU.contains(char) -> 'u'
            AppConstants.SPECIAL_LETTERS.specialLettersC.contains(char) -> 'c'
            else -> char
        }
    }


    fun areSimilar(one: String, two: String): Boolean {
        val map = HashMap<Char, Int>()
        val rest = mutableListOf<Char>()

        for (c in one.toCharArray())
            if (map.containsKey(c))
                map[c] = map[c]!! + 1
            else
                map[c] = 1

        for (c in two.toCharArray())
            if (!map.containsKey(c))
                rest.add(0, c)
            else {
                map[c] = map[c]!! - 1

                if (map[c] == 0)
                    map.remove(c)
            }
        return map.isEmpty()
    }

}