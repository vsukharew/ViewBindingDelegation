package vsukharew.viewbindingdelegation

import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding

/**
 * wrapper above [FragmentViewBindingProperty]
 */
fun <V : ViewBinding> fragmentViewBinding(
    viewBinder: (View) -> V,
    onDestroyView: (V) -> Unit = {}
): FragmentViewBindingProperty<V> =
    FragmentViewBindingProperty(viewBinder, onDestroyView)

/**
 * wrapper above [ActivityViewBindingProperty]
 */
fun <V : ViewBinding> activityViewBinding(
    bindingInitializer: (LayoutInflater) -> V,
    onDestroyView: (V) -> Unit = {}
): ActivityViewBindingProperty<V> =
    ActivityViewBindingProperty(bindingInitializer, onDestroyView)

/**
 * wrapper above [ViewGroupBindingProperty]
 */
fun <V : ViewBinding> viewGroupBinding(
    viewBinder: (View) -> V,
    onDestroyView: (V) -> Unit = {}
): ViewGroupBindingProperty<V> = ViewGroupBindingProperty(viewBinder, onDestroyView)