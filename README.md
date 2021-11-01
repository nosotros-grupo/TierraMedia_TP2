# TierraMedia Entrega2

![](https://wallpaperaccess.com/full/838293.jpg "Rivendell")

### Integrantes del Grupo
- Miguel Colombos
- Pablo Estevez
- Belen Rodriguez
- Diego Crisaldo
- Ezequiel David


## Funcionalidades presentes en el programa

Hasta ahora hemos conseguido que el programa lea una base de datos con **usuarios**, **atracciones** y **promociones**. 
El programa lee a los **usuarios**, guarda sus *preferencias*, su *tiempoDisponible*, su *presupuesto* y lo tiene en cuenta para la recomendación
de **promociones** y **atracciones**, siendo priorizadas las de mayor valor y duración. 

Una vez ofertadas todas las **promociones** y **atracciones** posibles a los **usuarios**, se guardan los itinerarios de cada usuario en la base de datos para su futuro acceso
al mismo tiempo que también se actualiza el *tiemposDisponible*, el *presupuesto* de los **usuarios**, así como el cupo de las **atracciones**.
Si un **usuario** volviese a entrar al programa, se recupera su itinerario si lo tuviese y se continua con la oferta teniéndolo en cuenta.


## Mejoras a implementar

Revisar los tipos y estructuras de datos de las listas, tal vez hay casos donde conviene un **Queue** por sus operaciones O(1), revisar si conviene **ArrayList** por su búsqueda de indices que es una operacion O(1).
