package de.timbo.kartoffel.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Build
import androidx.exifinterface.media.ExifInterface
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File

object ImageUtils {

    private const val MAX_SIZE = 1600

    fun getProcessedBitmap(context: Context, fileName: String) = getBitmapInPortraitMode(getFile(context, fileName))

    fun processBitmap(bitmap: Bitmap): Bitmap {
        return resizeAndCompress(bitmap)
    }

    private fun getBitmapInPortraitMode(file: File): Bitmap {
        return resizeAndCompress(rotateBitmap(BitmapFactory.decodeFile(file.absolutePath), ExifInterface(file.absolutePath)))
    }

    private fun resizeAndCompress(bitmap: Bitmap): Bitmap {
        val ratioBitmap = bitmap.width.toFloat() / bitmap.height.toFloat()

        var finalWidth = MAX_SIZE
        var finalHeight = MAX_SIZE
        if (1 > ratioBitmap) {
            finalWidth = (MAX_SIZE.toFloat() * ratioBitmap).toInt()
        } else {
            finalHeight = (MAX_SIZE.toFloat() / ratioBitmap).toInt()
        }
        ByteArrayOutputStream().use {
            Bitmap.createScaledBitmap(bitmap, finalWidth, finalHeight, false).compress(Bitmap.CompressFormat.JPEG, 90, it)
            return BitmapFactory.decodeStream(ByteArrayInputStream(it.toByteArray()))
        }
    }

    private fun rotateBitmap(bitmap: Bitmap, ei: ExifInterface): Bitmap = when (ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)) {
        ExifInterface.ORIENTATION_ROTATE_90 -> rotateImage(bitmap, 90f)
        ExifInterface.ORIENTATION_ROTATE_180 -> rotateImage(bitmap, 180f)
        ExifInterface.ORIENTATION_ROTATE_270 -> rotateImage(bitmap, 270f)
        else -> bitmap
    }

    private fun rotateImage(source: Bitmap, angle: Float): Bitmap {
        val matrix = Matrix()
        if (angle > 0) matrix.postRotate(angle)
        return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
    }

    private fun getFile(context: Context, fileName: String) = File(if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) context.filesDir else context.externalCacheDir, fileName)
}
