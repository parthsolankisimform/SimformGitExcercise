package simform.gitexcercise.android.module.authentication.forgotPassord

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.os.postDelayed
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureTextFields()
        binding.buttonForgotPassword.setOnClickListener {
            doValidateEmail()
        }
    }

    private fun configureTextFields() {
        binding.apply {
            editTextEmail.addTextChangedListener {
                textInputLayoutEmail.isErrorEnabled = true
                textInputLayoutEmail.error = null
            }
        }
    }

    private fun doValidateEmail() {
        binding.apply {
            if (editTextEmail.text.isNullOrEmpty()) {
                textInputLayoutEmail.isErrorEnabled = true
                textInputLayoutEmail.error = getString(R.string.text_error_email)
            } else {
                Snackbar.make(
                    binding.root, getString(R.string.msg_email_send),
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}