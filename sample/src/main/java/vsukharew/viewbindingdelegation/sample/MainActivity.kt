package vsukharew.viewbindingdelegation.sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vsukharew.viewbindingdelegation.activityViewBinding
import vsukharew.viewbindingdelegation.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by activityViewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, ExampleFragment())
            .addToBackStack(null)
            .commit()
        binding.text.apply {
            setOnClickListener {
                Toast.makeText(context, "Main activity clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}