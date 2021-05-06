package de.timbo.kartoffel.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import de.timbo.kartoffel.R
import de.timbo.kartoffel.ui.recipes.RecipesActivity
import de.timbo.kartoffel.ui.setup.SetupActivity
import de.timbo.kartoffel.utils.Logger

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

/**
 * TODO substitute loading with confetti
 * https://github.com/DanielMartinus/Konfetti
 * attention: see license
 */
