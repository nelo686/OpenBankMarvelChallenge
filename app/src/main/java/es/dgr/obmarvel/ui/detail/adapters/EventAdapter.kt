package es.dgr.obmarvel.ui.detail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.dgr.domain.entities.EventSummary
import es.dgr.obmarvel.databinding.ViewMiscellaneousBinding

class EventAdapter(
    listener: (String) -> Unit
) : BaseAdapter<EventSummary>(listener = listener) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            binding = ViewMiscellaneousBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ViewMiscellaneousBinding) : RecyclerView.ViewHolder(binding.root), Binder<EventSummary> {
        override fun bind(item: EventSummary, listener: (String) -> Unit) {
            binding.tvTitle.text = item.name
        }
    }
}
