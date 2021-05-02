package de.bornholdtlee.defaultprojectkotlin.ui.setup

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.databinding.FragmentSetupBinding
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory
import de.bornholdtlee.defaultprojectkotlin.ui.BaseFragment
import de.bornholdtlee.defaultprojectkotlin.utils.Logger
import de.bornholdtlee.defaultprojectkotlin.utils.viewBinding

class SetupFragment : BaseFragment(R.layout.fragment_setup) {

    private val binding by viewBinding(FragmentSetupBinding::bind)
    private val adapter = SetupAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("SetupFragment")

        setupGridAdapter()
    }

    private fun setupGridAdapter() {
        GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false).apply {
            binding.setupRv.layoutManager = this
        }
        binding.setupRv.adapter = adapter
        val randCat = FoodCategory.RANDOM
        val categories = listOf(randCat, randCat, randCat, randCat, randCat, randCat, randCat, FoodCategory.MYSTERY)
        adapter.setData(categories)
    }
}
