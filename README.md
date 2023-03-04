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
   * **peliculasdataset-copia.csv**: el dataset contiene un total de 10 columnas. 

    
## Estructura del *dataset*

Se puede obtener de la URL http://kaggle.com/aungpyaeap/movie-streaming-datasets-iflix . Originalmente tenia 7 columnas sobre series y peliculas de Netflix. El dataset utilizado en el proyecto tiene 10 columnas de las cuales 5 se han tomado del dataset original y 5 (fecha, hora, ranking, el booleano y efectos especiales) se han generado de forma aleatoria. A continuacion se describen las 10 columna:

El dataset está compuesto por 10 columnas, con la siguiente descripción:

* **show_type**: de tipo Formato, representa si se trata de peliculas o de series de televisión.
* **genre**: de tipo String, representa el género cinematografico 
* **running_minutes**: de tipo Integer, representa los minutos que dura dicha pelicula/serie.
* **source_language**: de tipo String, representa el idioma original en la que esta la pelicula/serie.
* **season_id**: de tipo Integer, representa el número de temporada que tienen las series, en el caso de las peliculas esa columna se encuentra sin valor.
* **sereis_id**: de tipo Integer, repressenta el id de las series, en el caso de las peliculas esa columna se encuentra sin valor.
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
- seasonId, de tipo Integer, consultable y modificable. 
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

**Criterio de igualdad**: Las peliculas se consideran iguales si los atributos estrenoHora, genre, ranking y sourceLanguage son iguales.

**Criterio de ordenación**: Las series se ordenan a partir del ranking y del numero de temporadas.

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...

#### Tipos auxiliares
- Formato de tipo Enumerate, puede tomar los valores TV y MOVIE.
- Siglo de tipo Enumerate, puede tomar los valores XX y XXI.

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
