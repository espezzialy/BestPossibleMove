package com.example.bestpossiblemove

import android.util.SparseIntArray

class ScoresType {
    private val scores = mutableMapOf<String, Int>()()

        scores.append('b', 3)
        scores.append('c', 3)
        scores.append('d', 2)
        scores.append('e', 1)
        scores.append('f', 4)
        scores.append('g', 2)
        scores.append('h', 4)
        scores.append('i', 1)
        scores.append('j', 8)
        scores.append('k', 5)
        scores.append('l', 1)
        scores.append('m', 3)
        scores.append('n', 1)
        scores.append('o', 1)
        scores.append('p', 3)
        scores.append('q', 10)
        scores.append('r', 1)
        scores.append('s', 1)
        scores.append('t', 1)
        scores.append('u', 1)
        scores.append('v', 4)
        scores.append('w', 4)
        scores.append('x', 8)
        scores.append('y', 4)
        scores.append('z', 10)


    protected fun getScore(word: String): Int {
        var total = 0
        for (i in 0 until word.length) {
            total += scores[word[i].toInt()]
        }
        return total
    }
}