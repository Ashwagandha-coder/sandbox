package com.github.sandbox


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


