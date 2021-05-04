package de.bornholdtlee.defaultprojectkotlin.ui.favorites

import android.os.Bundle
import android.view.View
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.databinding.FragmentFavoritesBinding
import de.bornholdtlee.defaultprojectkotlin.ui.BaseFragment
import de.bornholdtlee.defaultprojectkotlin.utils.Logger
import de.bornholdtlee.defaultprojectkotlin.utils.viewBinding

class FavoritesFragment : BaseFragment(R.layout.fragment_favorites) {

    private val binding by viewBinding(FragmentFavoritesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("FavoritesFragment")

        binding.favoritesContainerEfv.setToHorizontalType()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.favoritesFab.setOnClickListener {
            binding.favoritesContainerEfv.flipTheView()
        }
    }
}
