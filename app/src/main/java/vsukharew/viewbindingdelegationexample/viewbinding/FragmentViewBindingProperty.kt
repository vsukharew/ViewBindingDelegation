package vsukharew.viewbindingdelegationexample.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Delegate property for initializing fragment layout views
 */
class FragmentViewBindingProperty<V :ViewBinding>(
    private val viewBinder: (View) -> V
) : ViewBindingProperty<V>(), ReadOnlyProperty<Fragment, V> {

    override fun getValue(thisRef: Fragment, property: KProperty<*>): V {
        return binding ?: run {
            thisRef.viewLifecycleOwner.lifecycle.let {
                it.addObserver(this)
                lifecycle = it
            }
            viewBinder.invoke(thisRef.requireView()).also { binding = it }
        }
    }
}