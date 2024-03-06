package dev.aston.intensiv.nikolay.second

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import dev.aston.intensiv.nikolay.R

class SecondTaskActivity : AppCompatActivity(R.layout.activity_second_task) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                val fragment = UserListFragment.newInstance()
                add(R.id.fragment_container, fragment, UserListFragment.TAG)
            }
        }
    }
}