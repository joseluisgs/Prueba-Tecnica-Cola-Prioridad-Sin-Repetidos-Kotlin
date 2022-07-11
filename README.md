# Prueba Técnica Cola Prioridad Sin Repetidos

Ejemplo de una prueba técnica Junior aplicable a cualquier lenguaje.

[![Kotlin](https://img.shields.io/badge/Code-Kotlin-blueviolet)](https://kotlinlang.org/)
[![Java](https://img.shields.io/badge/Code-Java-red)](https://java.org/)
[![TypeScript](https://img.shields.io/badge/Code-TypeScript-blue)](https://www.typescriptlang.org/)
[![LISENCE](https://img.shields.io/badge/Lisence-MIT-%23e64545)](https://joseluisgs.github.io/docs/license/)
![GitHub](https://img.shields.io/github/last-commit/joseluisgs/Prueba-Tecnica-Cola-Prioridad-Sin-Repetidos-Kotlin)

<p align="center">
  <a href="https://joseluisgs.github.io/" target="_blank"><img src="https://joseluisgs.github.io/img/web01.svg" 
  width='600px' borderRadius='1rem' boxShadow = '0 5px 18px rgba(0,0,0,0.3)'></a>
</p>

- [Prueba Técnica Cola Prioridad Sin Repetidos](#prueba-técnica-cola-prioridad-sin-repetidos)
  - [El problema](#el-problema)
    - [Una variación del problema](#una-variación-del-problema)
  - [Hazlo en otros lenguajes](#hazlo-en-otros-lenguajes)
    - [Lenguajes disponibles](#lenguajes-disponibles)
  - [Acerca de](#acerca-de)
  - [Antes de programar](#antes-de-programar)
  - [Haz un repositorio](#haz-un-repositorio)
  - [Piensa primero en los test](#piensa-primero-en-los-test)
  - [Ahora implementa la solución](#ahora-implementa-la-solución)
  - [Documenta tu solución](#documenta-tu-solución)
  - [Tiempo](#tiempo)
  - [Autor](#autor)
    - [Contacto](#contacto)
  - [Licencia](#licencia)

## El problema
Tenemos un **proceso**, que tiene un identificador, un nombre y una prioridad (1-9). 
Queremos manejar una **cola de prioridad, sin repetidos**. Sabremos que un elemento es repetido si tiene el mismo id. **La prioridad es de 1 a 9 siendo 9 la más alta**.
Debemos tener en cuenta que **si un proceso ya existe no se puede insertar**.
Por otro lado queremos un **controlador que nos centralice el proceso de manejar la cola**.
Al **sacar el primer proceso de la cola (se obtiene y se elimina, porque es una cola) o mostrarlos ordenados, siempre es por prioridad descendente**, de más a menos.
Se pide resolver el problema, justificando tu solución (diseño, patrones, técnicas de programación usadas) y testear las operaciones críticas a nivel de la cola y controlador.

### Una variación del problema
Puedes hacer una variación, es que si el proceso existe se deben actualizar sus datos. (Esto te lo dejo a ti 💪)

## Hazlo en otros lenguajes
Si quieres hacerlo en otros lenguajes, crea un directorio con el nombre del lenguaje y mete el proyecto de tu solución. Es importante que muestres que todo se testea a nivel unitario y usando algún mock. Una vez hecho hazme un pull-request y pásame el color del logo del lenguaje que quieres que salga en la cabecera ¿Te atreves? 😉

### Lenguajes disponibles
- [Kotlin](./kotlin/)
- [Java](./java/)
- [TypeScript](./typescript/)
## Acerca de

Este ejercicio de clase, tiene como objetivo mostrar aspectos de programación para la realización de una prueba técnica.

La idea principal es que puedas resolverlo con cualquier lenguaje de programación. Pero son los sutiles detalles lo que
marcan la diferencia.
Hay infinitas soluciones. Aunque está centrada en Kotlin, parcialmente tienes un directorio con la solución parcialmente
en Java vista en clase al igual que otros lenguajes.
Aunque lo importante es que puedas resolverlo con cualquier lenguaje de programación y sigas los pasos indicados siempre
que puedas.
No es tanto el qué resuelvas si no el cómo lo resuelvas y lo que expliques, comentarios o técnicas que utilices.

Te dejo algunos consejos.

## Antes de programar

Hazte un esquema de cómo vas a sacar la solución. Abrir el IDE y picar sin ton ni son aunque lo tengas claro no ayuda.
Empezar a escribir, borrar, corregir, borrar, cambiar, noe stá muy bien visto.

5 minutos de diseño, ayudan a más de una hora de programación: patrones, diseño, SOLID, prueba a realizar.

## Haz un repositorio

Al crear el proyecto, crea el repositorio GIT. No se trata de dar con la solución, si no de mostrar todas las
habilidades técnicas para el desarrollo de software.
Haz commit en cada punto importante. Si te equivocas puedes volver atrás.

## Piensa primero en los test

¿Te he dicho que es una prueba técnica? De que me sirve una solución, si no sabemos si funciona bien.
Antes de programar piensa y escribe los test, aplica algo de tDD, demostrarás que conoces su filosofía. El ejemplo es
suficientemente sencillo para no complicarte la vida.
A partir de aquí, crea el código que necesites pasando el test.

Recuerda: Un test también es programar. No se hacen solos ;)

## Ahora implementa la solución

Mira lo que has avanzado antes de programar:

- Has hecho un diseño, tienes las ideas de qué tienes que hacer.
- Has hecho el repositorio.
- Tienes unos test que te aseguran tu solución.

¿No está mal?

Ahora toca programar. Intenta aplicar todo que conozcas pero de una manera elegante. No meter por meter. Aplica
programación funcional y cuestiones de inmutabilidad. Elige y justifica los TDAs que vas a usar. Hay varias formas y
todo depende de lo que justifies o expliques. Aplica algunas interfaces, inyección de dependencias de forma manual,
algún patrón, y conocimientos de Programación Orientada a Objetos etc.

Como te he dicho, el ejemplo es lo suficientemente sencillo para que lo resuelvas siguiendo tu propio camino. El mérito
está en haber realizado los puntos anteriores, no tanto en este.

## Documenta tu solución

Es importante que algunos aspectos del código estén documentados, ya sea usando comentarios, documentación de clases,
documentación de interfaces, etc.
Pero lo más relevante es que su tu código es "limpio" muchas de las cosas estarán autodocumentadas.

Finalmente, haz un README.md con todo lo que has hecho y justificando tus elecciones y soluciones.

## Tiempo

Piensa que el tiempo no es infinito, esto no te debería llevar más de 60 minutos. Intenta no pasar más de 60 minutos. Si no lo consigues, no te preocupes, puedes volver a empezar y seguir practicando.


## Autor

Codificado con :sparkling_heart: por [José Luis González Sánchez](https://twitter.com/joseluisgonsan)

[![Twitter](https://img.shields.io/twitter/follow/joseluisgonsan?style=social)](https://twitter.com/joseluisgonsan)
[![GitHub](https://img.shields.io/github/followers/joseluisgs?style=social)](https://github.com/joseluisgs)

### Contacto
<p>
  Cualquier cosa que necesites házmelo saber por si puedo ayudarte 💬.
</p>
<p>
 <a href="https://joseluisgs.github.io/" target="_blank">
        <img src="https://joseluisgs.github.io/img/favicon.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://github.com/joseluisgs" target="_blank">
        <img src="https://distreau.com/github.svg" 
    height="30">
    </a> &nbsp;&nbsp;
        <a href="https://twitter.com/joseluisgonsan" target="_blank">
        <img src="https://i.imgur.com/U4Uiaef.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://www.linkedin.com/in/joseluisgonsan" target="_blank">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/LinkedIn_logo_initials.png/768px-LinkedIn_logo_initials.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://discordapp.com/users/joseluisgs#3560" target="_blank">
        <img src="https://logodownload.org/wp-content/uploads/2017/11/discord-logo-4-1.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://g.dev/joseluisgs" target="_blank">
        <img loading="lazy" src="https://googlediscovery.com/wp-content/uploads/google-developers.png" 
    height="30">
    </a>    
</p>

## Licencia

Este proyecto esta licenciado bajo licencia **MIT**, si desea saber más, visite el fichero
[LICENSE](https://joseluisgs.github.io/docs/license/) para su uso docente y educativo.