package vsukharew.viewbindingdelegation.sample

import android.os.Bundle
import android.view.View
import vsukharew.viewbindingdelegation.fragmentViewBinding
import vsukharew.viewbindingdelegation.sample.databinding.FragmentExampleBinding

class ExampleFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_example
    override val binding: FragmentExampleBinding by fragmentViewBinding(FragmentExampleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            showBottomsheet.apply {
                setOnClickListener {
                    ExampleBottomSheetDialog().show(childFragmentManager, null)
                }
            }
            recycler.adapter = ExampleAdapter().apply { users = generateRandomUsers() }
        }
    }

    private fun generateRandomUsers(): List<User> = (1..10).map { User(it, generateRandomString()) }

    private fun generateRandomString(): String =
        (('a'..'z') + ('A'..'Z') + ('0'..'9'))
            .shuffled()
            .take(10)
            .joinToString(separator = "")
}