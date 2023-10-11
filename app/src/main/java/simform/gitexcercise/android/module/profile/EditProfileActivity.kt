package simform.gitexcercise.android.module.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import simform.gitexcercise.android.databinding.ActivityEditProfileBinding
import simform.gitexcercise.android.utils.Declarations
import simform.gitexcercise.android.utils.PreferenceHelper
import simform.gitexcercise.android.utils.PreferenceHelper.emailAddress
import simform.gitexcercise.android.utils.PreferenceHelper.name
import simform.gitexcercise.android.utils.PreferenceHelper.username

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        doRetrieveData()
        binding.buttonSave.setOnClickListener {
            setData()
            startActivity(Intent(this@EditProfileActivity, ProfileActivity::class.java))
        }
    }

    private fun doRetrieveData() {
        val sharedPrefs =
            PreferenceHelper.customPreference(applicationContext, Declarations.sharedPreferences)
        binding.apply {
            editTextName.setText(sharedPrefs.name)
            editTextEmail.setText(sharedPrefs.emailAddress)
            editTextUsername.setText(sharedPrefs.username)
        }
    }

    private fun setData() {
        val sharedPrefs =
            PreferenceHelper.customPreference(applicationContext, Declarations.sharedPreferences)
        binding.apply {
            sharedPrefs.name = editTextName.text.toString()
            sharedPrefs.username = editTextUsername.text.toString()
            sharedPrefs.emailAddress = editTextEmail.text.toString()
        }
    }
}