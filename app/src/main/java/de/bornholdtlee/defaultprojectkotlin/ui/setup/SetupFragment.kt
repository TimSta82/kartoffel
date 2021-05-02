package de.bornholdtlee.defaultprojectkotlin.ui.setup

import android.os.Bundle
import android.view.View
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.ui.BaseFragment
import de.bornholdtlee.defaultprojectkotlin.utils.Logger

class SetupFragment : BaseFragment(R.layout.fragment_setup) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("SetupFragment")
    }
}
