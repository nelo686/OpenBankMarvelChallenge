package es.dgr.obmarvel.ui.common

import android.app.Activity
import android.view.View
import com.google.android.material.snackbar.Snackbar
import es.dgr.domain.errors.DomainError

fun View.showLoading(show: Boolean) {
    this.visibility = if (show) View.VISIBLE else View.GONE
}

fun Activity.showMessage(view: View, style: SnackbarStyle) {
    val snackbar = Snackbar.make(view, style.message, Snackbar.LENGTH_SHORT)
    snackbar.setBackgroundTint(style.getBackgroundColor(context = this))
    snackbar.show()
}

fun DomainError.message(): String =
    when (this) {
        is DomainError.DefaultError -> message
        is DomainError.LimitGreaterError -> "LimitGreaterError"
        is DomainError.LimitBelowError -> "LimitBelowError"
        is DomainError.InvalidParameterError -> "InvalidParameterError"
        is DomainError.EmptyParameterError -> "EmptyParameterError"
        is DomainError.InvalidOrderingError -> "InvalidOrderingError"
        is DomainError.TooManyValuesError -> "TooManyValuesError"
        is DomainError.InvalidValueError -> "InvalidValueError"
        is DomainError.ResourceNotFoundError -> "ResourceNotFoundError"
    }
