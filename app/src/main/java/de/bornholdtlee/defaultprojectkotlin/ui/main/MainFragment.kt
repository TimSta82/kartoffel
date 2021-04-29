package de.bornholdtlee.defaultprojectkotlin.ui.main

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import de.bornholdtlee.defaultprojectkotlin.CAMERA_PERMISSION_REQUEST_CODE
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.REQUEST_CAMERA_INTENT
import de.bornholdtlee.defaultprojectkotlin.database.model.Question
import de.bornholdtlee.defaultprojectkotlin.databinding.FragmentMainBinding
import de.bornholdtlee.defaultprojectkotlin.extensions.showSnackBar
import de.bornholdtlee.defaultprojectkotlin.ui.BaseFragment
import de.bornholdtlee.defaultprojectkotlin.utils.CameraUtils
import de.bornholdtlee.defaultprojectkotlin.utils.ImageUtils
import de.bornholdtlee.defaultprojectkotlin.utils.viewBinding

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private companion object {
        const val PHOTO_FILENAME = "exampleFilename"
    }

    private val binding by viewBinding(FragmentMainBinding::bind)
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservers()
        
        setClickListeners()
    }

    private fun setObservers() {
        mainViewModel.counter.observe(viewLifecycleOwner, { binding.welcomeTv.text = it.toString() })
        mainViewModel.downloadError.observe(viewLifecycleOwner, { showSnackBar(it) })
        mainViewModel.downloadSuccess.observe(viewLifecycleOwner, { showSnackBar(R.string.download_success) })
        mainViewModel.questionLiveData.observe(viewLifecycleOwner, { showQuestionResult(it) })
    }

    private fun setClickListeners() {
        binding.counterBtn.setOnClickListener { incrementCounter() }
        binding.loadQuestionsBtn.setOnClickListener { mainViewModel.makeApiCall() }
    }

    private fun showQuestionResult(questionList: List<Question>) {
        binding.questionsIv.text = questionList.toString()
    }

    private fun incrementCounter() {
        mainViewModel.onIncrementCounter()
    }

    private fun requestOpenCameraIntent() {
        if (CameraUtils.checkCameraAvailable(requireActivity())) {
            if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST_CODE)
            } else {
                CameraUtils.takePhoto(this, PHOTO_FILENAME, REQUEST_CAMERA_INTENT)
            }
        } else {
            // Handle no camera available
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                requestOpenCameraIntent()
            } else {
                // Handle error
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CAMERA_INTENT && resultCode == Activity.RESULT_OK) {
            val processedBitmap = ImageUtils.getProcessedBitmap(requireContext(), PHOTO_FILENAME)
            // Do something with the processed bitmap
        }
    }
}
