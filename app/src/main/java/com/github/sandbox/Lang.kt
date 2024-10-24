package com.github.sandbox

import android.content.SharedPreferences
import android.system.Os.close
import android.util.Log
import android.view.View
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import java.io.Closeable
import java.net.URL


/**
 * Example of use value class
 */


@JvmInline
value class Email(val value: String) {
    init {
        require(value.contains("@")) { "Invalid email format" }
    }
}

data class Dimensions(val width: Int, val height: Int)

@JvmInline
value class ScreenDimensions(val dimen: Dimensions)

@JvmInline
value class Percentage(val value: Int) {
    init {
        require(value in 0..100) {
            "Percentage value must be between 0 and 100"
        }
    }

}

@JvmInline
value class PhoneNumber(val number: String) {
    init {
        require(isValidPhoneNumber(number)) { "Invalid phone number format" }
    }

    private fun isValidPhoneNumber(number: String): Boolean {
        return number.matches(Regex("^\\+?[0-9]{10,15}$"))
    }


    fun countryCode(): String? = number.substringBefore(" ").takeIf { it.isNotEmpty() }

    fun nationalNumber(): String =
        number.substringAfter(" ").takeIf { it.isNotEmpty() } ?: number

    fun isInternational(): Boolean = number.startsWith("+")

    fun formatInternational(): String {
        if (isInternational()) return number
        return "+${countryCode()} ${nationalNumber()}"
    }

    fun formatNational(): String {
        if (!isInternational()) return number
        return nationalNumber()
    }


    fun isMobile(): Boolean = TODO("Implement mobile number detection logic")

    fun isLandline(): Boolean = TODO("Implement landline number detection logic")

    fun isValidForRegion(regionCode: String): Boolean =
        TODO("Implement region-specific validation logic")
}


@JvmInline
value class Url(val url: String) {
    init {
        require(isValidUrl(url)) { "Invalid URL format" }
    }

    fun isValidUrl(url: String): Boolean {
        return try {
            URL(url).toURI()
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getDomain(): String? {
        return try {
            URL(url).host
        } catch (e: Exception) {
            null
        }
    }

    fun getPath(): String? {
        return try {
            URL(url).path
        } catch (e: Exception) {
            null
        }
    }
}

/**
 * Example of use Object
 */


object Analytics {

    private val analytic = listOf(1, 2, 3, 4, 5) // FireBase

    fun initialize() {
        analytic
    }

    fun trackEvent(event: String) {
        println("$event")
    }

}


/**
 * Example Exception
 */


class AuthenticationException(val errorCode: Int, message: String? = null) : Exception(message) {
    companion object {
        const val INVALID_CREDENTIALS = 1001
        const val USER_NOT_FOUND = 1002
    }
}

fun login(username: String, password: String) {
    if (username.isEmpty() || password.isEmpty()) {
        throw AuthenticationException(1001, "Invalid username or password")
    }
    // logic.....
}

/**
 * Example of use inline
 */

/**
 * OnClick in View
 */

inline fun View.onClick(crossinline listener: (View) -> Unit) {
    setOnClickListener { listener(it) }
}

/**
 * Measure Time
 */

inline fun measureTimeMillis(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    println("Start Time - $start")
    block()
    val end = System.currentTimeMillis() - start
    println("End Time - $end")
    return end
}

/**
 * Shared Pref
 */


inline fun SharedPreferences.edit(crossinline action: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    action(editor)
    editor.apply()
}

/**
 * Logger
 */

inline fun log(message: () -> String) {
    Log.d("MY TAG", message())
}

/**
 * Use in Clonable
 */


inline fun <T : Closeable?, R> T.use(block: (T) -> R): R {
    var exception: Throwable? = null
    try {
        return block(this)
    } catch (e: Throwable) {
        exception = e
        throw e
    } finally {
        when {
            this == null -> {}
            exception == null -> close()
            else -> try {
                close()
            } catch (closeException: Throwable) {
                exception.addSuppressed(closeException)
            }
        }
    }
}

/**
 * OnEachIndexed in Flow
 */

inline fun <T> Flow<T>.onEachIndexed(crossinline action: suspend (index: Int, value: T) -> Unit): Flow<T> {
    var index = 0
    return onEach {
        action(index++, it)
    }
}

/**
 * Example of use Sealed Class
 */


sealed class UiState {
    data object Loading : UiState()
    data class Success(val data: List<Any>) : UiState()
    data class Error(val message: String) : UiState()
}

sealed interface OperationResult<T> {
    data class Success<out T>(val data: String) : OperationResult<T>
    data class Error(val error: String) : OperationResult<Nothing>
}

internal data object Configuration {

}


