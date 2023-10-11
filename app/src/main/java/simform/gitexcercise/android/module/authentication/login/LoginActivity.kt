package simform.gitexcercise.android.module.authentication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityLoginBinding
import simform.gitexcercise.android.module.authentication.forgotPassword.ForgotPasswordActivity
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
            } else if (!isValidEmailFormat(editTextEmail.text.toString())) {
                textInputLayoutEmail.isErrorEnabled = true
                textInputLayoutEmail.error = getString(R.string.msg_email_not_matching_pattern)
            } else if (editTextPassword.text.isNullOrBlank()) {
                textInputLayoutPassword.isErrorEnabled = true
                textInputLayoutPassword.error = getString(R.string.text_error_password)
            } else {
                Snackbar.make(root, getString(R.string.msg_login_success), Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidEmailFormat(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}