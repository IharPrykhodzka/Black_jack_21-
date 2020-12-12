package ru.game.bj21

import android.content.Context
import android.widget.Toast
import splitties.toast.toast

class Cards{

    val cardDesk = mutableMapOf<String, MutableMap<Int, String>>().apply {
        this["hearts"] = mutableMapOf(0 to "6", 1 to "7", 2 to "8", 3 to "9", 4 to "10", 5 to "jack", 6 to "queen", 7 to "king", 8 to "ace")
        this["diamonds"] = mutableMapOf(0 to "6", 1 to "7", 2 to "8", 3 to "9", 4 to "10", 5 to "jack", 6 to "queen", 7 to "king", 8 to "ace")
        this["cross"] = mutableMapOf(0 to "6", 1 to "7", 2 to "8", 3 to "9", 4 to "10", 5 to "jack", 6 to "queen", 7 to "king", 8 to "ace")
        this["spades"] = mutableMapOf(0 to "6", 1 to "7", 2 to "8", 3 to "9", 4 to "10", 5 to "jack", 6 to "queen", 7 to "king", 8 to "ace")
    }

    fun updateCardDesk(suit: String, nominal: Int?){
        if (cardDesk[suit]?.isEmpty() == true) {
            cardDesk.remove(suit)
        }else {
            try {
                cardDesk[suit]?.apply {
                    remove(nominal)
                }
            }catch (e: NoSuchElementException) {
                toast("Колода пуста!")
            }
        }
    }
}