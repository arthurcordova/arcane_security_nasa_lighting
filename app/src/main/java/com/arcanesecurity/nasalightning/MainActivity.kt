package com.arcanesecurity.nasalightning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arcanesecurity.nasalighting.R
import com.arcanesecurity.nasalightning.view.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .commitNow()

    }
}