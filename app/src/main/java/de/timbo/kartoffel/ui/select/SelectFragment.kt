package de.timbo.kartoffel.ui.select

import android.os.Bundle
import android.view.View
import de.timbo.kartoffel.R
import de.timbo.kartoffel.databinding.FragmentSelectBinding
import de.timbo.kartoffel.ui.BaseFragment
import de.timbo.kartoffel.utils.viewBinding

class SelectFragment : BaseFragment(R.layout.fragment_select) {

    private val binding by viewBinding(FragmentSelectBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}