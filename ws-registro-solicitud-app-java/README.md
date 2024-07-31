# ws-registro-solicitud-app-java
<img src="imagenes/ngmartinezs-icon.jpg" alt="Autor" width="130" height="90" />


**Autor:** [ngmartinezs](https://github.com/ngmartinezs)

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java](https://img.shields.io/badge/Java-21-blue)](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-blue)](https://spring.io/projects/spring-boot)
[![Azure Service Bus](https://img.shields.io/badge/Azure%20Service%20Bus-2.4.0-blue)](https://azure.microsoft.com/en-us/services/service-bus/)
[![Maven](https://img.shields.io/badge/Maven-3.8.2-blue)](https://maven.apache.org/download.cgi)




Este proyecto Spring Boot, denominado `ws-registro-solicitud-app-java`, está diseñado para facilitar la recepción de comandos de registro de solicitudes y la generación de eventos sobre topics. Utilizando tecnologías como Spring Boot, Spring Cloud Azure, y Azure Messaging Service Bus, este proyecto se posiciona como una solución robusta para la integración y manejo de eventos en arquitecturas basadas en microservicios.

## Características

- **Spring Boot**: Aprovecha las capacidades de autoconfiguración de Spring Boot para simplificar el desarrollo de aplicaciones y servicios.
- **Spring Cloud Azure**: Integración con Azure para el manejo de configuraciones y secretos, facilitando la interoperabilidad con servicios en la nube.
- **Azure Messaging Service Bus**: Utiliza el servicio de bus de mensajes de Azure para la comunicación asíncrona y la distribución de eventos.

## Estructura de Paquetes

```mermaid
graph TD
    A[com.ngmartinezs.wsregsolicitudclientejava] --> B[controller]
    A --> C[dto]
    A --> D[mapper]
    A --> E[model]
    A --> Z[messaging]
    A --> F[repository]
    A --> G[service]
    A --> H[util]
    A --> I[WsRegSolicitudClienteJavaApplication.java]

    B --> J[WsRegSolicitudClienteController.java]

    C --> K[message]
    C --> L[RequesDTO.java]
    C --> M[ResponseDTO.java]

    D --> P[Mapper.java]

    E --> Q[Solicitud.java]

    Z --> R[MessageService.java]
    Z --> T[Azure]



```

## Comenzando

Para comenzar a trabajar con `ws-registro-solicitud-app-java`, asegúrate de tener Maven y Java 21 instalados en tu entorno de desarrollo. Este proyecto utiliza Maven Wrapper para facilitar la gestión de dependencias y la construcción del proyecto.

### Prerrequisitos

- Java 21
- Maven

### Instalación

Sigue estos pasos para configurar el entorno de desarrollo:

1. Clona el repositorio:

    
    git clone [URL del repositorio]

2. Navega al directorio del proyecto:

    cd ws-registro-solicitud-app-java

3. Ejecuta Maven Wrapper para compilar el proyecto:

    ./mvnw clean install


## Ejecutando las pruebas

Este proyecto utiliza Spring Boot Starter Test para la definición y ejecución de pruebas unitarias y de integración. Para ejecutar las pruebas, utiliza el siguiente comando:

./mvnw test

Para más información sobre cómo contribuir al proyecto, configuraciones avanzadas y guías de desarrollo, consulta la documentación adicional proporcionada en `HELP.md`.


