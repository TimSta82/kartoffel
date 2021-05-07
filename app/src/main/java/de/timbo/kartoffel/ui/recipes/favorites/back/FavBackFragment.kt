package de.timbo.kartoffel.ui.recipes.favorites.back

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.FragmentFavBackBinding
import de.timbo.kartoffel.ui.BaseFragment
import de.timbo.kartoffel.ui.recipes.favorites.FavoritesViewModel
import de.timbo.kartoffel.ui.setup.SetupActivity
import de.timbo.kartoffel.utils.Logger
import de.timbo.kartoffel.utils.viewBinding

class FavBackFragment : BaseFragment(R.layout.fragment_fav_back) {

    private val binding by viewBinding(FragmentFavBackBinding::bind)
    private val favoriteViewModel by viewModels<FavoritesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("onViewCreated() called")

        setObservers()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.favBackBtn.setOnClickListener {
            favoriteViewModel.resetRecipes()
        }
    }

    private fun setObservers() {
        favoriteViewModel.proceed.observe(viewLifecycleOwner) { proceed() }
    }

    private fun proceed() {
        SetupActivity.startActivity(requireContext())
        requireActivity().finish()
    }
}
