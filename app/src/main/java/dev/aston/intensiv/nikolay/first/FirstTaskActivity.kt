package dev.aston.intensiv.nikolay.first

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import dev.aston.intensiv.nikolay.R

class FirstTaskActivity : AppCompatActivity(R.layout.activity_first_task) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                val fragment = FragmentA.newInstance()
                add(R.id.fragment_container, fragment, FragmentA.TAG)
            }
        }
    }
}