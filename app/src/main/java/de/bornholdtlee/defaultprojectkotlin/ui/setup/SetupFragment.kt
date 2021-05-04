package de.bornholdtlee.defaultprojectkotlin.ui.setup

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.wajahatkarim3.easyflipview.EasyFlipView
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.databinding.FragmentSetupBinding
import de.bornholdtlee.defaultprojectkotlin.extensions.showSnackBar
import de.bornholdtlee.defaultprojectkotlin.model.Recipe
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory
import de.bornholdtlee.defaultprojectkotlin.ui.BaseFragment
import de.bornholdtlee.defaultprojectkotlin.ui.dialogs.select.SelectCategoryDialog
import de.bornholdtlee.defaultprojectkotlin.utils.Logger
import de.bornholdtlee.defaultprojectkotlin.utils.viewBinding

class SetupFragment : BaseFragment(R.layout.fragment_setup) {

    private val binding by viewBinding(FragmentSetupBinding::bind)
    private val viewModel by viewModels<SetupViewModel>()

    private var isFabMenuOpen = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("SetupFragment")

        setObservers()
        setClickListeners()
    }

    private fun setObservers() {
        viewModel.one.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipOneEfv, it) }
        viewModel.two.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipTwoEfv, it) }
        viewModel.three.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipThreeEfv, it) }
        viewModel.four.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipFourEfv, it) }
        viewModel.five.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipFiveEfv, it) }
        viewModel.six.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipSixEfv, it) }
        viewModel.seven.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipSevenEfv, it) }
        viewModel.recipes.observe(viewLifecycleOwner) { recipes -> showRecipes(recipes) }
        viewModel.failure.observe(viewLifecycleOwner) { showErrorMessage() }
        viewModel.isLoading.observe(viewLifecycleOwner, ::showLoadingIndicator)
    }

    private fun showErrorMessage() {
        showSnackBar("Faily McFailface")
    }

    private fun showLoadingIndicator(isLoading: Boolean) {
        binding.setupLoadingRl.isVisible = isLoading
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

        binding.setupMenuFab.setOnClickListener { toggleFabMenu() }
        binding.setupProceedFab.setOnClickListener { proceed() }
        binding.setupSaveFab.setOnClickListener { Toast.makeText(requireContext(), "TODO -> save", Toast.LENGTH_SHORT).show() }
    }

    private fun proceed() {
        viewModel.submitSetup()
        toggleFabMenu()
    }

    private fun toggleFabMenu() {
        if (!isFabMenuOpen) showFabMenu() else hideFabMenu()
    }

    private fun hideFabMenu() {
        binding.setupProceedFab.animate().translationY(0F)
        binding.setupSaveFab.animate().translationY(0F)
        isFabMenuOpen = isFabMenuOpen.not()
    }

    private fun showFabMenu() {
        binding.setupProceedFab.animate().translationY(-resources.getDimension(R.dimen.fab_menu_proceed_distance))
        binding.setupSaveFab.animate().translationY(-resources.getDimension(R.dimen.fab_menu_save_distance))
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
        viewModel.applySelectedCategory(oldPosition, selectedCategory)
    }
}
