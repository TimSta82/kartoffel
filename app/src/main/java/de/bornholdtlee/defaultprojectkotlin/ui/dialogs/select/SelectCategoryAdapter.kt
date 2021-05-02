package de.bornholdtlee.defaultprojectkotlin.ui.dialogs.select

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.bornholdtlee.defaultprojectkotlin.databinding.ListItemCategoryBinding
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory

class SelectCategoryAdapter(private val onClick: (FoodCategory) -> Unit) : RecyclerView.Adapter<SelectCategoryAdapter.SelectCategoryViewHolder>() {

    private var queries = emptyList<FoodCategory>()

    inner class SelectCategoryViewHolder(private val itemBinding: ListItemCategoryBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: FoodCategory) {
            itemBinding.listItemCategoryIv.setImageResource(category.imageResId)
            itemBinding.listItemCategoryTv.text = category.query
            itemBinding.root.setOnClickListener {
                onClick(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectCategoryViewHolder {
        return SelectCategoryViewHolder(ListItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SelectCategoryViewHolder, position: Int) {
        holder.bind(queries[position])
    }

    override fun getItemCount() = queries.size

    fun setData(categories: List<FoodCategory>) {
        queries = categories
        notifyDataSetChanged()
    }
}