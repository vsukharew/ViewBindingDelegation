package vsukharew.viewbindingdelegationexample.viewbinding

import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding

/**
 * wrapper above [FragmentViewBindingProperty]
 */
fun <T : ViewBinding> fragmentViewBinding(
    viewBinder: (View) -> T
): FragmentViewBindingProperty<T> = FragmentViewBindingProperty(viewBinder)

/**
 * wrapper above [ActivityViewBindingProperty]
 */
fun <T : ViewBinding> activityViewBinding(
    bindingInitializer: (LayoutInflater) -> T
): ActivityViewBindingProperty<T> = ActivityViewBindingProperty(bindingInitializer)

/**
 * wrapper above [ViewGroupBindingProperty]
 */
fun <T : ViewBinding> viewGroupBinding(
    viewBinder: (View) -> T
): ViewGroupBindingProperty<T> = ViewGroupBindingProperty(viewBinder)