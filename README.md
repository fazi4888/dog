# Frogger

> This is a student project for G52SWM at UoN. The goal of the project is to maintain and extend a [re-implementation](https://github.com/hirish99/Frogger-Arcade-Game) of a classic retro game (Frogger).

## Table of Contents

- [Prerequisite](#prerequisite)
- [Build & Run](#build-&-run)
- [Source File Structure](#source-file-structure)
- [Work For Maintenance & Extension](#work-for-maintenance-&-extension)
- [Other Details](#other-details)

## Prerequisite

- Java 10 or later
- Maven

## Build & Run

To launch the app use the following command:

```
mvn clean compile package exec:java
``` 

The following dependencies will be downloaded:

- javafx-controls 11.0.2 (org.openjfx)
- javafx-fxml 11.0.2 (org.openjfx)
- javafx-graphics 11.0.2 (org.openjfx)
- javafx-media 11.0.2 (org.openjfx)
- commens-io 2.6 (commons-io)

## Source File Structure

```
src
├── main
│  ├── java
│  │  └── frogger
│  │      ├── constant
│  │      ├── controller
│  │      ├── model
│  │      │  └── actor
│  │      └── util
│  └── resources
│      └── frogger
│          ├── css
│          ├── font
│          ├── image
│          │  ├── car
│          │  ├── death
│          │  ├── end
│          │  ├── frog
│          │  ├── home
│          │  ├── log
│          │  └── turtle
│          ├── music
│          └── view
└── test
​    └── java
​        └── frogger
```

## Work For Maintenance & Extension

### Categorize The Resources

At the beginning, there are so many images and all in one folder. I move them to the corresponding folders.

### Use MVC Pattern

From the directory tree above,

### Use Singleton Pattern

#### `SceneSwitch`

#### `TouchChecker` & `TouchHandler`

#### `MusicPlayer`

### Package `constant`

### Add Abstract Class `AutomaticActor` & Interface `Transformable`

### Add Class `Game`

### 2-Player Mode

A part of what I'm so proud of but also brought me some trouble.

In the old version, the handling of keyboard events was put in `Animal` which leads to a problem that two frogs should not use one set of operators. (i.e. When user presses a key, two frogs should not jump together.)

To solve this problem, I move the code for handling keyboard events to `World` and two sets of operators in `Operation` are used to judging the jump direction. Now frog just needs to know which direction to jump.

## Other Details

### Scoreboard

### Something For Fun

`HomeAnimation` added a jumping frog on the start and selection screen.

### WorldLoader & PreloadedActor

In fact, there are only three frogs in the game no matter how many games are created. One for the animation and two for the game. 

The reason is that all actors are stored in `PreloadedActor`. When a user starts a new game, `WorldLoader` simply takes actors out, resets them and draw them on the pane. No new frog is created.

### Limit User Input

The player's name has a limitation of 8 characters and letters only.

## Finally

I spent at least 100 hours on this project and I did try my best. Because of time, there are still some features that have not been added.

Thanks to my boyfriend for giving me the inspiration of 2-player mode and I beat him in the game :)