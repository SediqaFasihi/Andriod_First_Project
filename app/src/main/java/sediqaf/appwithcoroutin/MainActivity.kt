package sediqaf.appwithcoroutin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import sediqaf.appwithcoroutin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var count = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.startActivityAction.setOnClickListener {
            runBlocking {
                delysum()
                    incrementAndPrintNumber()
            }
        }
    }
        suspend fun delysum()
        {
            delay(2000L)
        }
    fun incrementAndPrintNumber(){
        val value = binding.etNumber.text.toString()
        val value2 = value.toInt()
        val textViewValue = value2 + 1 + count
        count++
        binding.tvNumber.text = textViewValue.toString()
    }
}