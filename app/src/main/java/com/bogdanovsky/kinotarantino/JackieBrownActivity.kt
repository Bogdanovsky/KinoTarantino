package com.bogdanovsky.kinotarantino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.ImageView

const val TAG_THREE = "PulpFictionActivity"

class JackieBrownActivity : AppCompatActivity() {

    private var isFavourite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jackie_brown)

        val grayStar = findViewById<ImageView>(R.id.gray_star)
        val goldenStar = findViewById<ImageView>(R.id.golden_star)
        if (MainActivity.jackieBrownIsFavourite) {
            grayStar.visibility = View.GONE
            goldenStar.visibility = View.VISIBLE
        }

        grayStar.setOnClickListener {
            it.visibility = View.GONE
            goldenStar.visibility = View.VISIBLE
            isFavourite = true
            MainActivity.jackieBrownIsFavourite = true
        }

        goldenStar.setOnClickListener {
            it.visibility = View.GONE
            grayStar.visibility = View.VISIBLE
            isFavourite = false
            MainActivity.jackieBrownIsFavourite = false
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("isFavourite", isFavourite)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        handleState(savedInstanceState)
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun handleState(savedInstanceState: Bundle) {
        if (savedInstanceState.getBoolean("isFavourite")) {
            findViewById<ImageView>(R.id.gray_star).visibility = View.GONE
            findViewById<ImageView>(R.id.golden_star).visibility = View.VISIBLE
            isFavourite = true
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.i(TAG_THREE, "Jackie Brown is favourite movie: $isFavourite")
    }
}
