package es.dgr.data.datasource.gateways

import es.dgr.domain.errors.DomainError
import retrofit2.HttpException
import java.math.BigInteger
import java.security.MessageDigest

private const val CODE_404 = 404
private const val CODE_409 = 409

private const val UNKNOWN = "UNKNOWN"
private const val LIMIT_GREATER = "Limit greater than"
private const val LIMIT_BELOW = "Limit invalid or below"
private const val INVALID_PARAMETER = "Invalid or unrecognized parameter"
private const val EMPTY_PARAMETER = "Empty parameter"
private const val INVALID_ORDERING = "Invalid or unrecognized ordering parameter"
private const val TOO_MANY_VALUES = "Too many values sent"
private const val INVALID_VALUE = "Invalid value passed to filter"

fun Exception.parseErrorFormResponse(): DomainError =
    when (this) {
        is HttpException -> when (this.code()) {
            CODE_404 -> DomainError.ResourceNotFoundError
            CODE_409 -> getConflictError(response()?.errorBody()?.string())
            else -> DomainError.DefaultError(message = this.message ?: UNKNOWN)
        }
        else -> DomainError.DefaultError(message = this.message ?: UNKNOWN)
    }

private fun getConflictError(message: String?): DomainError =
    when {
        message == null -> DomainError.DefaultError(message = UNKNOWN)
        message.contains(LIMIT_GREATER) -> DomainError.LimitGreaterError
        message.contains(LIMIT_BELOW) -> DomainError.LimitBelowError
        message.contains(INVALID_PARAMETER) -> DomainError.InvalidParameterError
        message.contains(EMPTY_PARAMETER) -> DomainError.EmptyParameterError
        message.contains(INVALID_ORDERING) -> DomainError.InvalidOrderingError
        message.contains(TOO_MANY_VALUES) -> DomainError.TooManyValuesError
        message.contains(INVALID_VALUE) -> DomainError.InvalidValueError
        else -> DomainError.DefaultError(message = UNKNOWN)
    }

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}
