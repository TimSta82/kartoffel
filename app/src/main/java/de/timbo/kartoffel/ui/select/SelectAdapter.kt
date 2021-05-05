package de.timbo.kartoffel.ui.select

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.SwipeListItemBinding
import de.timbo.kartoffel.model.Recipe

class SelectAdapter(private val recipes: List<List<Recipe>>, private val onClick: (Recipe) -> Unit) : RecyclerView.Adapter<SelectAdapter.SelectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectAdapter.SelectViewHolder {
        return SelectViewHolder(SwipeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SelectAdapter.SelectViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount() = recipes[0].size

    inner class SelectViewHolder(private val ib: SwipeListItemBinding) : RecyclerView.ViewHolder(ib.root) {
        fun bind(recipes: List<Recipe>) {
            ib.swipeFlipContainer.setToHorizontalType()
            val tv1 = ib.swipeFlipContainer.findViewById<TextView>(R.id.first_Tv)
            val iv1 = ib.swipeFlipContainer.findViewById<ImageView>(R.id.first_Iv)
            val rl1 = ib.swipeFlipContainer.findViewById<RelativeLayout>(R.id.relativeLayout1)

            val tv2 = ib.swipeFlipContainer.findViewById<TextView>(R.id.second_Tv)
            val iv2 = ib.swipeFlipContainer.findViewById<ImageView>(R.id.second_Iv)
            val rl2 = ib.swipeFlipContainer.findViewById<RelativeLayout>(R.id.relativeLayout2)

            val tv3 = ib.swipeFlipContainer.findViewById<TextView>(R.id.third_Tv)
            val iv3 = ib.swipeFlipContainer.findViewById<ImageView>(R.id.third_Iv)
            val rl3 = ib.swipeFlipContainer.findViewById<RelativeLayout>(R.id.relativeLayout3)

            val tv4 = ib.swipeFlipContainer.findViewById<TextView>(R.id.fourth_Tv)
            val iv4 = ib.swipeFlipContainer.findViewById<ImageView>(R.id.fourth_Iv)
            val rl4 = ib.swipeFlipContainer.findViewById<RelativeLayout>(R.id.relativeLayout4)

            val tv5 = ib.swipeFlipContainer.findViewById<TextView>(R.id.fifth_Tv)
            val iv5 = ib.swipeFlipContainer.findViewById<ImageView>(R.id.fifth_Iv)
            val rl5 = ib.swipeFlipContainer.findViewById<RelativeLayout>(R.id.relativeLayout5)

            val tv6 = ib.swipeFlipContainer.findViewById<TextView>(R.id.six_Tv)
            val iv6 = ib.swipeFlipContainer.findViewById<ImageView>(R.id.six_Iv)
            val rl6 = ib.swipeFlipContainer.findViewById<RelativeLayout>(R.id.relativeLayout6)

            val tv7 = ib.swipeFlipContainer.findViewById<TextView>(R.id.seven_Tv)
            val iv7 = ib.swipeFlipContainer.findViewById<ImageView>(R.id.seven_Iv)
            val rl7 = ib.swipeFlipContainer.findViewById<RelativeLayout>(R.id.relativeLayout7)

            prepareItem(tv1, iv1, rl1, recipes[0], ib)
            prepareItem(tv2, iv2, rl2, recipes[1], ib)
            prepareItem(tv3, iv3, rl3, recipes[2], ib)
            prepareItem(tv4, iv4, rl4, recipes[3], ib)
            prepareItem(tv5, iv5, rl5, recipes[4], ib)
            prepareItem(tv6, iv6, rl6, recipes[5], ib)
            prepareItem(tv7, iv7, rl7, recipes[6], ib)
        }
    }

    private fun prepareItem(tv: TextView, iv: ImageView, rl: RelativeLayout, recipe: Recipe, binding: SwipeListItemBinding) {
        tv.text = recipe.title
        iv.load(R.drawable.ic_cheap)
        rl.setOnClickListener {
            binding.swipeFlipContainer.flipTheView()
            val textView = binding.swipeFlipContainer.findViewById<TextView>(R.id.swipe_list_item_back_Tv)
            textView.text = recipe.title
            onClick(recipe)
        }
    }

}