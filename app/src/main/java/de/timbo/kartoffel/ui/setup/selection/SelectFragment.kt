package de.timbo.kartoffel.ui.setup.selection

import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import com.yuyakaido.android.cardstackview.*
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.FragmentSelectBinding
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.ui.BaseFragment
import de.timbo.kartoffel.ui.recipes.RecipesActivity
import de.timbo.kartoffel.ui.setup.SetupActivity
import de.timbo.kartoffel.utils.DefaultRecipe
import de.timbo.kartoffel.utils.Logger
import de.timbo.kartoffel.utils.viewBinding

class SelectFragment : BaseFragment(R.layout.fragment_select), CardStackListener {

    private val binding by viewBinding(FragmentSelectBinding::bind)
    private val cardStackView by lazy { binding.cardStackView.findViewById<CardStackView>(R.id.card_stack_view) }
    private val manager by lazy { CardStackLayoutManager(requireContext(), this) }
    private val adapter by lazy { SelectAdapter(createRecipes(), ::onClick) }

    private lateinit var tvBack: TextView

//    private lateinit var cardStackView: CardStackView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setClickListeners()
        setupCardStackView()
    }

    private fun setClickListeners() {
        binding.likeButton.setOnClickListener { onStartRecipesActivity() }
        binding.skipButton.setOnClickListener { onStartSetupActivity() }
    }

    private fun onStartSetupActivity() {
        SetupActivity.startActivity(requireContext())
        requireActivity().finish()
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

    private fun initViews() {
//        binding.selectEasyFlipContainer.setToHorizontalType()
        // front

        // back
//        tvBack = binding.selectEasyFlipContainer.findViewById<TextView>(R.id.card_stack_back_Tv)
    }

    private fun onClick(recipe: Recipe) {
//        binding.selectEasyFlipContainer.flipTheView()
//        if (binding.selectEasyFlipContainer.isBackSide) tvBack.text = recipe.title
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
                onStartSetupActivity()
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