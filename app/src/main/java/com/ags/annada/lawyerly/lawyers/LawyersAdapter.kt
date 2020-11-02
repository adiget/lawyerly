package com.ags.annada.lawyerly.lawyers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ags.annada.lawyerly.model.Lawyer
import com.ags.annada.lawyerly.databinding.LawyerItemBinding

class LawyersAdapter(private val viewModel: LawyersViewModel) :
    ListAdapter<Lawyer, LawyersAdapter.ViewHolder>(LawyerDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(viewModel, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: LawyerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: LawyersViewModel, item: Lawyer) {

            binding.viewmodel = viewModel
            binding.lawyer = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LawyerItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class LawyerDiffCallback : DiffUtil.ItemCallback<Lawyer>() {
    override fun areItemsTheSame(oldItem: Lawyer, newItem: Lawyer): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Lawyer, newItem: Lawyer): Boolean {
        return oldItem == newItem
    }
}
