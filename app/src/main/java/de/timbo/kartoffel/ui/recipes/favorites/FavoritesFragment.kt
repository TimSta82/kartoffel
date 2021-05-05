package de.bornholdtlee.defaultprojectkotlin.ui.recipes.favorites

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.databinding.FragmentFavoritesBinding
import de.bornholdtlee.defaultprojectkotlin.ui.BaseFragment
import de.bornholdtlee.defaultprojectkotlin.ui.MainActivity
import de.bornholdtlee.defaultprojectkotlin.utils.Logger
import de.bornholdtlee.defaultprojectkotlin.utils.viewBinding

class FavoritesFragment : BaseFragment(R.layout.fragment_favorites) {

    private val binding by viewBinding(FragmentFavoritesBinding::bind)
    private val viewModel by viewModels<FavoritesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("FavoritesFragment")

        binding.favoritesContainerEfv.setToHorizontalType()
        setClickListeners()
        setObservers()
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
        val tvBack = binding.favoritesContainerEfv.findViewById<TextView>(R.id.textView3)
        tvBack.setOnClickListener {
            viewModel.resetRecipes()
        }
    }
}
