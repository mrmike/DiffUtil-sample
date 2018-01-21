package com.moczul.diffutilsample

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ActorAdapter(initActorsList: List<Actor>) : RecyclerView.Adapter<ActorAdapter.ViewHolder>() {

    private val actors = mutableListOf<Actor>()

    init {
        actors.addAll(initActorsList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_actor, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = actors.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(actor = actors[position])
    }

    fun swap(actors: List<Actor>) {
        val diffCallback = ActorDiffCallback(this.actors, actors)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.actors.clear()
        this.actors.addAll(actors)
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.actor_name)

        fun bind(actor: Actor) {
            name.text = actor.name
        }

    }
}