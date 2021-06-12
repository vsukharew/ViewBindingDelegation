package vsukharew.viewbindingdelegationexample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import vsukharew.viewbindingdelegationexample.databinding.DialogExampleBottomSheetBinding
import vsukharew.viewbindingdelegationexample.viewbinding.fragmentViewBinding

class ExampleBottomSheetDialog : BaseBottomSheetDialog() {
    override val binding: DialogExampleBottomSheetBinding by fragmentViewBinding(
        DialogExampleBottomSheetBinding::inflate
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            gallery.setOnClickListener {
                Toast.makeText(context, "Gallery clicked", Toast.LENGTH_SHORT).show()
            }
            camera.setOnClickListener {
                Toast.makeText(context, "Camera clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}