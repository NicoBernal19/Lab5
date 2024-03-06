# LABORATORIO 5 - SPRING MVC INTRODUCTION

#### INTRODUCCIÓN A PROYECTOS WEB

### PARTE I. - JUGANDO A SER UN CLIENTE HTTP
Usaremos las siguientes aplicaciones como cliente HTTP
- Postman
- Telnet

Abre la aplicación Postman, lo usaremos para hacer una solicitud a un servidor HTTP, al abrirlo indentifica qué controles de Postman corresponde a los elementos de entrada y salida de un servicio HTTP:

<img width="803" alt="image" src="https://github.com/PDSW-ECI/labs/assets/4140058/49acba5d-2f26-4515-96e9-af7aa50f89d4">

Has un request GET a la URL https://www.escuelaing.edu.co/es/ y verifica el body de respuesta en las opciones Pretty, Raw, Preview.

Ahora has otro request GET al recurso https://dummyjson.com/todos, nuevamente verifica el body en varias opciones.

Responde las siguientes preguntas:
- ¿Qué pasa si no envío el método correcto?
    - RESPUESTA: Si no envías el método correcto en tu solicitud HTTP, el servidor responderá con un código de estado HTTP 405 (Método no permitido). Esto indica que el método utilizado en la solicitud no está permitido para la URL solicitada.
- ¿Qué pasa si al body response HTML lo fuerzo a leerse como JSON?
    - RESPUESTA: Si intentas leer el cuerpo de la respuesta HTML como JSON, es probable que encuentres errores de análisis debido a que el contenido no sigue el formato JSON. Esto puede generar una excepción en tu aplicación o código que intenta procesar el JSON, ya        que el HTML no está estructurado de la misma manera que el JSON.
- ¿Por qué el preview de HTML no se ve igual a cuando accedo a la URL en un navegador web?
    - RESPUESTA: El preview de HTML puede no verse igual que en un navegador web por varias razones:
        - La herramienta de preview puede no interpretar correctamente el HTML, CSS y JavaScript de la misma manera que lo hace un navegador web.
        - Algunas partes del HTML pueden depender de recursos externos (archivos CSS, imágenes, JavaScript, etc.) que no se cargan o procesan correctamente en el preview.
        - La herramienta de preview puede no soportar ciertas características del HTML, como elementos HTML5 o CSS3, lo que puede afectar la apariencia y funcionalidad del contenido.
- ¿Qué pasa si le envías un body a una solicitud GET?
    - RESPUESTA: Según las especificaciones de HTTP, no se debe enviar un cuerpo en una solicitud GET. Sin embargo, algunos servidores pueden aceptar un cuerpo en una solicitud GET, pero en la práctica, muchos servidores lo ignorarán o responderán con un error (como un     HTTP 400 Bad Request). En general, es una mala práctica enviar un cuerpo en una solicitud GET, ya que este método está diseñado para recuperar recursos, no para enviar datos al servidor.

Como parte del laboratorio en casa has los dos request anteriores pero ahora usando la herramienta Telnet, ya que esta no funciona adecuadamente en los equipos del laboratorio.

### PARTE II. - CLIENT SIDE RENDERING CON REACT
Para iniciar verifica que tengas alguna de estas herramientas:
- NPM o YARN

Verificando en terminal sería `$ npm init`

La siguiente misión es ejecutar una aplicación react localmente:
- Abre la aplicación https://codesandbox.io/s/react-js-simple-calculator-pefmr, loguéate con GitHub y juega cambiando los parámetros como colores y duplicando las líneas del archivo App.js con tags como `<ResultComponent ...>` en la función render.

- ¿Qué hace cada uno de los archivos en la aplicación?
.
├── package.json
├── public
│   └── index.html
└── src
    ├── App.js
    ├── components
    │   ├── KeyPadComponent.js
    │   └── ResultComponent.js
    ├── index.js
    └── styles.css

- Después de haber visto los cambios, vuelve a abrir la URL original https://codesandbox.io/s/react-js-simple-calculator-pefmr y sigue los siguientes pasos:
1) Descargar código en un Zip
2) Descomprimir el Zip en la carpeta de proyectos de software, (en ciertos PC solo funciona 7-Zip)
3) Abrir una terminal de Git Bash en la carpeta descomprimida
4) Instalar las dependencias con `npm install`
5) Iniciar la aplicación con `npm star`, en algunos computadores con versiones antiguas de nodejs hay que agregar `NODE_OPTIONS=--openssl-legacy-provider npm run start`
6) Si te sale el Firewall dale click en cancelar
7) Abrir la ruta http://localhost:3000/ en un navegador web como Firefox o Google Chrome

Ahora, haz el request GET http://localhost:3000/ usando Postman, y revisa si el body de la respuesta es igual a alguno de los archivos del proyecto. Significa eso que es un recurso web dinámico o estático?

### PARTE III. - HACIENDO UNA APLICACIÓN WEB DINÁMICA USANDO EL PATRÓN MVC
En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de spring MVC.

Para esto usaremos la documentación oficial de Spring con que que aprenderemos las funciones básicas de este framework https://spring.io/guides/gs/serving-web-content/

Después de terminar el aprendizaje analice:
- ¿Por qué MVC obtiene ese nombre? (puede apoyarse de https://www.javatpoint.com/spring-mvc-tutorial)
    - RESPUESTA: Recibe ese nombre debido a sus siglas. Cada sigla significa lo siguiente:
        - M (Modelo): Designa la capa lógica de datos de la aplicación, encargada de gestionar el acceso y manipulación de la información para su procesamiento. Incluye elementos como bases de datos, archivos y servicios web.
        - V (Vista): Encargada de la representación visual de la información, responsable de exhibir la interfaz y presentar los datos al usuario final de manera comprensible y atractiva.
        - C (Controlador): Actúa como intermediario entre el Modelo y la Vista, gestionando las solicitudes del usuario. El Controlador interpreta las acciones del usuario y coordina las interacciones entre el Modelo y la Vista.
   
- ¿Cuáles son las ventajas de usar MVC?
    - RESPUESTA:
        - El patrón de diseño MVC descompone el código en tres partes distintas: Modelo, Vista y Controlador.
        - Simplifica la reutilización y el mantenimiento del código fuente.
        - Habilita la realización de pruebas de forma más directa y eficiente.
        - Facilita la adaptación de la aplicación a medida que aumenta su complejidad.
        - Optimiza la estructura, organización y facilidad de mantenimiento de las aplicaciones.
        - Favorece una disposición estructurada y modular en el desarrollo del proyecto.
        - Simplifica el flujo de trabajo y fomenta prácticas de programación sólidas y eficaces.
- ¿Qué diferencia tiene la estructura de directorios de este proyecto comparado con las de proyectos pasados (con solo maven y java EE)?
    - RESPUESTA:
        - Las variaciones se originan por la incorporación de nuevas funciones, la reestructuración del código existente, la eliminación de código desactualizado o la optimización del código para mejorar su calidad y mantenibilidad.
        - La utilización de un marco web específico, como Spring MVC.
        - La carpeta src/main/resources/static se emplea para alojar los recursos estáticos de la aplicación web.
        - La falta de directorios concretos de Java EE.
        - La configuración suplementaria de Spring, como application.properties.
- ¿Qué anotaciones usaste y cuál es la diferencia entre ellas?
    - RESPUESTA:
        - @GetMapping("/greeting"): Asocia las solicitudes HTTP GET a métodos particulares dentro de un controlador.
        - @ResponseBody: Indica que el valor devuelto por un método de controlador debe ser vinculado directamente al cuerpo de la respuesta HTTP, en lugar de ser vinculado a una vista. Es útil cuando se desea retornar datos en formato JSON o XML directamente desde un          controlador.
        - @Controller: Se emplea para identificar una clase como un controlador en Spring MVC. Los controladores manejan las peticiones HTTP y retornan las respuestas correspondientes.
        - @RequestMapping("/User/{id}"): Esta anotación se utiliza para asignar solicitudes HTTP a métodos específicos del controlador y permite el uso de variables de ruta, como {id} en este caso, que serán pasadas como parámetros al método del controlador.
        - @SpringBootApplication: Esta etiqueta se utiliza para marcar la clase principal de una aplicación Spring Boot. Combina tres anotaciones: @Configuration, @EnableAutoConfiguration y @ComponentScan. Indica que la clase es una clase de configuración, habilita la          configuración automática de Spring Boot basada en el contenido del classpath y escanea los paquetes en busca de componentes de Spring.
- Ahora, haz el request GET http://localhost:8080/greeting usando Postman, y revisa si el body de la respuesta es igual a alguno de los archivos del proyecto. Significa eso que es un recurso web dinámico o estático?

### PARTE IV. - APLICACIÓN MVC PARA CONSUMO DE SERVICIO RESTful
Usando la arquitectura MVC del punto anterior (el proyecto anterior), realice una aplicación simple qué permita navegar gráficamente sobre esta API
https://jsonplaceholder.typicode.com/todos/1, puede guiarse de tutoriales como https://medium.com/@nutanbhogendrasharma/consume-rest-api-in-spring-boot-web-application-354c404850f0

Luego de terminada esta parte responda:
- ¿Qué es RESTful?
    - RESPUESTA:
        - RESTful (Representational State Transfer) es un paradigma arquitectónico que impulsa la creación de APIs web para sistemas distribuidos. Se basa en estándares y protocolos web como HTTP y se centra en la manipulación de recursos identificados mediante URLs,           utilizando métodos HTTP estándar como pueden ser GET, POST, DELETE, PUT. Este enfoque facilita una comunicación coherente y eficiente entre sistemas al seguir un conjunto común de prácticas para la manipulación de recursos a través de la web.
- Si utilizo un framework como [Boostrap CSS](https://getbootstrap.com/) para qué el apartado gráfico se vea más profesional, ¿en qué capa se haría su uso?

### PARTE V. - APLICACIÓN MVC JUEGO
¡Llego la hora del reto! Teniendo las bases del uso del framework, cree una nueva ruta, por ejemplo `/guess`, y agrege formulario básico con un campo llamado "número" (guía de como crear formularios HTML https://www.w3schools.com/html/)

Y vamos a implementar la lógica de nuestro juego:
1. Se trata de un juego en línea para adivinar un número, en el que el ganador, si acierta en la primera oportunidad, recibe $100.000. Luego, por cada intento fallido, el premio
se reduce en $10.000, como en los juegos de apuesta, es natural qué quede en saldos negativos.
2. El número a adivinar debe ser generado en cada intento y comparado con el número qué el usuario está insertando, es un número de 1 a 10.
3. Debe existir un botón de reset, qué permita al jugador iniciar de nuevo.
4. La capa de controlador debe procer el número del usuario mediante método `POST`.

Analice las siguientes situaciones:
- ¿Qué pasa si abro el sitio de juegos en dos navegadores difententes?
    - RESPUESTA:
        - Si ingresamos al sitio de juegos desde dos navegadores distintos, cada uno creará una sesión única con el servidor. En consecuencia, cada sesión manejará su propio juego, con su propio número secreto por adivinar y su saldo exclusivo. De esta manera, los              juegos en ambos navegadores se desarrollarán completamente de forma independiente entre sí.
- Si quisiera qué a cada jugador le aparecieran independientemente sus respectivos saldos. ¿Qué habría que hacer?
    - RESPUESTA:
        - Si queremos garantizar que cada jugador tenga acceso exclusivo a sus saldos, podemos emplear la funcionalidad de sesión de Flask para almacenar los números a adivinar y los saldos de cada usuario de manera separada. Esto implica que la gestión de la sesión en         Flask se lleva a cabo de manera individual para cada usuario, lo que conlleva que cada jugador tenga su propio saldo y progreso en el juego, sin que las acciones de otros jugadores en el mismo sitio web tengan ningún impacto en ellos.

## ENTREGA
- En un README.md colocar lo siguiente:
- Una sección llamada “INTEGRANTES” y allícolocar el listado de los integrantes del taller (máximo 2).
- Una sección llamada “RESPUESTAS” colocar lasrespuestas a las preguntas:
- Configurar el archivo .gitignore para excluir del repositorio los archivos no relevantes.
- En una carpeta en la raiz del repositorio llamada diagrams y allí realizar un diagrama de clases del proyecto.
