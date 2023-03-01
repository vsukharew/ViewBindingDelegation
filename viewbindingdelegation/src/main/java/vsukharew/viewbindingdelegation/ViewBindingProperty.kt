package vsukharew.viewbindingdelegation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding

open class ViewBindingProperty<V : ViewBinding>(
    private val onDestroyView: (V) -> Unit
) : DefaultLifecycleObserver {
    protected var binding: V? = null

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.removeObserver(this)
        binding?.let { onDestroyView.invoke(it) }
        binding = null
    }
}