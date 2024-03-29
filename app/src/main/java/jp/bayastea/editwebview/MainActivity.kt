package jp.bayastea.editwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.bayastea.editwebview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }


}