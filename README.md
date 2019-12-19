# Frogger

> This is a student project for G52SWM at UoN. The goal of the project is to maintain and extend a [re-implementation](https://github.com/hirish99/Frogger-Arcade-Game) of a classic retro game (Frogger).

## Table of Contents

- [Prerequisite](#prerequisite)
- [Build And Run](#build-and-run)
- [Source File Structure](#source-file-structure)
- [Work For Maintenance And Extension](#work-for-maintenance-and-extension)
- [Other Details](#other-details)
- [Finally](#finally)

## Prerequisite

- Java 10 or later
- Maven

## Build And Run

Tested on:

- Lab Machine
- macOS Java 10 + JavaFX 10

Build script:

```
mvn clean compile package exec:java
```

The following dependencies will be downloaded:

- javafx-controls 11.0.2 (org.openjfx)
- javafx-fxml 11.0.2 (org.openjfx)
- javafx-graphics 11.0.2 (org.openjfx)
- javafx-media 11.0.2 (org.openjfx)
- commons-io 2.6 (commons-io)

## Source File Structure

```
src
└── main
   ├── java
   │  └── frogger
   │      ├── constant
   │      ├── controller
   │      ├── model
   │      │  └── actor
   │      └── util
   └── resources
       └── frogger
           ├── css
           ├── font
           ├── image
           │  ├── car
           │  ├── death
           │  ├── end
           │  ├── frog
           │  ├── home
           │  ├── log
           │  └── turtle
           ├── music
           └── view
```

## Work For Maintenance And Extension

Overall, the original file structure was very messy. I tried to decouple it by putting classes into different packages, extracting the parent classes and creating interfaces. I also added some new content (such as 2-player mode).

### Categorize The Resources

At the beginning, there are so many images and all in one folder. I moved them to the corresponding sub-folders.

### Use MVC Pattern

From the directory tree above, it can be seen MVC pattern is used to seperate the components of the application.

### Use Singleton Pattern

- `SceneSwitch`

- `TouchChecker` & `TouchHandler`

- `MusicPlayer`

### Package `constant`

Try to prevent undefined constants from appearing directly in the code, package `constant` is used to warp these constants in, such like different types of death, the game mode and game level.

However, there are still some magic number :-(

### Abstract Class `AutomaticActor` 

`AutomaticActor` is a `Actor` which is not controlled by the user.

This abstract class defines some methods, such as automatic horizontal movement, which increase the reusability of the code.

### 2-Player Mode

A part of what I'm so proud of but also brought me some trouble.

In the old version, the handling of keyboard events was put in `Animal` which leads to a problem that two frogs should not use one set of operators. (i.e. When user presses a key, two frogs should not jump together.)

To solve this problem, I moved the code for handling keyboard events to `World` and two sets of operators in `Operation` are used to judging the jump direction. Now frog just needs to know which direction to jump.

### Different Levels

The game has three levels of difficulty, but I can't beat the hard level :p

## Other Details

### Something For Fun

`HomeAnimation` adds a jumping frog on the start and selection screen.

### WorldLoader & PreloadedActor

In fact, there are only three frogs in the game no matter how many games are created. One for the animation and two for the game. 

The reason is that all actors are stored in `PreloadedActor`. When a user starts a new game, `WorldLoader` simply takes actors out, resets them and draw them on the pane. No new frog is created.

### Limit User Input

The player's name has a limitation of 8 characters and letters only.

### Fly In The End

There will be a fly appears in ends randomly~

## Finally

I have spent ~150 hours on this project and I have tried my best.

Thanks to my boyfriend for giving me the inspiration of 2-player mode and I beat him in the game :-)

