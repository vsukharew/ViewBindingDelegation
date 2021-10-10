package vsukharew.viewbindingdelegation.sample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import vsukharew.viewbindingdelegation.fragmentViewBinding
import vsukharew.viewbindingdelegation.sample.databinding.DialogExampleBottomSheetBinding

class ExampleBottomSheetDialog : BaseBottomSheetDialog() {
    override val layoutResId: Int = R.layout.dialog_example_bottom_sheet
    override val binding: DialogExampleBottomSheetBinding by fragmentViewBinding(
        DialogExampleBottomSheetBinding::bind
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