package de.bornholdtlee.defaultprojectkotlin.ui.setup

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.databinding.GridItemSetupBinding
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory

class SetupAdapter/*(private val onClick: () -> Unit)*/ : RecyclerView.Adapter<SetupAdapter.SetupViewHolder>() {

    private var queries = emptyList<FoodCategory>()

    inner class SetupViewHolder(private val itemBinding: GridItemSetupBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: FoodCategory) {
            itemBinding.gridItemSetupEfv.setToHorizontalType()
            if (itemBinding.gridItemSetupEfv.isFrontSide) {
                val imageFront = itemBinding.gridItemSetupEfv.findViewById<ImageView>(R.id.easy_flip_front_Iv)
                imageFront.setImageResource(FoodCategory.CHICKEN.imageResId)
            } else {
                val imageBack = itemBinding.gridItemSetupEfv.findViewById<ImageView>(R.id.easy_flip_back_Iv)
                imageBack.setImageResource(FoodCategory.RANDOM.imageResId)
            }

            itemBinding.root.setOnClickListener {
                itemBinding.gridItemSetupEfv.flipTheView()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetupViewHolder {
        return SetupViewHolder(GridItemSetupBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SetupViewHolder, position: Int) {
        holder.bind(queries[position])
    }

    override fun getItemCount() = queries.size

    fun setData(categories: List<FoodCategory>) {
        queries = categories
        notifyDataSetChanged()
    }
}