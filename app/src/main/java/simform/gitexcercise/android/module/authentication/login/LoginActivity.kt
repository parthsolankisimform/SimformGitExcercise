package simform.gitexcercise.android.module.authentication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.os.postDelayed
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityLoginBinding
import simform.gitexcercise.android.module.authentication.forgotPassord.ForgotPasswordActivity
import simform.gitexcercise.android.module.authentication.registration.RegistrationActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureTextFields()
        setupClickListeners()
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
        }
    }

    private fun setupClickListeners() {
        binding.buttonLogin.setOnClickListener {
            doLogin()
        }

        binding.buttonSignup.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        binding.buttonForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    private fun doLogin() {
        binding.apply {
            if (editTextEmail.text.isNullOrBlank()) {
                textInputLayoutEmail.isErrorEnabled = true
                textInputLayoutEmail.error = getString(R.string.text_error_email)
            } else if (editTextPassword.text.isNullOrBlank()) {
                textInputLayoutPassword.isErrorEnabled = true
                textInputLayoutPassword.error = getString(R.string.text_error_password)
            } else {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.msg_login_success),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}