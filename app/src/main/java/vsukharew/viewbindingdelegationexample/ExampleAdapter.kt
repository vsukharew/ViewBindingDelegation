package vsukharew.viewbindingdelegationexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vsukharew.viewbindingdelegationexample.ExampleAdapter.ViewHolder
import vsukharew.viewbindingdelegationexample.databinding.ItemListUsersBinding

class ExampleAdapter : RecyclerView.Adapter<ViewHolder>() {
    var users = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_users, parent, false)
            .run { ViewHolder(ItemListUsersBinding.bind(this)) }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    class ViewHolder(
        private val binding: ItemListUsersBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.apply {
                id.text = user.id.toString()
                name.text = user.name
            }
        }
    }
}