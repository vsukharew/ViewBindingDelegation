package vsukharew.viewbindingdelegationexample.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Delegate property for initializing fragment layout views
 */
class FragmentViewBindingProperty<T : ViewBinding>(
    private val viewBinder: (View) -> T
) : ViewBindingProperty<T>(), ReadOnlyProperty<Fragment, T> {

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return binding ?: run {
            thisRef.viewLifecycleOwner.lifecycle.let {
                it.addObserver(this)
                lifecycle = it
            }
            thisRef.requireView()
            viewBinder.invoke(thisRef.requireView()).also { binding = it }
        }
    }
}