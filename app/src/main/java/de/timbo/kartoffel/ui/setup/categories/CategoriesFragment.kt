package de.timbo.kartoffel.ui.setup.categories

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.skydoves.balloon.OnBalloonClickListener
import com.skydoves.balloon.balloon
import com.wajahatkarim3.easyflipview.EasyFlipView
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.FragmentCategoriesBinding
import de.timbo.kartoffel.extensions.showSnackBar
import de.timbo.kartoffel.extensions.toMcFace
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.model.data_types.FoodCategory
import de.timbo.kartoffel.ui.BaseFragment
import de.timbo.kartoffel.ui.balloons.ExplainBalloonFactory
import de.timbo.kartoffel.ui.dialogs.select.SelectCategoryDialog
import de.timbo.kartoffel.ui.setup.SetupFragment
import de.timbo.kartoffel.ui.setup.SetupViewModel
import de.timbo.kartoffel.utils.BalloonUtils
import de.timbo.kartoffel.utils.Logger
import de.timbo.kartoffel.utils.viewBinding

/**
 * this is a childFragment of SetupFragment
 */
class CategoriesFragment : BaseFragment(R.layout.fragment_categories), OnBalloonClickListener {

    private val binding by viewBinding(FragmentCategoriesBinding::bind)
    private val setupViewModel by viewModels<SetupViewModel>()
    private val navigationBalloon by lazy { BalloonUtils.getNavigationBalloon(requireContext(), this, this) }
    private val explainBalloon by balloon<ExplainBalloonFactory>()

    private var isFabMenuOpen = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("CategoriesFragment")

        setObservers()
        setClickListeners()
    }

    private fun setObservers() {
        setupViewModel.one.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipOneEfv, it) }
        setupViewModel.two.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipTwoEfv, it) }
        setupViewModel.three.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipThreeEfv, it) }
        setupViewModel.four.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipFourEfv, it) }
        setupViewModel.five.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipFiveEfv, it) }
        setupViewModel.six.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipSixEfv, it) }
        setupViewModel.seven.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipSevenEfv, it) }
        setupViewModel.categoriesResultSuccess.observe(viewLifecycleOwner) { flipToSelectionPreview() } // TODO navigate with data, therefor save recipeIds in DB, then call
        setupViewModel.failure.observe(viewLifecycleOwner) { Toast.makeText(requireContext(), "failure", Toast.LENGTH_SHORT).show() } // TODO think about it
        setupViewModel.isLoading.observe(viewLifecycleOwner, ::showLoadingIndicator)
    }

    private fun flipToSelectionPreview() {
        (parentFragment as SetupFragment).flipTheView() // TODO
    }

    private fun showErrorMessage() {
        showSnackBar("Fail".toMcFace())
    }

    private fun showLoadingIndicator(isLoading: Boolean) {
        binding.categoriesLoadingRl.isVisible = isLoading
    }

    private fun showRecipes(recipes: List<Recipe>) {
        recipes.let {
            it.forEach { recipe ->
                Logger.debug("recipeName: ${recipe.title}")
            }
        }
    }

    private fun setClickListeners() {
        binding.easyFlipOneEfv.setOnClickListener { showDialog(1) }
        binding.easyFlipTwoEfv.setOnClickListener { showDialog(2) }
        binding.easyFlipThreeEfv.setOnClickListener { showDialog(3) }
        binding.easyFlipFourEfv.setOnClickListener { showDialog(4) }
        binding.easyFlipFiveEfv.setOnClickListener { showDialog(5) }
        binding.easyFlipSixEfv.setOnClickListener { showDialog(6) }
        binding.easyFlipSevenEfv.setOnClickListener { showDialog(7) }

        binding.categoriesMenuFab.setOnClickListener { toggleFabMenu() }
        binding.categoriesProceedFab.setOnClickListener { proceed() }
        binding.categoriesSaveFab.setOnClickListener { throw RuntimeException("Test Crash".toMcFace()) }
        binding.categoriesExplainTv.setOnClickListener { showExplainBalloon() }
    }

    private fun showExplainBalloon() {
        if (explainBalloon.isShowing) {
            explainBalloon.dismiss()
        } else {
            explainBalloon.showAlignBottom(binding.categoriesExplainTv)
        }
    }

    private fun proceed() {
        setupViewModel.applyCategories()
        toggleFabMenu()
    }

    private fun toggleFabMenu() {
        if (!isFabMenuOpen) showFabMenu() else hideFabMenu()
    }

    private fun hideFabMenu() {
        binding.categoriesProceedFab.animate().translationY(0F)
        binding.categoriesSaveFab.animate().translationY(0F)
        isFabMenuOpen = isFabMenuOpen.not()
    }

    private fun showFabMenu() {
        binding.categoriesProceedFab.animate().translationY(-resources.getDimension(R.dimen.fab_menu_proceed_distance))
        binding.categoriesSaveFab.animate().translationY(-resources.getDimension(R.dimen.fab_menu_save_distance))
        isFabMenuOpen = isFabMenuOpen.not()
    }

    private fun showDialog(index: Int) {
        SelectCategoryDialog.show(childFragmentManager) { selectedCategory -> onCategorySelected(index, selectedCategory) }
    }

    private fun prepareFlipView(flipView: EasyFlipView, foodCategory: FoodCategory) {
        flipView.flipTheView()
        val oneFrontIv = flipView.findViewById<ImageView>(R.id.easy_flip_front_Iv)
        val oneBackIv = flipView.findViewById<ImageView>(R.id.easy_flip_back_Iv)
        oneFrontIv.setImageResource(foodCategory.imageResId)
        oneBackIv.setImageResource(foodCategory.imageResId)
    }

    private fun onCategorySelected(oldPosition: Int, selectedCategory: FoodCategory) {
        setupViewModel.applySelectedCategory(oldPosition, selectedCategory)
    }

    override fun onBalloonClick(view: View) {
        navigationBalloon.dismiss()
    }
}
