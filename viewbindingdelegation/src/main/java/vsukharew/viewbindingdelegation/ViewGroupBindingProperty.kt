package vsukharew.viewbindingdelegation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Property delegate for initializing custom views' layout. Uses no reflection
 */
class ViewGroupBindingProperty<V : ViewBinding>(
    private val viewBinder: (View) -> V
) : ViewBindingProperty<V>(), ReadOnlyProperty<ViewGroup, V> {

    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): V {
        return viewBinder.invoke(thisRef).also { binding = it }
    }
}

/**
 * Property delegate for initializing custom views' layout. Uses reflection
 */
class ViewGroupReflectionBindingProperty<V : ViewBinding>(private val bindingClass: Class<V>) :
    ReadOnlyProperty<ViewGroup, V> {
    private var binding: V? = null
    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): V {
        return binding ?: run {
            (bindingClass.getMethod("inflate", LayoutInflater::class.java)
                .invoke(null, LayoutInflater.from(thisRef.context)) as V)
                .apply { thisRef.addView(root) }
                .also { binding = it }
        }
    }
}