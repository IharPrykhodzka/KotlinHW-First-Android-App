package com.example.myfirstapplicationkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calendar: Calendar = Calendar.getInstance()
        calendar.set(2020, 9, 8, 14, 10, 30)
        val postTimeMillis: Long = calendar.timeInMillis
        Log.d("myLog", "есть - $postTimeMillis дата = ${calendar.time}")

        val post = Post(
            1,
            R.drawable.ic_baseline_fingerprint_24,
            postTimeMillis,
            "Игорь Приходько",
            "Вы решили написать функцию, которая из количества секунд генерирует человекопонятное представление времени публикации.",
            true,
            45,
            true,
            11,
            false,
            0)

        icon.setBackgroundResource(post.icon)
        date.text = status(post.dateForPost)
        author.text = post.author
        text.text = post.content
        if (post.likedByMe) {
            btnLike.setBackgroundResource(R.drawable.ic_baseline_favorite_red_24)
        }

        if (post.registeredLikes == 0) {
            forBtnLike.visibility = View.GONE
        }else{
            forBtnLike.visibility = View.VISIBLE
            forBtnLike.text = post.registeredLikes.toString()
        }

        if (post.commentedByMe) {
            btnComment.setBackgroundResource(R.drawable.ic_baseline_mode_comment_red_24)
        }

        if (post.registeredComments == 0) {
            forBtnComment.visibility = View.GONE
        }else{
            forBtnComment.visibility = View.VISIBLE
            forBtnComment.text = post.registeredComments.toString()
        }


        if (post.sharedByMe) {
            btnShare.setBackgroundResource(R.drawable.ic_baseline_share_red_24)
        }

        if (post.registeredShares == 0) {
            forBtnShare.visibility = View.GONE
        }else{
            forBtnShare.visibility = View.VISIBLE
            forBtnShare.text = post.registeredShares.toString()
        }

    }

    private fun status(publishedAgo: Long): String {

        val calendar2: Calendar = Calendar.getInstance()
        val calendarInMillis: Long = calendar2.timeInMillis
        Log.d("myLog", "есть - $calendarInMillis на вход - $publishedAgo дата = ${calendar2.time}")

        return when (calendarInMillis - publishedAgo) {



            in 25000..30000 -> "менее минуты назад"
            in 60000..119000 -> "минуту назад"
            in 120000..179000 -> "две минуты назад"
            in 180000..239000 -> "три минуты назад"
            in 240000..299000 -> "четыре минуты назад"
            in 300000..359000 -> "пять минут назад"
            in 360000..419000 -> "шесть минут назад"
            in 420000..479000 -> "семь минут назад"
            in 480000..539000 -> "восемь минут назад"
            in 540000..599000 -> "девять минут назад"
            in 600000..1199000 -> "более десяти минут назад"
            in 1200000..2399000 -> "более дватцати минут назад"
            in 2400000..3599000 -> "более тридцати минут назад"
            in 3600000..7199000 -> "более часа назад"
            in 7200000..10799000 -> "более двух часов назад"
            in 10800000..14399000 -> "более трех часов назад"
            in 14400000..17999000 -> "более четырех часов назад"
            in 18000000..21599000 -> "более пяти часов назад"
            in 21600000..25199000 -> "более шести часов назад"
            in 25200000..28799000 -> "более семи часов назад"
            in 28800000..32399000 -> "более восеми часов назад"
            in 32400000..35999000 -> "более девяти часов назад"
            in 36000000..39599000 -> "более десяти часов назад"
            in 39600000..43199000 -> "более одиннадцати часов назад"
            in 43200000..86399000 -> "более двенадцати часов назад"
            in 86400000..172_799000 -> "один день назад"
            in 172_800000..259_199000 -> "два дня назад"

            else -> "В сети"
        }
    }
}
