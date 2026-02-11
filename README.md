# Estructuras de Almacenamiento Complejas en Java

Este repositorio contiene ejemplos y material práctico sobre el uso de **estructuras de almacenamiento complejas en Java**, centrado en **colecciones**, **genéricos**, **interfaces funcionales**, **expresiones lambda** y **Streams**.

El objetivo es comprender cómo Java gestiona estructuras dinámicas de datos y cómo aprovechar un enfoque más moderno y funcional para su procesamiento.

---

## 📚 Contenidos

El proyecto cubre los siguientes temas:

### 1. Introducción a las Colecciones
- Limitaciones de los arrays tradicionales
- Ventajas de las colecciones dinámicas
- Uso de estructuras flexibles para almacenar datos

### 2. Conceptos Previos
- **Clases envoltorio (Wrappers)**: uso de tipos objeto en lugar de primitivos
- **Genéricos**:
  - Clases genéricas
  - Métodos genéricos
  - Operador diamante (`<>`)

### 3. Contenedores en Java
- Interfaz `Collection`
- Interfaz `Iterator`
- Interfaz `Set`
  - `HashSet`
  - `LinkedHashSet`
  - `TreeSet`
- Interfaz `List`
  - `ArrayList`
  - `LinkedList`
- Diferencias entre `ArrayList` y `LinkedList`
- Listas ordenadas (`Comparable` y `Comparator`)

### 4. Interfaz `Map`
- Concepto clave-valor
- `HashMap`, `Hashtable`, `TreeMap`, `LinkedHashMap`
- Recorridos mediante:
  - `keySet()`
  - `values()`
  - `entrySet()`

### 5. Pilas y Colas
- Estructura **LIFO** (Stack)
- Estructura **FIFO** (Queue)
- Comparación entre pila y cola

### 6. Interfaces Funcionales y Expresiones Lambda
- Qué es una interfaz funcional
- Uso de expresiones lambda
- Comparación con clases anónimas
- Interfaces funcionales clave:
  - `Predicate`
  - `Function`
  - `Consumer`
  - `Supplier`

### 7. Streams
- Creación de Streams
- Operaciones intermedias:
  - `filter`
  - `map`
  - `sorted`
  - `distinct`
- Operaciones terminales:
  - `forEach`
  - `collect`
  - `reduce`
  - `count`
- Referencias a métodos y constructores
- Ejemplos completos de procesamiento de datos

### 8. Conclusiones
- Ventajas de las colecciones frente a arrays
- Importancia de genéricos y wrappers
- Beneficios del enfoque funcional con lambdas y streams

---

## 🛠️ Tecnologías Utilizadas

- **Java 8 o superior**
- API estándar de Java (`java.util`, `java.util.function`, `java.util.stream`)

---

## 🎯 Objetivos de Aprendizaje

- Comprender la jerarquía de colecciones en Java
- Elegir la estructura adecuada según el caso de uso
- Implementar ordenaciones personalizadas
- Utilizar expresiones lambda para simplificar el código
- Procesar colecciones de forma declarativa con Streams

---

## ▶️ Cómo Ejecutar los Ejemplos

1. Clona el repositorio:
   ```bash
   git clone https://github.com/msceada1/genericos-colecciones-y-lambdas
