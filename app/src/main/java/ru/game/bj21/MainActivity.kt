package ru.game.bj21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import splitties.toast.toast

class MainActivity : AppCompatActivity() {
    private var cards = Cards()
    private var player1 = Player(cards)
    private var dealer = Player(cards)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        takeCard.setOnClickListener {
            text.text = player1.takeCard()
            counter.text = player1.score.toString()

            Log.d("log", "${cards.cardDesk} ")
        }

        stopPlay.setOnClickListener {
            dealerPlays()
            resultGame()
            dealerCounter.text = dealer.score.toString()
        }

        playAgain.setOnClickListener {
            cards = Cards()
            player1.score = 0
            dealer.score = 0
            player1 = Player(cards)
            dealer = Player(cards)

            text.text = "Тяни карту!" //TODO
            counter.text = player1.score.toString()
            dealerCounter.text = dealer.score.toString()
        }
    }

    private fun dealerPlays() {
        while (dealer.score < 19) {
            dealer.takeCard()
        }
    }

    private fun resultGame() {
        dealerPlays()
        val myScore = player1.score
        val dealerScore = dealer.score

        if (myScore > 21 && dealerScore > 21){
            toast("Ничья! У обоих перебор.")

        }else if (myScore in 21 downTo 16 && dealerScore in 21 downTo 16) {
            if (myScore > dealerScore) {
                toast("Вы Победили!!!")
            }else if (myScore == dealerScore) {
                toast("Ничья")
            }else{
                toast("Диллер Победил!!!")
            }
        }else if (myScore in 21 downTo 16 && dealerScore > 21) {
            toast("Вы Победили!!!")
        }else if (dealerScore in 21 downTo 16 && myScore > 21 || myScore < 16) {
            toast("Диллер Победил!!!")
        }else {
            toast("какаета хуйня!!!")
        }


    }
}