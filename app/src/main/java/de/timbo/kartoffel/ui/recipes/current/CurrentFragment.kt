package de.timbo.kartoffel.ui.recipes.current

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.FragmentCurrentBinding
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.ui.BaseFragment
import de.timbo.kartoffel.utils.Logger
import de.timbo.kartoffel.utils.viewBinding

class CurrentFragment : BaseFragment(R.layout.fragment_current) {

    private val viewModel by viewModels<CurrentViewModel>()
    private val binding by viewBinding(FragmentCurrentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("CurrentFragment")

        setObservers()
    }

    private fun setObservers() {
        viewModel.recipes.observe(viewLifecycleOwner) { recipes -> setRecipes(recipes) }
    }

    private fun setRecipes(recipes: List<Recipe>) {
        binding.textView.text = recipes.toString()
    }
}
