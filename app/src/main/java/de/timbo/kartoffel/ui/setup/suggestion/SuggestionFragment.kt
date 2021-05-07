package de.timbo.kartoffel.ui.setup.suggestion

import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import com.yuyakaido.android.cardstackview.*
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.FragmentSuggestionBinding
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.ui.BaseFragment
import de.timbo.kartoffel.ui.recipes.RecipesActivity
import de.timbo.kartoffel.ui.setup.SetupFragment
import de.timbo.kartoffel.ui.setup.SetupViewModel
import de.timbo.kartoffel.utils.DefaultRecipe
import de.timbo.kartoffel.utils.Logger
import de.timbo.kartoffel.utils.viewBinding

/**
 * this is a childFragment of SetupFragment
 */
class SuggestionFragment : BaseFragment(R.layout.fragment_suggestion), CardStackListener {

    private val binding by viewBinding(FragmentSuggestionBinding::bind)
    private val setupViewModel by viewModels<SetupViewModel>()

    private val cardStackView by lazy { binding.cardStackView.findViewById<CardStackView>(R.id.card_stack_view) }
    private val manager by lazy { CardStackLayoutManager(requireContext(), this) }

    private val adapter = SuggestionAdapter()
    //    private val adapter by lazy { SuggestionAdapter() }
//
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Logger.debug("onViewCreated() called -> suggestion")
        setObservers()
        setClickListeners()
        setupCardStackView()
    }

    private fun setObservers() {
        setupViewModel.suggestedRecipes.observe(viewLifecycleOwner) { suggestedRecipes -> displayRecipes(suggestedRecipes) } // TODO attach within SelectionFragment
    }

    private fun displayRecipes(suggestedRecipes: List<List<Recipe>>) {
        suggestedRecipes.first().forEach { recipe ->
            Logger.debug("recipe: ${recipe.title}")
        }
        adapter.setData(suggestedRecipes)
    }

    private fun setClickListeners() {
        binding.likeButton.setOnClickListener { onStartRecipesActivity() }
        binding.skipButton.setOnClickListener { (parentFragment as SetupFragment).flipTheView() }
    }

    private fun onStartRecipesActivity() {
        RecipesActivity.startActivity(requireContext())
        requireActivity().finish()
    }

    private fun setupCardStackView() {
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(1)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())

        cardStackView.layoutManager = manager
        cardStackView.adapter = adapter
        cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        Logger.debug("onCardDragging -> direction: $direction")
    }

    override fun onCardSwiped(direction: Direction?) {
        Logger.debug("onCardSwiped -> direction: $direction")
        when (direction) {
            Direction.Right -> {
                onStartRecipesActivity()
            }
            Direction.Left -> {
                (parentFragment as SetupFragment).flipTheView()
            }
            else -> Logger.debug("onCardSwiped: unsupported direction: $direction")
        }
    }

    override fun onCardRewound() {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
        Logger.debug("onCardAppeared() called")
//        val textView = binding.selectEasyFlipContainer.findViewById<TextView>(R.id.item_name)
//        Logger.debug("CardStackView - onCardAppeared: ($position) ${textView.text}")
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        Logger.debug("onCardDisappeared() called")
    }

    private fun createRecipes(): List<List<Recipe>> {
        return listOf(
            listOf(
                DefaultRecipe.recipe,
                DefaultRecipe.recipe.copy(title = "Nasenbär"),
                DefaultRecipe.recipe.copy(title = "Egon"),
                DefaultRecipe.recipe.copy(title = "Grütze"),
                DefaultRecipe.recipe.copy(title = "Nasenbär"),
                DefaultRecipe.recipe.copy(title = "Egon"),
                DefaultRecipe.recipe.copy(title = "Grütze")
            )
        )
    }
}