package de.bornholdtlee.defaultprojectkotlin.ui

import android.content.Context
import android.content.Intent
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
import de.bornholdtlee.defaultprojectkotlin.utils.Logger

class MainActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel.checkForRecipes()
        setObservers()
    }

    private fun setObservers() {
        viewModel.hasRecipes.observe(this) { hasRecipes -> navigate(hasRecipes)}
    }

    private fun navigate(hasRecipes: Boolean) {
        Logger.debug("hasRecipes: $hasRecipes")
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
