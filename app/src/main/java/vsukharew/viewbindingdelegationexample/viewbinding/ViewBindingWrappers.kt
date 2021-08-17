package vsukharew.viewbindingdelegationexample.viewbinding

import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding

/**
 * wrapper above [FragmentViewBindingProperty]
 */
fun <V : ViewBinding> fragmentViewBinding(
    viewBinder: (View) -> V
): FragmentViewBindingProperty<V> = FragmentViewBindingProperty(viewBinder)

/**
 * wrapper above [ActivityViewBindingProperty]
 */
fun <V : ViewBinding> activityViewBinding(
    bindingInitializer: (LayoutInflater) -> V
): ActivityViewBindingProperty<V> = ActivityViewBindingProperty(bindingInitializer)

/**
 * wrapper above [ViewGroupBindingProperty]
 */
fun <V : ViewBinding> viewGroupBinding(
    viewBinder: (View) -> V
): ViewGroupBindingProperty<V> = ViewGroupBindingProperty(viewBinder)