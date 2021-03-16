package com.example.android.trackmysleepquality

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.GridItemSleepNightBinding
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

class SleepNightAdapter: ListAdapter<SleepNight, SleepNightAdapter.ViewHolder>(SleepNightDiffCallback()) {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder.from(parent)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val item = getItem(position)
		holder.bind(item)
	}

	/**
	 * ViewHolder
	 */
	class ViewHolder private constructor(private val binding: GridItemSleepNightBinding): RecyclerView.ViewHolder(binding.root){

		companion object {
			fun from(parent: ViewGroup): ViewHolder {
				val layoutInflater = LayoutInflater.from(parent.context)
				val binding = GridItemSleepNightBinding.inflate(layoutInflater, parent, false)
				return ViewHolder(binding)
			}
		}

		fun bind(item: SleepNight) {
			binding.sleep = item
			binding.executePendingBindings() // An optimization method that asks data binding to execute any pending bindings right away
		}
	}
}

class SleepNightDiffCallback: DiffUtil.ItemCallback<SleepNight>() {

	override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
		return oldItem.nightId == newItem.nightId
	}

	override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
		return oldItem == newItem
	}
}
