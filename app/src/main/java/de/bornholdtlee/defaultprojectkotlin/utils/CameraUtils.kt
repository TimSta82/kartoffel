package de.bornholdtlee.defaultprojectkotlin.utils

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import de.bornholdtlee.defaultprojectkotlin.KEY_FILEPROVIDER
import java.io.File

object CameraUtils {

    fun checkCameraAvailable(context: Context): Boolean = context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)

    fun takePhoto(fragment: Fragment, fileName: String, requestCode: Int) {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { it.putExtra(MediaStore.EXTRA_SCREEN_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) }
        val context = fragment.requireContext()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val imageUri = FileProvider.getUriForFile(context, context.packageName + KEY_FILEPROVIDER, File(context.filesDir, fileName))
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        } else {
            val imageFile = File(context.externalCacheDir, fileName)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile))
        }

        if (takePictureIntent.resolveActivity(context.packageManager) != null) fragment.startActivityForResult(takePictureIntent, requestCode)
    }
}
