# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Lucia Torres   uvus: DKT328

El dataset trata sobre las peliculas y series estrenadas en la plataforma de streaminig Netflix. 


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.series**: Paquete que contiene los tipos del proyecto.
  * **fp.series.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
   * **peliculasdataset.csv**: el dataset contiene un total de 10 columnas. 

    
## Estructura del *dataset*

Se puede obtener de la URL http://kaggle.com/aungpyaeap/movie-streaming-datasets-iflix . Originalmente tenia 7 columnas sobre series y peliculas de Netflix. El dataset utilizado en el proyecto tiene 10 columnas de las cuales 5 se han tomado del dataset original y 5 (fecha, hora, ranking, el booleano y efectos especiales) se han generado de forma aleatoria. A continuacion se describen las 10 columna:

El dataset está compuesto por 10 columnas, con la siguiente descripción:

* **show_type**: de tipo Formato, representa si se trata de peliculas o de series de televisión.
* **genre**: de tipo String, representa el género cinematografico 
* **running_minutes**: de tipo Integer, representa los minutos que dura dicha pelicula/serie.
* **source_language**: de tipo String, representa el idioma original en la que esta la pelicula/serie.
* **sereis_id**: de tipo Integer, representa el id de las series, en el caso de las peliculas esa columna se encuentra sin valor.
* **finished**: de tipo booleano, representa si la serie ha terminado.
* **ranking**: de tipo Double, representa la puntuacion qeu le han dado a la serie/pelicula.
* **estreno_fecha**: de tipo LocalDate, rerepresenta la fecha (formato dd/mm/aaaa) de estreno de la pelicula/serie.
* **estreno_hora**: de tipo LocalTime, rerepresenta la hora (formato hh/MM/ss) de estreno de la pelicula/serie.
* **efectos especales**: de tipo lista, representa los distintos efectos especiales utilizados en las series/peliculas. Varia entre efectos de Sonido, efectos de Maquillaje y efectos Ópticos.


## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base

**Propiedades**:

- showType, de tipo Formato , consultable. 
- genre, de tipo String, consultable y modificable. 
- sourceLanguage, de tipo String, consultable.
- seriesId,de tipo Integer, consultable. 
- finished, de tipo Boolean, consultable y modificable
- estrenoHora, de tipo LocalTime, consultable
- ranking, de tipo Double, consultable y modificable.
- estrenoFecha, de tipo LocalDate, consultable
- efectosEspeciales, de tipo String, consultable y modificable

**Constructores**: 

- C1: Tiene un parametro por cada propiedad basica.
- C2: Crea un objeto Peliculas en donde tiene como parametro el genero, el ranking, las temporadas y los efectos especiales.

**Restricciones**:
 
- R1: El ranking no puede ser negativo.
- R2: Se debe indicar el genero de la pelicula/serie.
- R3: La fecha de estreno no puede ser en el futuro.
**Criterio de igualdad**: Las peliculas se consideran iguales si los atributos genre y ranking y son iguales.

**Criterio de ordenación**: Las series se ordenan a partir del ranking y del genero.


#### Tipos auxiliares
- Formato de tipo Enumerate, puede tomar los valores TV y MOVIE.
- Siglo de tipo Enumerate, puede tomar los valores XX y XXI.
- horario de tipo Horario, que es un record que junta la fecha y la hora

### Factoría
Descripción breve de la factoría.

- List<String>parsearEfectos(String lista): parseo de la lista del csv.
- PeliculasssContenedor leerPeliculasStream(String ruta):lee el fichero del CSV de los objetos del tipo Peliculas registrados por stream
- List<Pelicula> leerPelicula(String path): lee el fichero CSV de los objetos del tipo Peliculas registrado por lista.
- Pelicula parsearPelicula(String linea): crea un objeto de tipo Pelicula a partir de una cadena de caracteres. La cadena de caracteres debe tener el mismo formato que las lineas del CSV.

### Tipo Contenedor

El contenedor se llama PeliculasssContenedor y esta formado por una Lista 

**Propiedades**:

- Propiedad 1: List<Pelicula> Peliculass (consultable)
**Constructores**: 

- C1: crea una lista vacia de tipo PeliculasssContenedor
- C2: constructor con un parametro de tipo stream<Pelicula> Crea un objeto de tipo Pelicula con las partidas incluidas en el Stream dado
- C3: constructor con un parametro de tipo Collection<Pelicula>. crea un objeto de tipo PeliculasssContenedor con las peliculas incluidas en la coleccion.

- 
**Criterio de igualdad**: Dos peliculas son iguales si lo son sus propiedades Peliculas.


**Otras operaciones**:
 
 ---------ENTREGA 2----------
 
-añadir peliculas al constructor

-eliminar peliculas al constructor

-conseguir el tamaño de la lista del csv

-Boolean existePeliculaGeneroIdioma(String g, String i): devuelve verdadero o falso si exite cierta pelicula/serie que tenga el genero y el idioma especificado.

-Integer getNumeroPeliculaIdiomaDeUnAño(String i, Integer a): devuelve 
el numero total de peliculas y series de un idioma y año especificado.

-List<Pelicula> filtradoSoloPeliculaId(Integer a, Formato p): devuelve una lista de tipo Pelicula que existan en el año y el formato especificado.

-Map<String, Set<Integer>> getListaIdPorGenero():  devuelve un mapa en donde las claves son los distintos generos y los valores son un conjunto de los id de las dsitintas series y peliculas.

-Map<String, Long> getTotalDuracionPorGenero(): devuelve un mapa que sus claves seam el genero y los valores la suma total de las duraciones.

 ---------ENTREGA 3----------

-Boolean existePeliculaGeneroIdidomaStream(String g, String i): devuelve verdadero o falso si exite cierta pelicula/serie que tenga el genero y el idioma especificado.

-Integer calcularMinutosTotalesPorIdioma(String g): devuelve el total de los minutos que duran las series/peliculas de un genero especificado.

-Set<Pelicula> peliculasEntreDosDuracionesDadas(Integer max, Integer min): un filtrado que devuelve un set de peliculas que sus duraciones estan entre dos Integer especificados.

-Map<List<String>, Set<Integer>> getSeriesListaEfectosConjuntoAños(): filtra solo a las series y haga un mapa con las listas de los efectos especiales como clave y los distintos años como valores.

-Pelicula mejorRankingAcabadaIidoma(String idioma): filtra la pelicula con peor ranking de un idioma especificado o si no devuelve nulo.
 
-List<Pelicula> obtenerNSeriesGeneroOrdenadosPorElRanking(String g, Integer n):devuelve una lista que filtra por genero y que solo sean series y ordenas las n mejores por el ranking 

-Map<Integer, Set<Integer>> agruparIdPorMes(): filtra las series y devuelve un mapa que tenga los valores de los meses (integer) y un conjunto de los id de las series.

-Map<String, Pelicula> fechasConPeliculasConPeoresRankings(Integer año): construye un mapa que filtre por el año especificado y que tengaa los idiomas como claves y los datos de las peliculas con los  peores ranking.

-SortedMap<String, Integer> getSeriesTerminadasAcumuladasPorGenero(): filtra solo las series que hayan terminado y crea un SortedMap con los generos como claves y el numero total de series como los valores.

-Entry<Integer, Long> getMayorPeliculasPorAñoTerminadas(): crea un mapa que filtre solo las peliculas ya terminadas y que tenga el año como clave y el valor como el numero total de peliculas. Quedese con el año y el numero mayor. 

