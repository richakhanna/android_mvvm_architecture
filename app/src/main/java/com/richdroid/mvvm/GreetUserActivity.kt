package com.richdroid.mvvm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class GreetUserActivity : AppCompatActivity() {

    private val GREET_USER_FRAGMENT_TAG = "GREET_USER_FRAG_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greet_user)
        addGreetUserFragment()
    }

    fun addGreetUserFragment() {
        val greetUserFragment = GreetUserFragment()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
                .add(R.id.container, greetUserFragment, GREET_USER_FRAGMENT_TAG)
                .commit()
    }
}
