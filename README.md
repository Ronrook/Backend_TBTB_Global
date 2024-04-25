# CLINICAL_RECORD
TBTB GLOBAL requiere una aplicación para llevar un registro de los pacientes, medicos, citas y medicamentos.

<h2>TBTB - Prueba técnica</h2>


<h3> 🚀 Dirigido a </h3>

- 👨‍💻 &nbsp; TBTB GLOBAL



<h3> 👨🏻•💻 Dev </h3>

-  [@RonaldRosero](https://github.com/RonaldRosero)

## Objetivo

El objetivo de este proyecto es la creación e implementación de RESTful API para una base de datos diseñada por el desarrollador,


## Parte 1: Bases de Datos
- Se requiere el diseño de una base de datos donde se aprecie claramente una relación uno a muchos y otra
muchos a muchos
- Se requiere la generación de dos archivos SQL, uno para la creación y configuración de elementos de base de datos (Tablas) y otro para la implementación
de diversas transacciones (Insert, Select, Update, Delete)
### Tecnologías Utilizadas
- MySQL
- MySQL Workbench
### Entregables
- En la carpeta **Scripts** encontrarás los scripts utilizados para crear y poblar la base de datos MySQL. Los archivos **ScriptDDL** contienen las instrucciones para la creación de las tablas, mientras que en **ScriptDML** encontrarás el llenado de las tablas y las consultas correspondientes. El modelo entidad-relación está disponible en el archivo **DER-CLINICAL_RECORD**.


## Parte 2: Interfaz de Programación de Aplicaciones (API)

Se requiere la implementación de RESTful API para una de las tablas generadas en
la primera parte, para lo cual se deben habilitar 5 endpoints que permitan validar el correcto
funcionamiento del CRUD de dicha entidad (Create, Read, Update, Delete). Endpoints a desarrollar:

- Insert or Create: Crear un nuevo registro
- Get All: Leer todos los registros de la tabla
- Get By Id: Leer un registro especifico de la tabla por Id
- Update: Actualizar un registro especifico de la tabla
- Delete: Eliminar un registro especifico de la tabla

### Tecnologías Utilizadas
- Spring Boot 3.2.5
- Java 17

### Dependencias
- Spring Web
- MySQL Driver
- Lombok
- Spring Data JPA
- Swagger

### Configuración Local
1. Clonar el repositorio de gitHub -> Link del repositorio
2. Crea una base de datos MySQL utilizando los scripts proporcionados anteriormente.
3. Asegúrate de usar las mismas versiones de las tecnologías mencionadas para evitar conflictos.
4. Utiliza un entorno de desarrollo compatible con Spring Boot, como Eclipse, NetBeans, SpringToolSuite o IntelliJ.
5. En el archivo env.properties escribir en las variables los valores de conexión de la base de datos
6. En la terminal ejecuta el comando  `mvn spring-boot:run` o ejecuta el programa desde el archivo `PruebaTecnicaApplication`.
7. Una vez que el programa esté en funcionamiento, puedes consultar los endpoints en la documentación de Swagger:
    - [Documentación de Swagger Local](http://localhost:8080/swagger-ui/swagger-ui/index.html)




