# ✈️ Calculadora de Gastos de Viaje

<p align="center">
  <img src="Logo%20Agencia%20de%20Viajes.jpg" alt="Logo de la Agencia de Viajes" width="300">
</p>

Aplicación de consola en **Java** que reparte el coste de un viaje en grupo entre sus miembros. Indica qué cantidad debe **pagar** y qué cantidad debe **recibir** cada viajero para que todos acaben pagando lo mismo.

Proyecto realizado para la **Práctica grupal del Tema 2** de Programación, por encargo (ficticio) de una agencia de viajes.

---

## 📑 Índice

1. [Descripción](#-descripción)
2. [Requisitos](#-requisitos)
3. [Cómo ejecutar el programa](#-cómo-ejecutar-el-programa)
4. [Instrucciones de uso](#-instrucciones-de-uso)
5. [Cómo funciona el reparto](#-cómo-funciona-el-reparto)
6. [Ejemplo de uso](#-ejemplo-de-uso)
7. [Estructura del proyecto](#-estructura-del-proyecto)
8. [Documentación](#-documentación)
9. [Equipo de desarrollo](#-equipo-de-desarrollo)

---

## 📝 Descripción

Cuando un grupo de amigos se va de viaje, normalmente no paga todo el mundo lo mismo: uno paga el hotel, otro la gasolina, otro las cenas... Al volver, hacer las cuentas puede ser un lío.

Esta aplicación lo soluciona:

- Admite hasta **5 viajeros**.
- Se introduce lo que ha pagado cada uno.
- El programa calcula cuánto le corresponde pagar a cada persona (la media).
- Muestra quién tiene que **poner dinero** y quién tiene que **recibirlo**.
- Si en algún viajero se introduce **`-1`**, el programa entiende que **ese viajero no existe** y no lo tiene en cuenta para el reparto.

---

## 💻 Requisitos

| Requisito | Versión |
|---|---|
| Java (JDK para compilar / JRE para ejecutar) | **25 o superior** |
| Sistema operativo | Windows, Linux o macOS |

> ⚠️ El programa usa la forma simplificada del método principal (`static void main()` sin `String[] args`), que es oficial a partir de **Java 25**. Con versiones anteriores no compilará.

Para comprobar qué versión de Java tienes instalada, abre una terminal y escribe:

```bash
java -version
```

Si no tienes Java, puedes descargarlo desde la web oficial de Oracle u OpenJDK (por ejemplo, [Adoptium](https://adoptium.net/)).

---

## ▶️ Cómo ejecutar el programa

### Opción 1: Desde la terminal (con `javac` y `java`)

1. Descarga o clona el repositorio:

   ```bash
   git clone https://github.com/Rafaav14/TrabajoProgramaci-n.git
   ```

2. Entra en la carpeta del proyecto:

   ```bash
   cd TrabajoProgramaci-n
   ```

3. **Compila** el código fuente. Esto genera el archivo `Principal.class` dentro de la carpeta `out`:

   ```bash
   javac -encoding UTF-8 -d out src/Principal.java
   ```

4. **Ejecuta** el programa:

   ```bash
   java -cp out Principal
   ```

> 💡 La opción `-encoding UTF-8` sirve para que las tildes y la ñ se lean bien al compilar, sobre todo en Windows.

### Opción 2: Desde IntelliJ IDEA

1. Abre la carpeta del proyecto con IntelliJ IDEA.
2. Abre el archivo `src/Principal.java`.
3. Pulsa el botón verde ▶️ que aparece junto al método `main`.

---

## 📖 Instrucciones de uso

Al arrancar, el programa pregunta **cuántos viajeros** han hecho el viaje (entre 1 y 5). Si se introduce un número fuera de ese rango, muestra un error.

Después aparece el **menú principal**:

```
---MENÚ---
1. Introducir gastos de los viajeros
2. Calcular reparto de gastos
3. Mostrar el reparto de los viajeros
4. Salir
```

| Opción | Qué hace |
|---|---|
| **1. Introducir gastos** | Pide lo que ha pagado cada uno de los 5 viajeros, uno a uno (*"Gastos del viajero 1:"*, *"Gastos del viajero 2:"*...). Para un viajero que no existe se escribe **`-1`** y no cuenta para el reparto. |
| **2. Calcular reparto** | Suma todos los gastos, calcula la media y obtiene el saldo de cada viajero. |
| **3. Mostrar reparto** | Muestra por pantalla cuánto debe pagar o recibir cada viajero, con 2 decimales. Los viajeros con `-1` no aparecen. |
| **4. Salir** | Cierra el programa. |

### 🔒 Orden obligatorio

El programa controla que las opciones se hagan en orden:

- No se puede usar la **opción 2** sin haber hecho antes la **opción 1**.
- No se puede usar la **opción 3** sin haber hecho antes la **1** y la **2**.
- Si se vuelven a introducir los gastos (**opción 1**) después de calcular, hay que volver a calcular el reparto (**opción 2**) antes de mostrarlo, porque el anterior ya no vale.

Si se intenta, el programa avisa y vuelve al menú. Por ejemplo, al elegir la opción 3 sin haber calculado el reparto aparece:

```
Debe realizar los pasos 1 y 2 en el menú antes de continuar.
```

---

## 🧮 Cómo funciona el reparto

El cálculo es sencillo:

1. Se **suman** los gastos de todos los viajeros que existen (los que no tienen `-1`).
2. Se **divide** el total entre el número de viajeros reales. Eso es lo que **le corresponde pagar a cada uno** (la media).
3. Para cada viajero se calcula su **saldo**:

   ```
   saldo = lo que ha pagado − media
   ```

4. Interpretación del saldo:
   - **Saldo positivo** ➜ ha pagado de más, así que **debe recibir** ese dinero.
   - **Saldo negativo** ➜ ha pagado de menos, así que **debe pagar** esa cantidad.
   - **Saldo 0** ➜ está en paz.

---

## 🧪 Ejemplo de uso

Cuatro amigos se van de viaje. El programa pide los gastos de los 5 viajeros, así que en el quinto se pone `-1`:

| Viajero | Ha pagado |
|---|---|
| Viajero 1 | 100 € |
| Viajero 2 | 50 € |
| Viajero 3 | 30 € |
| Viajero 4 | 20 € |
| Viajero 5 | `-1` (no existe) |

- **Total:** 100 + 50 + 30 + 20 = **200 €**
- **Viajeros reales:** 4
- **Le toca pagar a cada uno:** 200 / 4 = **50 €**

| Viajero | Saldo | Resultado |
|---|---|---|
| Viajero 1 | 100 − 50 = **+50** | Debe **recibir** 50 € |
| Viajero 2 | 50 − 50 = **0** | Está en paz |
| Viajero 3 | 30 − 50 = **−20** | Debe **pagar** 20 € |
| Viajero 4 | 20 − 50 = **−30** | Debe **pagar** 30 € |

Así, los viajeros 3 y 4 ponen entre los dos 50 €, que son justo los que tiene que recibir el viajero 1.

Esto es lo que muestra el programa al elegir la **opción 3**:

```
---REPARTO DE GASTOS---
Viajero 1 debe recibir 50,00 €
Viajero 2 no debe pagar ni recibir nada.
Viajero 3 debe pagar 20,00 €
Viajero 4 debe pagar 30,00 €
```

> El viajero 5 no aparece porque se introdujo `-1`, y tampoco cuenta para la media.

---

## 📁 Estructura del proyecto

```
TrabajoProgramaci-n/
├── src/
│   └── Principal.java                        # Código fuente del programa
├── Logo Agencia de Viajes.jpg                # Logo de la aplicación
├── Guía Calculadora de Gastos de Viaje.pdf   # Manual de usuario
├── Documento de Gastos.pdf                   # Costes del desarrollo
├── README.md                                 # Este documento
└── trabajoViajes.iml                         # Configuración de IntelliJ IDEA
```

---

## 📚 Documentación

Además del código, el proyecto incluye:

- 📘 **[Manual de usuario](Gu%C3%ADa%20Calculadora%20de%20Gastos%20de%20Viaje.pdf)**: guía paso a paso para usar la aplicación.
- 💰 **[Costes del desarrollo](Documento%20de%20Gastos.pdf)**: estudio de cuánto costaría desarrollar esta aplicación según el modelo de negocio elegido.
- 🎨 **Logo**: imagen de presentación de la aplicación, generada con ayuda de una herramienta de IA.

---

## 👥 Equipo de desarrollo

| Integrante | Aportaciones |
|---|---|
| Raúl Gómez Vera | Entrada principal, menú, opción 1, logo y manual de usuario |
| Arturo Rivera | Opción 2 (cálculo del reparto) y documento de costes |
| Rafa Valero Jiménez | Opción 3 (mostrar el reparto), README y documentación del proyecto |

> Proyecto desarrollado con **Java** e **IntelliJ IDEA**, y gestionado con **Git** y **GitHub**.
