package vsukharew.viewbindingdelegationexample.viewbinding

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Delegate property for initializing activity layout views
 */
class ActivityViewBindingProperty<V :ViewBinding>(
    private val bindingInitializer: (LayoutInflater) -> V
) : ViewBindingProperty<V>(), ReadOnlyProperty<AppCompatActivity, V> {

    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): V {
        return binding ?: run {
            thisRef.lifecycle.let {
                it.addObserver(this)
                lifecycle = it
            }
            bindingInitializer.invoke(thisRef.layoutInflater).also { binding = it }
        }
    }
}