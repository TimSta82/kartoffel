package de.bornholdtlee.defaultprojectkotlin.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.ui.recipes.RecipesActivity
import de.bornholdtlee.defaultprojectkotlin.ui.setup.SetupActivity

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel.checkForRecipes()
        setObservers()
        openSetupActivity()
    }

    private fun setObservers() {
        viewModel.hasRecipes.observe(this) {navigate(it)}
    }

    private fun navigate(hasRecipes: Boolean) {
        if (hasRecipes) openRecipesActivity() else openSetupActivity()
    }

    private fun openRecipesActivity() {
        RecipesActivity.startActivity(this)
        finish()
    }

    private fun openSetupActivity() {
        SetupActivity.startActivity(this)
        finish()
    }
}
