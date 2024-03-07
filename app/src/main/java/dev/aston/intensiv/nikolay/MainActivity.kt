package dev.aston.intensiv.nikolay

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.aston.intensiv.nikolay.databinding.ActivityMainBinding
import dev.aston.intensiv.nikolay.first.FirstTaskActivity
import dev.aston.intensiv.nikolay.second.SecondTaskActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toFirstTask.setOnClickListener {
            val firstTaskIntent = Intent(this, FirstTaskActivity::class.java)
            startActivity(firstTaskIntent)
        }

        binding.toSecondTask.setOnClickListener {
            val secondTaskIntent = Intent(this, SecondTaskActivity::class.java)
            startActivity(secondTaskIntent)
        }
    }
}