package vsukharew.viewbindingdelegationexample

import android.os.Bundle
import android.view.View
import vsukharew.viewbindingdelegationexample.databinding.FragmentExampleBinding
import vsukharew.viewbindingdelegationexample.viewbinding.fragmentViewBinding

class ExampleFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_example
    override val binding: FragmentExampleBinding by fragmentViewBinding(FragmentExampleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showBottomsheet.apply {
            setOnClickListener {
                ExampleBottomSheetDialog().show(childFragmentManager, null)
            }
        }
    }
}