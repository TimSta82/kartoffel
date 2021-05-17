package de.timbo.kartoffel.ui.setup.suggestion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.SwipeItemFrontXBinding
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.utils.Logger

class RecipesAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(private val ib: SwipeItemFrontXBinding) : RecyclerView.ViewHolder(ib.root) {
        fun bind(recipe: Recipe) {
            ib.firstIv.load(recipe.image) {
                crossfade(600)
                error(R.drawable.fashion_guru)
            }
            ib.firstTv.text = recipe.title
            ib.firstRl.setOnClickListener {
                Logger.debug("title: ${recipe.title}")
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(SwipeItemFrontXBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount() = recipes.size
}
