package de.timbo.kartoffel.ui.select

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.timbo.kartoffel.R

class SelectActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, SelectActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_select)

        supportFragmentManager.beginTransaction()
            .replace(R.id.select_container_Fcv, SelectFragment())
            .commit()
    }
}