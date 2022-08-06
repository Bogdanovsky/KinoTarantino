package com.bogdanovsky.kinotarantino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.ImageView
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    companion object {
        var reservoirDogsIsFavourite = false
        var pulpFictionIsFavourite = false
        var jackieBrownIsFavourite = false
    }

//    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alphaWhenPressed = 85
//        binding = MainActivityBinding.inflate(layoutInflater)

        findViewById<ImageView>(R.id.reservoir_dogs_image).setOnClickListener {
            (it as ImageView).imageAlpha = alphaWhenPressed
            val intent = Intent(this, ReservoirDogsActivity::class.java)
            this.startActivity(intent)
        }
        findViewById<ImageView>(R.id.pulp_fiction_image).setOnClickListener {
            (it as ImageView).imageAlpha = alphaWhenPressed
            val intent = Intent(this, PulpFictionActivity::class.java)
            this.startActivity(intent)
        }
        findViewById<ImageView>(R.id.jackie_brown_image).setOnClickListener {
            (it as ImageView).imageAlpha = alphaWhenPressed
            val intent = Intent(this, JackieBrownActivity::class.java)
            this.startActivity(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("imageAlphaReservoirDogs", findViewById<ImageView>(R.id.reservoir_dogs_image).imageAlpha)
        outState.putInt("imageAlphaPulpFiction", findViewById<ImageView>(R.id.pulp_fiction_image).imageAlpha)
        outState.putInt("imageAlphaJackieBrown", findViewById<ImageView>(R.id.jackie_brown_image).imageAlpha)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        handleState(savedInstanceState)
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun handleState(savedInstanceState: Bundle) {
        findViewById<ImageView>(R.id.reservoir_dogs_image).imageAlpha = savedInstanceState.getInt("imageAlphaReservoirDogs")
        findViewById<ImageView>(R.id.pulp_fiction_image).imageAlpha = savedInstanceState.getInt("imageAlphaPulpFiction")
        findViewById<ImageView>(R.id.jackie_brown_image).imageAlpha = savedInstanceState.getInt("imageAlphaJackieBrown")
    }

    override fun onResume() {
        super.onResume()
        findViewById<ImageView>(R.id.reservoir_dogs_star).visibility = if (reservoirDogsIsFavourite) View.VISIBLE else View.INVISIBLE
        findViewById<ImageView>(R.id.pulp_fiction_star).visibility = if (pulpFictionIsFavourite) View.VISIBLE else View.INVISIBLE
        findViewById<ImageView>(R.id.jackie_brown_star).visibility = if (jackieBrownIsFavourite) View.VISIBLE else View.INVISIBLE

    }
}