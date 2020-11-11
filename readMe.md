# openbankMarvelChallenge

Prueba técnica para el proceso de selección en Openbank.

###Detalles

* Se separa el desarrollo por módulos (capas) siendo estos: *data*, *domain*, *usecases* y *app*. 

	Aunque el módulo *usecases* hace las veces de punto de desacoplo, se podría prescindir de dicho módulo ya que en realidad no hace más que pasar los datos provenientes de *data*.

* Se hace uso del patrón de presentación MVVM.

* Se hace uso de librerías como Hilt, Retrofit, Okhttp, corrutinas, Arrow, Gson y Coil. Para el testeo de la app se usan espresso, junit, kakao, kluent y mockito.

* He incluido tests unitarios en *data* y de instrumentación en *app*, no tenía sentido testar *usecases* ya que no tiene lógica.