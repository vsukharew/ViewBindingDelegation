package vsukharew.viewbindingdelegationexample

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.lifecycle.ViewTreeLifecycleOwner
import vsukharew.viewbindingdelegationexample.databinding.ViewExampleCustomBinding
import vsukharew.viewbindingdelegation.viewGroupBinding

class ExampleCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding by viewGroupBinding(ViewExampleCustomBinding::bind)

    init {
        View.inflate(context, R.layout.view_example_custom, this)
        binding.button.setOnClickListener {
            Toast.makeText(context, "Custom view clicked", Toast.LENGTH_SHORT).show()
        }

    }
}