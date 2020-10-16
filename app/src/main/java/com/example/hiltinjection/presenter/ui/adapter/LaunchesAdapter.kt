package com.example.hiltinjection.presenter.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltinjection.R
import com.example.hiltinjection.domain.models.Launch
import com.example.hiltinjection.presenter.extensions.urlImage
import kotlinx.android.synthetic.main.item_launches.view.*

class LaunchesAdapter :
    PagedListAdapter<Launch, LaunchesAdapter.LaunchViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LaunchViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_launches, parent, false)
    )

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) =
        getItem(position).let { holder.bind(it!!) }

    inner class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(launch: Launch) {
            itemView.txt_mission_item_launch.text = launch.mission_name
            itemView.txt_detail_item_launch.text = launch.details
            itemView.txt_rocketname_item_launch.text = launch.rocket.rocket_name
            itemView.txt_year_item_launch.text = launch.launch_year
            itemView.imgview_item_launch.urlImage(launch.links.mission_patch_small)
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Launch>() {
        override fun areItemsTheSame(oldItem: Launch, newItem: Launch) =
            oldItem.flight_number == newItem.flight_number

        override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
            return oldItem.mission_name == newItem.mission_name &&
                    oldItem.launch_success == newItem.launch_success &&
                    oldItem.details == newItem.details &&
                    oldItem.links == newItem.links
        }
    }
}
