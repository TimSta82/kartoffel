package de.timbo.kartoffel.ui.setup.suggestion

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

class SuggestionAdapter() : RecyclerView.Adapter<SuggestionAdapter.SelectViewHolder>() {

    private var suggestedRecipes = emptyList<List<Recipe>>()

    fun setData(recipes: List<List<Recipe>>) {
        suggestedRecipes = recipes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectViewHolder {
        return SelectViewHolder(SwipeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SelectViewHolder, position: Int) {
        holder.bind(suggestedRecipes[position])
    }

    override fun getItemCount() = suggestedRecipes.size

    inner class SelectViewHolder(private val ib: SwipeListItemBinding) : RecyclerView.ViewHolder(ib.root) {
        fun bind(recipes: List<Recipe>) {
            val flipView = ib.swipeFlipContainer
            flipView.setToHorizontalType()

            /** Front */
            val tv1 = flipView.findViewById<TextView>(R.id.first_Tv)
            val iv1 = flipView.findViewById<ImageView>(R.id.first_Iv)
            val rl1 = flipView.findViewById<RelativeLayout>(R.id.relativeLayout1)

            val tv2 = flipView.findViewById<TextView>(R.id.second_Tv)
            val iv2 = flipView.findViewById<ImageView>(R.id.second_Iv)
            val rl2 = flipView.findViewById<RelativeLayout>(R.id.relativeLayout2)

            val tv3 = flipView.findViewById<TextView>(R.id.third_Tv)
            val iv3 = flipView.findViewById<ImageView>(R.id.third_Iv)
            val rl3 = flipView.findViewById<RelativeLayout>(R.id.relativeLayout3)

            val tv4 = flipView.findViewById<TextView>(R.id.fourth_Tv)
            val iv4 = flipView.findViewById<ImageView>(R.id.fourth_Iv)
            val rl4 = flipView.findViewById<RelativeLayout>(R.id.relativeLayout4)

            val tv5 = flipView.findViewById<TextView>(R.id.fifth_Tv)
            val iv5 = flipView.findViewById<ImageView>(R.id.fifth_Iv)
            val rl5 = flipView.findViewById<RelativeLayout>(R.id.relativeLayout5)

            val tv6 = flipView.findViewById<TextView>(R.id.six_Tv)
            val iv6 = flipView.findViewById<ImageView>(R.id.six_Iv)
            val rl6 = flipView.findViewById<RelativeLayout>(R.id.relativeLayout6)

            val tv7 = flipView.findViewById<TextView>(R.id.seven_Tv)
            val iv7 = flipView.findViewById<ImageView>(R.id.seven_Iv)
            val rl7 = flipView.findViewById<RelativeLayout>(R.id.relativeLayout7)

            /** BACK */
            val backTitle = flipView.findViewById<TextView>(R.id.swipe_list_item_back_title_Tv)
            val backImage = flipView.findViewById<ImageView>(R.id.swipe_list_item_back_Iv)
            val backMinutesIv = flipView.findViewById<ImageView>(R.id.swipe_list_item_back_minutes_Iv)
            val backMinutesTv = flipView.findViewById<TextView>(R.id.swipe_list_item_back_minutes_Tv)
            val backLikesIv = flipView.findViewById<ImageView>(R.id.swipe_list_item_back_likes_Iv)
            val backLikesTv = flipView.findViewById<TextView>(R.id.swipe_list_item_back_likes_Tv)
            val backScoreIv = flipView.findViewById<ImageView>(R.id.swipe_list_item_back_score_Iv)
            val backScoreTv = flipView.findViewById<TextView>(R.id.swipe_list_item_back_score_Tv)



            if (recipes.isNotEmpty()) {
                prepareItem(tv1, iv1, rl1, recipes[0], ib, backTitle, backImage, backMinutesIv, backMinutesTv, backLikesIv, backLikesTv, backScoreIv, backScoreTv)
                prepareItem(tv2, iv2, rl2, recipes[1], ib, backTitle, backImage, backMinutesIv, backMinutesTv, backLikesIv, backLikesTv, backScoreIv, backScoreTv)
                prepareItem(tv3, iv3, rl3, recipes[2], ib, backTitle, backImage, backMinutesIv, backMinutesTv, backLikesIv, backLikesTv, backScoreIv, backScoreTv)
                prepareItem(tv4, iv4, rl4, recipes[3], ib, backTitle, backImage, backMinutesIv, backMinutesTv, backLikesIv, backLikesTv, backScoreIv, backScoreTv)
                prepareItem(tv5, iv5, rl5, recipes[4], ib, backTitle, backImage, backMinutesIv, backMinutesTv, backLikesIv, backLikesTv, backScoreIv, backScoreTv)
                prepareItem(tv6, iv6, rl6, recipes[5], ib, backTitle, backImage, backMinutesIv, backMinutesTv, backLikesIv, backLikesTv, backScoreIv, backScoreTv)
                prepareItem(tv7, iv7, rl7, recipes[6], ib, backTitle, backImage, backMinutesIv, backMinutesTv, backLikesIv, backLikesTv, backScoreIv, backScoreTv)
            }
        }
    }

    private fun prepareItem(tv: TextView, iv: ImageView, rl: RelativeLayout, recipe: Recipe, binding: SwipeListItemBinding, backTitle: TextView, backImage: ImageView,
                            backMinutesIv: ImageView, backMinutesTv: TextView, backLikesIv: ImageView, backLikesTv: TextView, backScoreIv: ImageView, backScoreTv: TextView) {
        tv.text = recipe.title
        iv.load(recipe.image)
        rl.setOnClickListener {
            binding.swipeFlipContainer.flipTheView()
            backTitle.text = recipe.title
            backImage.load(recipe.image) {
                crossfade(600)
                error(R.drawable.fashion_guru)
            }
            backMinutesTv.text = recipe.readyInMinutes.toString()
            backLikesTv.text = recipe.aggregateLikes.toString()
            backScoreTv.text = recipe.healthScore.toString()
//            val textView = binding.swipeFlipContainer.findViewById<TextView>(R.id.swipe_list_item_back_title_Tv)
//            textView.text = recipe.title
//            onClick(recipe)
        }
    }
}
