package es.dgr.obmarvel.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import es.dgr.domain.entities.Hero
import es.dgr.obmarvel.databinding.ViewHeroBinding

class HeroAdapter(private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    var items = listOf<Hero>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder =
        HeroViewHolder(
            ViewHeroBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(item = items[position], listener = listener)
    }

    fun addItems(newItems: List<Hero>) {
        items = items.toMutableList().apply { addAll(newItems) }
    }

    class HeroViewHolder(private val binding: ViewHeroBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Hero, listener: (Int) -> Unit) {
            itemView.setOnClickListener { listener(item.id) }
            binding.ivPoster.load("${item.thumbnail.path}.${item.thumbnail.extension}")
            binding.tvTitle.text = item.name
        }
    }
}
