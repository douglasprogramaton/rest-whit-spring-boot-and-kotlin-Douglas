package com.kotlinstping.advanced.converters

object NumberConverter {
    fun convertToDouble(strNumber: String?): Double {
    if (strNumber.isNullOrBlank())
        return 0.0
    val number= strNumber.replace(",".toRegex(),".")//conversion to american standard.
    return if (isNumeric(number))number.toDouble() else 0.0// checks if the number matches the regex.
}

    fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false
        val number= strNumber.replace(",".toRegex(),".")
        return number.matches("""[-+]?[0,9]*\.?[0-9]+""".toRegex())

    }
}
