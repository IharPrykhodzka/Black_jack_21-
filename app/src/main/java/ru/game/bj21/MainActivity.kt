package ru.game.bj21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
            theCard()
            if(player1.score > 21 || player1.score == 21) {
                takeCard.isEnabled = false
            }
            counter.text = player1.score.toString()
        }

        stopPlay.setOnClickListener {
            dealerStatus.setBackgroundResource(R.drawable.dealer_play)
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
            takeCard.isEnabled = true
            resultGame.setBackgroundResource(R.drawable.lets_play)
            dealerStatus.setBackgroundResource(R.drawable.dealer_wait)
            result.visibility = View.GONE
            resultGame.visibility = View.VISIBLE
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
        result.visibility = View.GONE
        resultGame.visibility = View.VISIBLE

        if (myScore > 21 && dealerScore > 21) {
            resultGame.setBackgroundResource(R.drawable.draw)

        } else if (myScore in 21 downTo 16 && dealerScore in 21 downTo 16) {
            if (myScore > dealerScore) {

                resultGame.setBackgroundResource(R.drawable.you_win)
            } else if (myScore == dealerScore) {

                resultGame.setBackgroundResource(R.drawable.draw)
            } else {

                resultGame.setBackgroundResource(R.drawable.you_loose)
            }
        } else if (myScore in 21 downTo 16 && dealerScore > 21) {

            resultGame.setBackgroundResource(R.drawable.you_win)
        } else if (dealerScore in 21 downTo 16 && myScore > 21 || myScore < 16) {

            resultGame.setBackgroundResource(R.drawable.you_loose)
        } else {
            toast("ОЙ! Что-то не то))")
        }
    }

    private fun theCard() {
        val card = player1.takeCard()
            result.visibility = View.VISIBLE
            resultGame.visibility = View.GONE

            when (card) {
                "cross_11" -> result.setBackgroundResource(R.drawable.cross_ace)
                "cross_6" -> result.setBackgroundResource(R.drawable.cross_six)
                "cross_7" -> result.setBackgroundResource(R.drawable.cross_seven)
                "cross_8" -> result.setBackgroundResource(R.drawable.cross_eight)
                "cross_9" -> result.setBackgroundResource(R.drawable.cross_nine)
                "cross_10" -> result.setBackgroundResource(R.drawable.cross_ten)
                "cross_2" -> result.setBackgroundResource(R.drawable.cross_jack)
                "cross_3" -> result.setBackgroundResource(R.drawable.cross_queen)
                "cross_4" -> result.setBackgroundResource(R.drawable.cross_king)

                "diamonds_11" -> result.setBackgroundResource(R.drawable.diamonds_ace)
                "diamonds_6" -> result.setBackgroundResource(R.drawable.diamonds_six)
                "diamonds_7" -> result.setBackgroundResource(R.drawable.diamonds_seven)
                "diamonds_8" -> result.setBackgroundResource(R.drawable.diamonds_eight)
                "diamonds_9" -> result.setBackgroundResource(R.drawable.diamonds_nine)
                "diamonds_10" -> result.setBackgroundResource(R.drawable.diamonds_ten)
                "diamonds_2" -> result.setBackgroundResource(R.drawable.diamonds_jack)
                "diamonds_3" -> result.setBackgroundResource(R.drawable.diamonds_queen)
                "diamonds_4" -> result.setBackgroundResource(R.drawable.diamonds_king)

                "spades_11" -> result.setBackgroundResource(R.drawable.spades_ace)
                "spades_6" -> result.setBackgroundResource(R.drawable.spades_six)
                "spades_7" -> result.setBackgroundResource(R.drawable.spades_seven)
                "spades_8" -> result.setBackgroundResource(R.drawable.spades_eight)
                "spades_9" -> result.setBackgroundResource(R.drawable.spades_nine)
                "spades_10" -> result.setBackgroundResource(R.drawable.spades_ten)
                "spades_2" -> result.setBackgroundResource(R.drawable.spades_jack)
                "spades_3" -> result.setBackgroundResource(R.drawable.spades_gueen)
                "spades_4" -> result.setBackgroundResource(R.drawable.spades_king)

                "hearts_11" -> result.setBackgroundResource(R.drawable.hearts_ace)
                "hearts_6" -> result.setBackgroundResource(R.drawable.hearts_six)
                "hearts_7" -> result.setBackgroundResource(R.drawable.hearts_seven)
                "hearts_8" -> result.setBackgroundResource(R.drawable.hearts_eight)
                "hearts_9" -> result.setBackgroundResource(R.drawable.hearts_nine)
                "hearts_10" -> result.setBackgroundResource(R.drawable.hearts_ten)
                "hearts_2" -> result.setBackgroundResource(R.drawable.hearts_jack)
                "hearts_3" -> result.setBackgroundResource(R.drawable.hearts_queen)
                "hearts_4" -> result.setBackgroundResource(R.drawable.hearts_king)

                "spades_ace" -> result.setBackgroundResource(R.drawable.spades_ace)
                "spades_six" -> result.setBackgroundResource(R.drawable.spades_six)
                "spades_seven" -> result.setBackgroundResource(R.drawable.spades_seven)
                "spades_eight" -> result.setBackgroundResource(R.drawable.spades_eight)
                "spades_nine" -> result.setBackgroundResource(R.drawable.spades_nine)
                "spades_ten" -> result.setBackgroundResource(R.drawable.spades_ten)
                "spades_jack" -> result.setBackgroundResource(R.drawable.spades_jack)
                "spades_queen" -> result.setBackgroundResource(R.drawable.spades_gueen)
                "spades_king" -> result.setBackgroundResource(R.drawable.spades_king)

                "hearts_ace" -> result.setBackgroundResource(R.drawable.hearts_ace)
                "hearts_six" -> result.setBackgroundResource(R.drawable.hearts_six)
                "hearts_seven" -> result.setBackgroundResource(R.drawable.hearts_seven)
                "hearts_eight" -> result.setBackgroundResource(R.drawable.hearts_eight)
                "hearts_nine" -> result.setBackgroundResource(R.drawable.hearts_nine)
                "hearts_ten" -> result.setBackgroundResource(R.drawable.hearts_ten)
                "hearts_jack" -> result.setBackgroundResource(R.drawable.hearts_jack)
                "hearts_queen" -> result.setBackgroundResource(R.drawable.hearts_queen)
                "hearts_king" -> result.setBackgroundResource(R.drawable.hearts_king)

                "cross_ace" -> result.setBackgroundResource(R.drawable.cross_ace)
                "cross_six" -> result.setBackgroundResource(R.drawable.cross_six)
                "cross_seven" -> result.setBackgroundResource(R.drawable.cross_seven)
                "cross_eight" -> result.setBackgroundResource(R.drawable.cross_eight)
                "cross_nine" -> result.setBackgroundResource(R.drawable.cross_nine)
                "cross_ten" -> result.setBackgroundResource(R.drawable.cross_ten)
                "cross_jack" -> result.setBackgroundResource(R.drawable.cross_jack)
                "cross_queen" -> result.setBackgroundResource(R.drawable.cross_queen)
                "cross_king" -> result.setBackgroundResource(R.drawable.cross_king)

                "diamonds_ace" -> result.setBackgroundResource(R.drawable.diamonds_ace)
                "diamonds_six" -> result.setBackgroundResource(R.drawable.diamonds_six)
                "diamonds_seven" -> result.setBackgroundResource(R.drawable.diamonds_seven)
                "diamonds_eight" -> result.setBackgroundResource(R.drawable.diamonds_eight)
                "diamonds_nine" -> result.setBackgroundResource(R.drawable.diamonds_nine)
                "diamonds_ten" -> result.setBackgroundResource(R.drawable.diamonds_ten)
                "diamonds_jack" -> result.setBackgroundResource(R.drawable.diamonds_jack)
                "diamonds_queen" -> result.setBackgroundResource(R.drawable.diamonds_queen)
                "diamonds_king" -> result.setBackgroundResource(R.drawable.diamonds_king)

                else -> result.setBackgroundResource(R.drawable.draw)
            }
    }
}