package de.bornholdtlee.defaultprojectkotlin.ui.setup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.databinding.FragmentSetupBinding
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory
import de.bornholdtlee.defaultprojectkotlin.ui.BaseFragment
import de.bornholdtlee.defaultprojectkotlin.ui.dialogs.select.SelectCategoryDialog
import de.bornholdtlee.defaultprojectkotlin.utils.Logger
import de.bornholdtlee.defaultprojectkotlin.utils.viewBinding
import java.text.FieldPosition

class SetupFragment : BaseFragment(R.layout.fragment_setup) {

    private val binding by viewBinding(FragmentSetupBinding::bind)
    private val viewModel by viewModels<SetupViewModel>()
    private val adapter = SetupAdapter(:: onClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("SetupFragment")

        viewModel.initCategories()
        setObservers()
        setupGridAdapter()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.setupMenuFab.setOnClickListener {
//            SelectCategoryDialog.show(childFragmentManager) { selectedCategory -> onCategorySelected(FoodCategory.RANDOM, selectedCategory) }
        }
    }

    private fun setObservers() {
        viewModel.categories.observe(viewLifecycleOwner) { categories -> setCategories(categories) }
    }

    private fun setCategories(categories: List<FoodCategory>) {
        adapter.submitList(categories)
//        adapter.setData(categories)
    }

    private fun setupGridAdapter() {
        GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false).apply {
            binding.setupRv.layoutManager = this
        }
        binding.setupRv.adapter = adapter
    }

    private fun onClick(oldCategory: FoodCategory, position: Int) {
        SelectCategoryDialog.show(childFragmentManager) { selectedCategory -> onCategorySelected(position, selectedCategory) }
    }

    private fun onCategorySelected(oldPosition: Int, selectedCategory: FoodCategory) {
        viewModel.applySelectedCategory(oldPosition, selectedCategory)
        Toast.makeText(requireContext(), "oldPosition: $oldPosition, selectedCat: ${selectedCategory.name}", Toast.LENGTH_SHORT).show()
    }
}
