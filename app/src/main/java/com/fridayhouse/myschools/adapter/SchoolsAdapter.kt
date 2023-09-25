package com.fridayhouse.myschools.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fridayhouse.myschools.R
import com.fridayhouse.myschools.models.SchoolsResponseItem


class SchoolsAdapter: RecyclerView.Adapter<SchoolsAdapter.SchoolViewHolder>(){

    inner class SchoolViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvWebsite = itemView.findViewById<TextView>(R.id.tvWebsite)
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvCountry = itemView.findViewById<TextView>(R.id.tvCountry)
        val tvDomain = itemView.findViewById<TextView>(R.id.tvDomain)
    }

    private val differCallback = object : DiffUtil.ItemCallback<SchoolsResponseItem>() {
        override fun areItemsTheSame(
            oldItem: SchoolsResponseItem,
            newItem: SchoolsResponseItem
        ): Boolean {
            return oldItem.web_pages == newItem.web_pages
        }

        override fun areContentsTheSame(
            oldItem: SchoolsResponseItem,
            newItem: SchoolsResponseItem
        ): Boolean {
           return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        return SchoolViewHolder(
            LayoutInflater.from(parent.context).inflate(
               R.layout.item_school_preview,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val schoolsResponseItem = differ.currentList[position]
        holder.tvWebsite.text = schoolsResponseItem.web_pages.toString()
        holder.tvName.text = schoolsResponseItem.name
        holder.tvCountry.text = schoolsResponseItem.country
        holder.tvDomain.text = schoolsResponseItem.domains.toString()

        holder.itemView.apply {
           setOnClickListener {
                onItemClickListener?.let { it(schoolsResponseItem) }
            }
        }
    }

    private var onItemClickListener: ((SchoolsResponseItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (SchoolsResponseItem) -> Unit) {
        onItemClickListener = listener
    }
}