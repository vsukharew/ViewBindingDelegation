package vsukharew.viewbindingdelegationexample.viewbinding

import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ViewGroupBindingProperty<V :ViewBinding>(
    private val viewBinder : (View) -> V
) : ViewBindingProperty<V>(), ReadOnlyProperty<ViewGroup, V> {

    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): V {
        return viewBinder.invoke(thisRef).also { binding = it }
    }
}