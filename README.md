# Piedra, Papel o Tijera

Aplicación Android del clásico juego de **Piedra, Papel o Tijera**, desarrollada con **Kotlin y XML**.

El jugador elige una opción y la CPU genera una elección aleatoria. Después se muestra quién ha ganado y se actualiza el marcador.

## Capturas

<img width="378" height="612" alt="image" src="https://github.com/user-attachments/assets/01340116-aed1-4cc0-aff0-9ec93338057e" />
<img width="372" height="606" alt="image" src="https://github.com/user-attachments/assets/427a2b63-922f-45f6-8ae3-9c81f78bfa75" />

## Características

- Juego de Piedra, Papel o Tijera contra la CPU.
- Elección aleatoria de la CPU.
- Visualización de la elección del jugador y de la CPU.
- Contador de:
  - Puntos del jugador.
  - Puntos de la CPU.
  - Empates.
- Botón para reiniciar la partida.
- Interfaz sencilla con `ConstraintLayout` y `CardView`.

## Tecnologías utilizadas

- **Kotlin**
- **XML**
- **Android Studio**
- **ConstraintLayout**
- **CardView**
- `ImageView`
- `TextView`
- `Button`

## Funcionamiento

Las opciones están representadas mediante números:

```text
1 → Piedra
2 → Papel
3 → Tijera
```

Cuando el jugador pulsa uno de los botones:

1. Se muestra su elección.
2. Se genera aleatoriamente la elección de la CPU.
3. Se muestran ambas elecciones.
4. Se comprueba quién gana.
5. Se actualiza el marcador.

### Reglas

| Jugador | CPU | Resultado |
|---|---|---|
| Piedra | Tijera | Gana el jugador |
| Papel | Piedra | Gana el jugador |
| Tijera | Papel | Gana el jugador |
| Misma elección | Misma elección | Empate |
| Piedra | Papel | Gana la CPU |
| Papel | Tijera | Gana la CPU |
| Tijera | Piedra | Gana la CPU |

## Estructura principal

### `MainActivity.kt`

Se encarga de la lógica del juego:

- Controlar las elecciones del jugador.
- Generar la elección aleatoria de la CPU.
- Determinar el ganador.
- Actualizar las imágenes.
- Actualizar el marcador.
- Reiniciar la partida.

### `activity_main.xml`

Contiene la interfaz gráfica de la aplicación:

- Título del juego.
- Elección del jugador.
- Elección de la CPU.
- Imágenes de las elecciones.
- Resultado de la partida.
- Botones de Piedra, Papel y Tijera.
- Marcador.
- Botón de reinicio.

## Lógica de la CPU

La CPU utiliza un número aleatorio entre `1` y `3`:

```kotlin
val seleccion: Int = (1..3).random()
```

Dependiendo del número obtenido, se muestra una imagen diferente:

```text
1 → Piedra
2 → Papel
3 → Tijera
```

## Marcador

Durante la partida se almacenan tres contadores:

```kotlin
var contadorPuntTu: Int = 0
var contadorPuntCPU: Int = 0
var contadorEmpates: Int = 0
```

Cada vez que termina una ronda se incrementa el contador correspondiente.

El botón **REINICIAR** pone todos los contadores a `0` y devuelve las imágenes a su estado inicial.


