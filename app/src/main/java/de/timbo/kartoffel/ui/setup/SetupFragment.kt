package de.timbo.kartoffel.ui.setup

import android.os.Bundle
import android.view.View
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.FragmentSetupBinding
import de.timbo.kartoffel.ui.BaseFragment
import de.timbo.kartoffel.ui.setup.categories.CategoriesFragment
import de.timbo.kartoffel.ui.setup.suggestion.SuggestionFragment
import de.timbo.kartoffel.utils.Logger
import de.timbo.kartoffel.utils.viewBinding

class SetupFragment : BaseFragment(R.layout.fragment_setup) {

    private val binding by viewBinding(FragmentSetupBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Logger.debug("onViewCreated() called")

        binding.setupFlipFragmentContainer.setToHorizontalType()
        childFragmentManager.beginTransaction()
            .replace(R.id.setup_back_suggestion, SuggestionFragment())
            .replace(R.id.setup_front_categories, CategoriesFragment())
            .commit()
    }

    fun flipTheView() {
        binding.setupFlipFragmentContainer.flipTheView()
    }
}