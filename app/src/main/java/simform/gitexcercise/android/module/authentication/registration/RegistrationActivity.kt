package simform.gitexcercise.android.module.authentication.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityRegistrationBinding
import simform.gitexcercise.android.module.profile.ProfileActivity
import simform.gitexcercise.android.utils.Declarations
import simform.gitexcercise.android.utils.PreferenceHelper
import simform.gitexcercise.android.utils.PreferenceHelper.emailAddress
import simform.gitexcercise.android.utils.PreferenceHelper.name
import simform.gitexcercise.android.utils.PreferenceHelper.username

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureTextFields()
        binding.buttonRegister.setOnClickListener {
            doRegister()
        }
    }

    private fun configureTextFields() {
        binding.apply {
            editTextEmail.addTextChangedListener {
                textInputLayoutEmail.isErrorEnabled = true
                textInputLayoutEmail.error = null
            }

            editTextPassword.addTextChangedListener {
                textInputLayoutPassword.isErrorEnabled = true
                textInputLayoutPassword.error = null
            }

            editTextUsername.addTextChangedListener {
                textInputLayoutUsername.isErrorEnabled = true
                textInputLayoutUsername.error = null
            }

            editTextName.addTextChangedListener {
                textInputLayoutName.isErrorEnabled = true
                textInputLayoutName.error = null
            }
        }
    }

    private fun doRegister() {
        binding.apply {
            if (editTextName.text.isNullOrBlank()) {
                textInputLayoutName.isErrorEnabled = true
                textInputLayoutName.error = getString(R.string.text_error_email)
            } else if (editTextUsername.text.isNullOrBlank()) {
                textInputLayoutUsername.isErrorEnabled = true
                textInputLayoutUsername.error = getString(R.string.text_error_username)
            } else if (editTextEmail.text.isNullOrBlank()) {
                textInputLayoutEmail.isErrorEnabled = true
                textInputLayoutEmail.error = getString(R.string.text_error_email)
            } else if (editTextPassword.text.isNullOrBlank()) {
                textInputLayoutPassword.isErrorEnabled = true
                textInputLayoutPassword.error = getString(R.string.text_error_password)
            } else {
                val sharedPrefs =
                    PreferenceHelper.customPreference(
                        applicationContext,
                        Declarations.sharedPreferences
                    )
                binding.apply {
                    sharedPrefs.name = editTextName.text.toString()
                    sharedPrefs.username = editTextUsername.text.toString()
                    sharedPrefs.emailAddress = editTextEmail.text.toString()
                }
                startActivity(
                    Intent(
                        this@RegistrationActivity, ProfileActivity::class.java
                    )
                )
            }
        }

    }
}