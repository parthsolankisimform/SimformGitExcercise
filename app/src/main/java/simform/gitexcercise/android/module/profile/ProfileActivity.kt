package simform.gitexcercise.android.module.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import simform.gitexcercise.android.databinding.ActivityProfileBinding
import simform.gitexcercise.android.utils.Declarations
import simform.gitexcercise.android.utils.PreferenceHelper
import simform.gitexcercise.android.utils.PreferenceHelper.emailAddress
import simform.gitexcercise.android.utils.PreferenceHelper.name
import simform.gitexcercise.android.utils.PreferenceHelper.username

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        doRetrieveData()
        binding.buttonEditProfile.setOnClickListener {
            startActivity(Intent(this@ProfileActivity, EditProfileActivity::class.java))
        }
    }

    private fun doRetrieveData() {
        val sharedPrefs =
            PreferenceHelper.customPreference(applicationContext, Declarations.sharedPreferences)
        binding.apply {
            textNameRetrieved.text = sharedPrefs.name
            textEmailAddressRetrieved.text = sharedPrefs.emailAddress
            textUserNameRetrieved.text = sharedPrefs.username
        }
    }
}