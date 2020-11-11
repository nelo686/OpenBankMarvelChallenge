package es.dgr.obmarvel.ui.web

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WebViewModel @ViewModelInject constructor() : ViewModel() {

    private val _model = MutableLiveData<WebUiModel>()
    val model: LiveData<WebUiModel>
        get() = _model

    fun onViewCreated(url: String) {
        _model.value = WebUiModel.Loading
        _model.value = WebUiModel.Load(url = url)
    }
}