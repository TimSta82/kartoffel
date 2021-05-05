package de.bornholdtlee.defaultprojectkotlin.ui.dialogs.select

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.databinding.DialogSelectCategoryBinding
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory
import de.bornholdtlee.defaultprojectkotlin.ui.dialogs.BaseDialogFragment
import de.bornholdtlee.defaultprojectkotlin.utils.viewBinding

class SelectCategoryDialog(private val onClickSelectNewCategory: (FoodCategory) -> Unit) : BaseDialogFragment(
    layoutResId = R.layout.dialog_select_category,
    dimensionMode = DialogDimensionMode.MATCH_PARENT_WIDTH_AND_HEIGHT
//    backgroundResId = R.drawable.background_dialog_transparent_fullscreen
) {

    private val binding by viewBinding(DialogSelectCategoryBinding::bind)
    private val adapter = SelectCategoryAdapter(::onClick)

    companion object {
        fun show(childFragmentManager: FragmentManager, onClickSelectNewCategory: (FoodCategory) -> Unit) {
            SelectCategoryDialog(onClickSelectNewCategory = onClickSelectNewCategory).show(childFragmentManager, SelectCategoryDialog::class.java.canonicalName)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        adapter.setData(FoodCategory.values().toList())
        binding.dialogCategoryRv.adapter = adapter
    }

    private fun onClick(selectedCategory: FoodCategory) {
        onClickSelectNewCategory(selectedCategory)
        dismiss()
    }
}
