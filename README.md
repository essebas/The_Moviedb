# Aplicación Android  - Consumiendo [Themoviedb_API](https://www.themoviedb.org/documentation/api)

***v.0.1-pre-alpha***

Para el siguiente desarrollo se utilizo **arquitectura MVVM** y principios arquitectónicos **orientados a componentes**.


## Tecnologías Utilizadas
- RxJava - RxAndroid (v2.219 - v2.1.1)
- Dagger (v2.26)
- Picasso (v2.71828)
- Lifecycle - View Model y Live Data (v2.0.0)
- Retrofit (v2.8.0)
- OkHttp (v4.4.0)

#### Otras Librerías
- RecyclerView
- CardView
- Material Design


## Recorrido por la Aplicacion

### Splash Screen
Al ejecutar la aplicación se lanza una pantalla de bienvenida que contiene el logotipo de la empresa para la cual se presenta la aplicación.

![enter image description here](https://github.com/essebas/The_Moviedb/blob/master/readme_capturas/SplashScreen.png)

#### Home - Lista de Películas
De entrada se muestra al usuario una lista que contiene las películas mas populares. Estos son datos consumidos de la API por medio de retrofit. Se utiliza la librería de picasso para facilitar la vizualizacion de la imagen de cada item.

![enter image description here](https://github.com/essebas/The_Moviedb/blob/master/readme_capturas/Home.PNG)

#### Home Bottom - Lista de Películas
Todos los resultados extraídos de la API son mostrados en el Recyclerview.


![enter image description here](https://github.com/essebas/The_Moviedb/blob/master/readme_capturas/Home-bottom.PNG)


#### Item - RecyclerView Expand
La información restante que no era mostrada en principo en el item del Recyclerview puede ser consultada realizando un touch en el item que se desee consultar los datos extras. Como no era mucha informacion, se utilizo esta técnica recomendada por la guía de diseño de Material Design.

![enter image description here](https://github.com/essebas/The_Moviedb/blob/master/readme_capturas/Recyclerview_Expand.PNG)

![enter image description here](https://github.com/essebas/The_Moviedb/blob/master/readme_capturas/Recyclerview_Expand2.PNG)


