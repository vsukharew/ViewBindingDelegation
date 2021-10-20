# ViewBindingDelegation
### This library creates [Android View Binding](https://developer.android.com/topic/libraries/view-binding) instances using [Kotlin delegated properties](https://kotlinlang.org/docs/delegated-properties.html)

## Advantages
- Lightweight ❄️
- Gets you rid of boilerplate ⛔
- lifecycle-safe 🛡️

## Dependency:
In your module-level `build.gradle` add:
``` 
android {
    ...
    buildFeatures {
        viewBinding true
    }
    ...
}

dependencies {
    ...
    // notice if you use version 1.0.0, then you have to add @aar after the version number
    implementation 'io.github.vsukharew:viewbindingdelegation:x.y.z'
    ...
}
```

## Usage
#### Activity:
```kotlin
class MainActivity : AppCompatActivity() {
    private val binding by activityViewBinding(ActivityMainBinding::inflate)
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
          // views initialization
        }
    }
}
```

#### Fragment:
```kotlin
class ExampleFragment : Fragment(R.layout.fragment_example) {
    private val binding by fragmentViewBinding(FragmentExampleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            // views initialization
        }
    }
}
```

#### BottomSheetDialog:
```kotlin
abstract class BaseBottomSheetDialog : BottomSheetDialogFragment() {
    @get:LayoutRes
    protected abstract val layoutResId: Int
    protected abstract val binding: ViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutResId, container, false)
}

class ExampleBottomSheetDialog : BaseBottomSheetDialog() {
    override val layoutResId: Int = R.layout.dialog_example_bottom_sheet
    override val binding: DialogExampleBottomSheetBinding by fragmentViewBinding(
        DialogExampleBottomSheetBinding::bind
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            // views initialization
        }
    }
}
```
