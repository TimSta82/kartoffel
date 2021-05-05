package de.timbo.kartoffel.ui.setup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.timbo.kartoffel.R

class SetupActivity: AppCompatActivity() {

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, SetupActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_setup)
        supportFragmentManager.beginTransaction()
            .replace(R.id.setup_container_Fcv, SetupFragment())
            .commit()
    }
}