# Proyecto de Gestión de Eventos e Integración con Azure Service Bus
<img src="imagenes/ngmartinezs-icon.jpg" alt="Autor" width="130" height="90" />


**Autor:** [ngmartinezs](https://github.com/ngmartinezs)

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java](https://img.shields.io/badge/Java-21-blue)](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-blue)](https://spring.io/projects/spring-boot)
[![Azure Service Bus](https://img.shields.io/badge/Azure%20Service%20Bus-2.4.0-blue)](https://azure.microsoft.com/en-us/services/service-bus/)
[![Maven](https://img.shields.io/badge/Maven-3.8.2-blue)](https://maven.apache.org/download.cgi)

# ngmartinezs-event-management-spring-boot-asb

### Decripción del Proyecto

Este proyecto ejemplifica el funcionamiento de un sistema basado en eventos utilizando Java 21 con Spring Boot. El sistema gestiona la integración y comunicación entre servicios mediante Azure Service Bus. El proyecto contiene tres subproyectos:


## Subproyectos
1. **ws-registro-solicitud-app-java**: Permite el registro de una solicitud de afiliación a un producto.
2. **ws-ms-cuentas-app-java**: Contiene un componente que se suscribe a una cola y un topic en Azure Service Bus, activándose tras el registro de una solicitud.
3. **ws-ms-clientes-app-java**: Contiene un componente Spring Boot que atiende los registros cuando se crea una solicitud de afiliación.

```mermaid
graph LR
client[Cliente] -- https/rest --> A[ws-registro-solicitud-app-java]
A -- solicitudCreada Event --> B[topic:creacion-solicitud-event]
B -- message --> C[ subscription/queue creacion-cliente-event-sub]
B -- message --> D[ subscription/queue creacion-cuenta-event-sub]
D-- crearCuenta Command --> F[ws-ms-cuentas-app-java] 
C -- crearCliente Command --> E[ws-ms-clientes-app-java]
```


## Tabla de Contenidos
- [Descripción del Proyecto](#descripción-del-proyecto)
- [Arquitectura del Sistema](#arquitectura-del-sistema)
- [Pre-requisitos](#pre-requisitos)
- [Configuración del Proyecto](#configuración-del-proyecto)
- [Subproyectos](#subproyectos)
  - [ws-registro-solicitud-app-java](#ws-registro-solicitud-app-java)
  - [ws-ms-cuentas-app-java](#ws-ms-cuentas-app-java)
  - [ws-ms-clientes-app-java](#ws-ms-clientes-app-java)
- [Ejecutando el Proyecto](#ejecutando-el-proyecto)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Descripción del Proyecto

Este proyecto es un ejemplo de cómo implementar un sistema distribuido basado en eventos utilizando Java 21 y Spring Boot. Se utiliza Azure Service Bus para la mensajería y coordinación entre los servicios.

## Arquitectura del Sistema

![Arquitectura del Sistema](ruta/a/tu/diagrama.png)

1. **ws-registro-solicitud-app-java**: Envía mensajes a una cola de Azure Service Bus cuando se registra una solicitud de afiliación.
2. **ws-ms-cuentas-app-java**: Se suscribe a la cola y topic de Azure Service Bus para procesar las solicitudes de afiliación.
3. **ws-ms-clientes-app-java**: Procesa las solicitudes y realiza las operaciones necesarias para la afiliación.

## Pre-requisitos

- JDK 21
- Apache Maven 3.6+
- Cuenta de Azure con acceso a Azure Service Bus
- IDE como IntelliJ IDEA o Eclipse

## Configuración del Proyecto

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio

2. Crear una cuenta de Azure y configurar un Service Bus.

Crear un namespace en Azure Service Bus.
Crear una cola y un topic.
Obtener la cadena de conexión de Azure Service Bus y agregarla a los archivos de configuración de Spring Boot (application.properties o application.yml).

3. Configurar los subproyectos para que utilicen la cadena de conexión de Azure Service Bus.

## Subproyectos
### ws-registro-solicitud-app-java
Este subproyecto permite registrar una solicitud de afiliación a un producto.

#### Funciones Principales:

API REST para registrar solicitudes.
Envío de mensajes a Azure Service Bus.
##### Configuración:
###### application.properties
```
spring.application.name=ws-registro-solicitud-app
azure.servicebus.connection-string=tu_cadena_de_conexion
```
##### Ejecucion:
```bash
cd ws-registro-solicitud-app-java
mvn spring-boot:run
```
### ws-ms-cuentas-app-java
Este subproyecto contiene un componente que se suscribe a una cola y un topic en Azure Service Bus, activándose tras el registro de una solicitud.

#### Funciones Principales: 
1. Escucha de mensajes de la cola y topic de Azure Service Bus.
2. Procesamiento de solicitudes de afiliación.
##### Configuración:
###### application.properties
```
spring.application.name=ws-registro-solicitud-app
azure.servicebus.connection-string=tu_cadena_de_conexion
```
##### Ejecucion:
```bash
cd ws-registro-solicitud-app-java
mvn spring-boot:run
```
### ws-ms-clientes-app-java
Este subproyecto contiene un componente Spring Boot que atiende los registros cuando se crea una solicitud de afiliación.

#### Funciones Principales:
1. Procesamiento de solicitudes de afiliación.
2. Creación de cuentas de clientes.
##### Configuración:
###### application.properties
```
spring.application.name=ws-registro-solicitud-app
azure.servicebus.connection-string=tu_cadena_de_conexion
```
##### Ejecucion:
```bash
cd ws-registro-solicitud-app-java
mvn spring-boot:run
```
## Ejecutando el Proyecto   
1. Ejecutar el subproyecto ws-registro-solicitud-app-java.
2. Ejecutar el subproyecto ws-ms-cuentas-app-java.
3. Ejecutar el subproyecto ws-ms-clientes-app-java.

## Contribuciones
Las contribuciones son bienvenidas. Para cambios importantes, por favor, abre un issue primero para discutir qué te gustaría cambiar.

## Licencia
[MIT](https://choosealicense.com/licenses/mit/)
```
