package de.bornholdtlee.defaultprojectkotlin.ui.recipes.current

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.databinding.FragmentCurrentBinding
import de.bornholdtlee.defaultprojectkotlin.model.Recipe
import de.bornholdtlee.defaultprojectkotlin.ui.BaseFragment
import de.bornholdtlee.defaultprojectkotlin.utils.Logger
import de.bornholdtlee.defaultprojectkotlin.utils.viewBinding

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
