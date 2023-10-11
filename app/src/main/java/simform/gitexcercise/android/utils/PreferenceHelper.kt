package simform.gitexcercise.android.utils

import android.content.Context
import android.content.SharedPreferences

/** Helper Class for SharedPreference **/
object PreferenceHelper {
    private const val USERNAME = "USERNAME"
    private const val EMAIL_ADDRESS = "EMAIL_ADDRESS"
    private const val NAME = "NAME"

    fun customPreference(context: Context, name: String): SharedPreferences =
        context.getSharedPreferences(name, Context.MODE_PRIVATE)

    private inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.username
        get() = getString(USERNAME, "")
        set(value) {
            editMe {
                it.putString(USERNAME, value)
            }
        }

    var SharedPreferences.emailAddress
        get() = getString(EMAIL_ADDRESS, "")
        set(value) {
            editMe {
                it.putString(EMAIL_ADDRESS, value)
            }
        }

    var SharedPreferences.name
        get() = getString(NAME, "")
        set(value) {
            editMe {
                it.putString(NAME, value)
            }
        }
}
