package de.timbo.kartoffel.ui.dialogs.select

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.DialogSelectCategoryBinding
import de.timbo.kartoffel.model.data_types.FoodCategory
import de.timbo.kartoffel.ui.dialogs.BaseDialogFragment
import de.timbo.kartoffel.utils.viewBinding

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
