package vsukharew.viewbindingdelegation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty

/**
 * wrapper above [FragmentViewBindingProperty]
 */
fun <V : ViewBinding> fragmentViewBinding(
    viewBinder: (View) -> V
): FragmentViewBindingProperty<V> =
    FragmentViewBindingProperty(viewBinder)

/**
 * wrapper above [ActivityViewBindingProperty]
 */
fun <V : ViewBinding> activityViewBinding(
    bindingInitializer: (LayoutInflater) -> V
): ActivityViewBindingProperty<V> =
    ActivityViewBindingProperty(bindingInitializer)

/**
 * wrapper above [ViewGroupBindingProperty]
 */
fun <V : ViewBinding> viewGroupBinding(
    viewBinder: (View) -> V
): ViewGroupBindingProperty<V> = ViewGroupBindingProperty(viewBinder)

/**
 * returns property delegate for initializing [ViewGroup] layout views.
 * This method uses reflection for property delegate creation
 */
inline fun <reified V : ViewBinding> viewGroupBinding(): ReadOnlyProperty<ViewGroup, V> {
    return ReadOnlyProperty { thisRef, _ ->
        V::class.java
            .getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java)
            .invoke(null, LayoutInflater.from(thisRef.context), thisRef) as V
    }
}