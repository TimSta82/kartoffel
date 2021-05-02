package de.bornholdtlee.defaultprojectkotlin.ui.favorites

import android.os.Bundle
import android.view.View
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.ui.BaseFragment
import de.bornholdtlee.defaultprojectkotlin.utils.Logger

class FavoritesFragment : BaseFragment(R.layout.fragment_favorites) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.debug("FavoritesFragment")
    }
}
