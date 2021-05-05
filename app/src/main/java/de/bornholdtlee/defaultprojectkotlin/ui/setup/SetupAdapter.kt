package de.bornholdtlee.defaultprojectkotlin.ui.setup

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.databinding.GridItemSetupBinding
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory

class SetupAdapter(private val onClick: (FoodCategory, position: Int) -> Unit) :
    ListAdapter<FoodCategory, SetupAdapter.SetupViewHolder>(SetupDiffUtilCallback()) {

//    private var queries = emptyList<FoodCategory>()

    inner class SetupViewHolder(private val itemBinding: GridItemSetupBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: FoodCategory, position: Int) {
            itemBinding.gridItemSetupEfv.setToHorizontalType()
            val imageFront =
                itemBinding.gridItemSetupEfv.findViewById<ImageView>(R.id.easy_flip_front_Iv)
            val imageBack =
                itemBinding.gridItemSetupEfv.findViewById<ImageView>(R.id.easy_flip_back_Iv)
            imageFront.setImageResource(category.imageResId)
            imageBack.setImageResource(category.imageResId)

//            if (category.isFrontSide && itemBinding.gridItemSetupEfv.currentFlipState != EasyFlipView.FlipState.FRONT_SIDE) itemBinding.gridItemSetupEfv.flipTheView()

            itemBinding.root.setOnClickListener { onClick(category, position) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetupViewHolder {
        return SetupViewHolder(
            GridItemSetupBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SetupViewHolder, position: Int) {
//        holder.bind(queries[position])
        holder.bind(getItem(position), position)
    }

//    override fun getItemCount() = queries.size
//
//    fun setData(categories: List<FoodCategory>) {
//        queries = categories
//        notifyDataSetChanged()
//    }
}

private class SetupDiffUtilCallback : DiffUtil.ItemCallback<FoodCategory>() {

    override fun areItemsTheSame(oldItem: FoodCategory, newItem: FoodCategory): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FoodCategory, newItem: FoodCategory): Boolean {
        return /*oldItem.isFrontSide == newItem.isFrontSide && */oldItem.imageResId == newItem.imageResId
    }
}
