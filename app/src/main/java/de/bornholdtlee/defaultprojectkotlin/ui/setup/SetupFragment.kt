package de.bornholdtlee.defaultprojectkotlin.ui.setup

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.wajahatkarim3.easyflipview.EasyFlipView
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.databinding.FragmentSetupBinding
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory
import de.bornholdtlee.defaultprojectkotlin.ui.BaseFragment
import de.bornholdtlee.defaultprojectkotlin.ui.dialogs.select.SelectCategoryDialog
import de.bornholdtlee.defaultprojectkotlin.utils.Logger
import de.bornholdtlee.defaultprojectkotlin.utils.viewBinding

class SetupFragment : BaseFragment(R.layout.fragment_setup) {

    private val binding by viewBinding(FragmentSetupBinding::bind)
    private val viewModel by viewModels<SetupViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("SetupFragment")

        setObservers()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.easyFlipOneEfv.setOnClickListener { showDialog(1) }
        binding.easyFlipTwoEfv.setOnClickListener { showDialog(2) }
        binding.easyFlipThreeEfv.setOnClickListener { showDialog(3) }
        binding.easyFlipFourEfv.setOnClickListener { showDialog(4) }
        binding.easyFlipFiveEfv.setOnClickListener { showDialog(5) }
        binding.easyFlipSixEfv.setOnClickListener { showDialog(6) }
        binding.easyFlipSevenEfv.setOnClickListener { showDialog(7) }

        binding.setupMenuFab.setOnClickListener {
            viewModel.submitSetup()
        }
    }

    private fun showDialog(index: Int) {
        SelectCategoryDialog.show(childFragmentManager) { selectedCategory -> onCategorySelected(index, selectedCategory) }
    }

    private fun setObservers() {
        viewModel.one.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipOneEfv, it) }
        viewModel.two.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipTwoEfv, it) }
        viewModel.three.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipThreeEfv, it) }
        viewModel.four.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipFourEfv, it) }
        viewModel.five.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipFiveEfv, it) }
        viewModel.six.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipSixEfv, it) }
        viewModel.seven.observe(viewLifecycleOwner) { prepareFlipView(binding.easyFlipSevenEfv, it) }
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
//        Toast.makeText(requireContext(), "oldPosition: $oldPosition, selectedCat: ${selectedCategory.name}", Toast.LENGTH_SHORT).show()
    }
}
