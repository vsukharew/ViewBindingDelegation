package vsukharew.viewbindingdelegationexample.viewbinding

import android.view.LayoutInflater
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding

open class ViewBindingProperty<T : ViewBinding> : LifecycleObserver {
    protected var binding: T? = null
    protected var lifecycle: Lifecycle? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        lifecycle?.removeObserver(this)
        lifecycle = null
        binding = null
    }
}