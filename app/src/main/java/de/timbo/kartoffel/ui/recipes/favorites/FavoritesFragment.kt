package de.timbo.kartoffel.ui.recipes.favorites

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.viewModels
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.FragmentFavoritesBinding
import de.timbo.kartoffel.ui.BaseFragment
import de.timbo.kartoffel.ui.MainActivity
import de.timbo.kartoffel.ui.recipes.favorites.back.FavBackFragment
import de.timbo.kartoffel.ui.recipes.favorites.front.FavFrontFragment
import de.timbo.kartoffel.utils.Logger
import de.timbo.kartoffel.utils.viewBinding

class FavoritesFragment : BaseFragment(R.layout.fragment_favorites) {

    private val binding by viewBinding(FragmentFavoritesBinding::bind)
    private val viewModel by viewModels<FavoritesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("FavoritesFragment")

        binding.favoritesContainerEfv.setToHorizontalType()
        setClickListeners()
        setObservers()

        childFragmentManager.beginTransaction()
            .replace(R.id.fav_front_container, FavFrontFragment())
            .replace(R.id.fav_back_container, FavBackFragment())
            .commit()
    }

    private fun setObservers() {
        viewModel.proceed.observe(viewLifecycleOwner) {
            MainActivity.startActivity(requireContext())
            requireActivity().finish()
        }
    }

    private fun setClickListeners() {
        binding.favoritesFab.setOnClickListener {
            binding.favoritesContainerEfv.flipTheView()
        }
    }
}
