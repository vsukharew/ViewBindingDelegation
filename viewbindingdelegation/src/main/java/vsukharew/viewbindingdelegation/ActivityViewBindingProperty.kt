package vsukharew.viewbindingdelegation

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Property delegate for initializing activity's layout views
 */
class ActivityViewBindingProperty<V : ViewBinding>(
    private val bindingInitializer: (LayoutInflater) -> V,
    onDestroyView: (V) -> Unit,
) : ViewBindingProperty<V>(onDestroyView), ReadOnlyProperty<AppCompatActivity, V> {

    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): V {
        return binding ?: run {
            thisRef.lifecycle.addObserver(this)
            bindingInitializer.invoke(thisRef.layoutInflater).also { binding = it }
        }
    }
}