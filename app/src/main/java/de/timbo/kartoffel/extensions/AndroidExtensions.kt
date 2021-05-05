package de.timbo.kartoffel.extensions

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Fragment.showKeyboard(textInputEditText: TextInputEditText) {
    textInputEditText.requestFocus()
    textInputEditText.isFocusableInTouchMode = true

    val inputMethodManager: InputMethodManager? = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputMethodManager?.showSoftInput(textInputEditText, InputMethodManager.SHOW_FORCED)
}

fun Activity.hideKeyboard() {
    if (currentFocus == null) View(this) else currentFocus?.let { hideKeyboard(it) }
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Fragment.showSnackBar(message: String, length: Int = Snackbar.LENGTH_SHORT) {
    require(length in -2..0) { "No valid Snackbar show length" }
    Snackbar.make(requireView(), message, length).show()
}

fun Fragment.showSnackBar(@StringRes messageStringRes: Int, length: Int = Snackbar.LENGTH_SHORT) {
    require(length in -2..0) { "No valid Snackbar show length" }
    Snackbar.make(requireView(), messageStringRes, length).show()
}

fun Snackbar.setMaxLines(lines: Int): Snackbar {
    val textView = this.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
    textView.maxLines = lines
    return this
}

fun ViewModel.launch(block: suspend CoroutineScope.() -> Unit): Job = viewModelScope.launch { block(this) }

fun Fragment.navigate(destination: NavDirections) = findNavController().navigate(destination)

fun Fragment.navigateUp() = findNavController().navigateUp()

fun Fragment.getColorByRes(@ColorRes colorRes: Int) = ContextCompat.getColor(requireContext(), colorRes)

fun Activity.getColorByRes(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)

fun Context.isNetworkConnected(): Boolean {
    (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).apply {
        return getNetworkCapabilities(activeNetwork)?.run {
            when {
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } ?: false
    }
}

fun String.toMcFace() = "${this}y Mc${this}Face"
