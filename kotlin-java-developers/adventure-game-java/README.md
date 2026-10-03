# Adventure Game — Java

A 141-room text adventure game, written in Java. This is the **starting point** of
the [Udemy course "Kotlin for Java Developers"](https://www.udemy.com/course/kotlin-for-java-developers/) by Sarah
Ettrich and Tim Buchalka — the course begins by analyzing this Java version (lesson 13: *Text Adventure Game: Code
Structure and Functionality*) and then converts it to Kotlin (lessons 14–15).

The player starts in room **64** and explores the map by entering directions. Entering `Q` moves you to room **0**,
which ends the game.

## How to play

- On every turn the game prints the room description and the list of available exits.
- Move with `N`, `S`, `E`, `W` (cardinal directions), `U`/`D` (up/down).
- `Q` quits the game.
- An invalid direction prints `You cannot go in that direction`.

## Project structure

```
adventure-game-java/
├── src/main/java/com/timbuchalka/
│   ├── Main.java          # game loop: reads directions from stdin
│   ├── Location.java      # one room: id, description, exits
│   └── Locations.java     # loads the map data at startup
├── locations_big.txt      # 141 rooms, comma-delimited:  <id>,<description>
├── directions_big.txt     # exits, one per line:          <room>,<direction>,<destination>
├── locations.txt          # small 6-room sample map from earlier course lessons
├── directions.txt         # (not read by the current code)
├── build.gradle.kts       # Java + application plugin
├── settings.gradle.kts
├── gradlew / gradlew.bat  # Gradle wrapper (Gradle 9.6.0)
└── gradle/wrapper/
```

`locations_big.txt` and `directions_big.txt` are read **at runtime from the working directory**, so the game must be
started from the project root (both methods below do this automatically).

`.gradle/` and `build/` are generated build caches. They are gitignored and can be deleted at any time.

## How to run

Requires a **JDK 17 or newer** (verified with JDK 21). No Gradle installation is needed — the wrapper downloads Gradle
automatically.

### IntelliJ IDEA

1. Open this folder (*File → Open…* and select `adventure-game-java`) and let IDEA import it as a Gradle project.
2. Set the build delegation so the Run console can read input: *File → Settings → Build, Execution, Deployment → Build
   Tools → Gradle* → select **`adventure-game-java`** in the project tree → set **Build and run using:** to **IntelliJ
   IDEA** → *OK*. (With the default "Gradle" option, runs are executed by Gradle and the program receives no stdin, so
   it cannot read your directions.)
3. Click the green arrow next to `main` in `Main.java` and choose **Run 'Main'**.

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
- Original Java version © Tim Buchalka / Learn Programming Academy. All rights belong to their respective owners; this
  copy is kept here for personal educational purposes.
- Room descriptions are adapted from the classic *Colossal Cave Adventure* text, which has been widely reused in
  programming tutorials.

## Local modifications

Changes made relative to the original course source, so this copy runs as a modern, self-contained Gradle project:

- Converted to a Gradle build (`build.gradle.kts`, `settings.gradle.kts`, wrapper) with the standard `src/main/java`
  source layout.
- Removed `KotlinLocation.kt` — a Kotlin translation of `Location.java` kept alongside it for the conversion lessons;
  both declared the same class and could not compile together.
- Removed `lib/` — obsolete Kotlin 1.1 standard-library jars (2017) that were only needed to compile Kotlin inside a
  plain IntelliJ project.
- Added an EOF guard in `Main.java` (`hasNextLine()`) so the game exits cleanly instead of throwing
  `NoSuchElementException` when no input is available.
