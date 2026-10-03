# Adventure Game — Kotlin

The Kotlin version of the 141-room text adventure game from
the [Udemy course "Kotlin for Java Developers"](https://www.udemy.com/course/kotlin-for-java-developers/) by Sarah
Ettrich and Tim Buchalka. It is the result of converting the course's Java starting point to Kotlin (lessons 14–15:
*Hands-on Conversion: Transforming the Java Text Adventure Game to Kotlin* and *Leveraging IntelliJ IDEA's Automatic
Java-to-Kotlin Code Converter*).

The player starts in room **64** and explores the map by entering directions. Entering `Q` moves you to room **0**,
which ends the game.

## How to play

- On every turn the game prints the room description and the list of available exits.
- Move with `N`, `S`, `E`, `W` (cardinal directions), `U`/`D` (up/down).
- `Q` quits the game.
- An invalid direction prints `You can't go in that direction`.

## Project structure

```
adventure-game-kotlin/
├── src/main/kotlin/academy/learnprogramming/textadventure/
│   ├── Main.kt            # game loop: reads directions from stdin
│   ├── Location.kt        # data class for one room: id, description, exits
│   └── Locations.kt       # readLocationInfo(): loads the map data
├── locations_big.txt      # 141 rooms, backtick-delimited:  <id>`<description>
├── directions_big.txt     # exits, one per line:           <room>,<direction>,<destination>
├── build.gradle.kts       # Kotlin JVM + application plugin (Kotlin 2.4.10)
├── settings.gradle.kts
├── gradlew / gradlew.bat  # Gradle wrapper (Gradle 9.6.0)
└── gradle/wrapper/
```

Note the format difference from the Java version: here the room file is delimited with backticks (`` ` ``), while the
Java project uses commas.

`locations_big.txt` and `directions_big.txt` are read **at runtime from the working directory**, so the game must be
started from the project root (both methods below do this automatically).

`.kotlin/`, `.gradle/` and `build/` are generated tooling/build caches. They are gitignored and can be deleted at any
time.

## How to run

Requires a **JDK 17 or newer** (verified with JDK 21). No Gradle installation is needed — the wrapper downloads Gradle
automatically.

### IntelliJ IDEA

1. Open this folder (*File → Open…* and select `adventure-game-kotlin`) and let IDEA import it as a Gradle project (the
   Kotlin plugin provides stdlib support automatically).
2. Set the build delegation so the Run console can read input: *File → Settings → Build, Execution, Deployment → Build
   Tools → Gradle* → select **`adventure-game-kotlin`** in the project tree → set **Build and run using:** to **IntelliJ
   IDEA** → *OK*. (With the default "Gradle" option, runs are executed by Gradle and the program receives no stdin, so
   it cannot read your directions.)
3. Click the green arrow next to `main` in `Main.kt` and choose **Run 'MainKt'**.

### Command line

```bash
./gradlew run        # Linux / macOS
gradlew.bat run      # Windows
```

Type your moves directly into the console; `Q` quits.

## Origin and credits

- Source code from the Udemy
  course [Kotlin for Java Developers](https://www.udemy.com/course/kotlin-for-java-developers/) by **Sarah Ettrich** and
  **Tim Buchalka** — [The Learn Programming Academy](https://learnprogramming.academy/).
- Original versions © Tim Buchalka / Learn Programming Academy. All rights belong to their respective owners; this copy
  is kept here for personal educational purposes.
- Room descriptions are adapted from the classic *Colossal Cave Adventure* text, which has been widely reused in
  programming tutorials.

## Local modifications

Changes made relative to the original course source, so this copy runs as a modern, self-contained Gradle project:

- Converted to a Gradle build (`build.gradle.kts`, `settings.gradle.kts`, wrapper) with the standard `src/main/kotlin`
  source layout.
- `Main.kt`: `toUpperCase()` → `uppercase()` — the old name is a hard compile error on Kotlin 2.4.
- `Main.kt`: added an EOF guard (`readLine() ?: break`) so the game exits cleanly instead of looping forever when no
  input is available.
- `Main.kt`: added `println()` after the exits list so the output line is terminated (parity with the Java version).
