package es.dgr.obmarvel.ui.detail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.dgr.domain.entities.ComicSummary
import es.dgr.obmarvel.databinding.ViewMiscellaneousBinding

class ComicAdapter(
    listener: (String) -> Unit
) : BaseAdapter<ComicSummary>(listener = listener) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            binding = ViewMiscellaneousBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ViewMiscellaneousBinding) : RecyclerView.ViewHolder(binding.root), Binder<ComicSummary> {
        override fun bind(item: ComicSummary, listener: (String) -> Unit) {
            binding.tvTitle.text = item.name
        }
    }
}
