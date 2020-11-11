package es.dgr.obmarvel.ui.detail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.dgr.domain.entities.Url
import es.dgr.obmarvel.databinding.ViewMiscellaneousBinding

class UrlAdapter(
    listener: (String) -> Unit
) : BaseAdapter<Url>(listener = listener) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            binding = ViewMiscellaneousBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ViewMiscellaneousBinding) : RecyclerView.ViewHolder(binding.root), Binder<Url> {
        override fun bind(item: Url, listener: (String) -> Unit) {
            binding.root.setOnClickListener { listener(item.url) }
            binding.tvTitle.text = item.type
        }
    }
}
