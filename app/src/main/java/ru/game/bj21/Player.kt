package ru.game.bj21

import android.util.Log


class Player(cards: Cards) {
    var score: Int = 0

    private val cardsThis = cards

    private fun addScore(hands: Int) {
        score += hands
    }

    fun takeCard(): String {
        var suit = cardsThis.cardDesk.keys.random()

        if (cardsThis.cardDesk[suit]?.isEmpty() == true) {
            cardsThis.cardDesk.remove(suit)
            suit = cardsThis.cardDesk.keys.random()
        }

        val key = cardsThis.cardDesk[suit]?.keys?.random()

        val nominal = cardsThis.cardDesk[suit]?.get(key)

        if (key != null) {
            cardsThis.updateCardDesk(suit, key)
        }

        if (nominal != null) {
            countScore(nominal)
        }


        Log.d("log", suit + "_$nominal")
        return suit + "_$nominal"
    }

    private fun countScore(nominal: String) {

        when (nominal) {
            "jack" -> addScore(JACK_CARD)
            "queen" -> addScore(QUEEN_CARD)
            "king" -> addScore(KING_CARD)
            "ace" -> addScore(ACE_CARD)
            else -> addScore(nominal.toInt())
        }
    }

    companion object {
        const val JACK_CARD = 2
        const val QUEEN_CARD = 3
        const val KING_CARD = 4
        const val ACE_CARD = 11
    }

}
