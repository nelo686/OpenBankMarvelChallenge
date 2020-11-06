package es.dgr.domain.errors

sealed class DomainError {
    data class DefaultError(val message: String) : DomainError()
    object LimitGreaterError : DomainError()
    object LimitBelowError : DomainError()
    object InvalidParameterError : DomainError()
    object EmptyParameterError : DomainError()
    object InvalidOrderingError : DomainError()
    object TooManyValuesError : DomainError()
    object InvalidValueError : DomainError()
    object ResourceNotFoundError : DomainError()
}
