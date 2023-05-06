package com.partitionsoft.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.partitionsoft.criminalintent.databinding.ListItemCrimeBinding
import com.partitionsoft.criminalintent.databinding.ListItemSeriousCrimeBinding

class CrimeHolder(
    private val binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(crime: Crime) {
        if (binding is ListItemCrimeBinding) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()

            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, "${crime.title} pressed!", Toast.LENGTH_SHORT)
                    .show()
            }
        } else if (binding is ListItemSeriousCrimeBinding) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()

            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, "${crime.title} pressed!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}

class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<CrimeHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = if (viewType == VIEW_TYPE_SERIOUS_CRIME) {
            ListItemSeriousCrimeBinding.inflate(inflater, parent, false)
        } else {
            ListItemCrimeBinding.inflate(inflater, parent, false)
        }
        return CrimeHolder(binding)
    }


    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]

        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size

    override fun getItemViewType(position: Int): Int {
        val crime = crimes[position]
        return if (crime.requiresPolicy) {
            VIEW_TYPE_SERIOUS_CRIME
        } else {
            VIEW_TYPE_NORMAL_CRIME
        }
    }

    companion object {
        private const val VIEW_TYPE_NORMAL_CRIME = 0
        private const val VIEW_TYPE_SERIOUS_CRIME = 1
    }

}