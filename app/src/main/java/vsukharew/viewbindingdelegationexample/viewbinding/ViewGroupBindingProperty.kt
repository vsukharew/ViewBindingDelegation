package vsukharew.viewbindingdelegationexample.viewbinding

import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ViewGroupBindingProperty<T : ViewBinding>(
    private val viewBinder : (View) -> T
) : ViewBindingProperty<T>(), ReadOnlyProperty<ViewGroup, T> {

    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): T {
        return viewBinder.invoke(thisRef).also { binding = it }
    }
}