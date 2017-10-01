# Key Collector

A board game designed by 3 students from Multimedia University of Cyberjaya, Malaysia for an Object-Oriented Analysis &amp; Design project.

## Installation and Usage

To compile and run the program, you will need the [Java SE Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

First, clone the repository.

```bash
$ git clone https://github.com/pyrox18/key-collector.git
$ cd key-collector
```

Run `javac *.java` to compile all of the source files, then run `java KeyCollector` to run the program.

## How To Play

![](https://i.imgur.com/td6cREG.png)

The objective of this game is to collect all five keys available on the board, and use it to unlock the chest available in the middle of the board. The board has an area of 9x9 squares. The first player to collect all five keys and unlock the chest will be the winner of the game. The keys are randomly placed on the board each time a new game is started.

Additionally, the player's movement is restricted based on the most recent key that the player has picked up. The keys and their respective movement rules are as follows:

- **Default**: Players can move *up to* 2 squares in any one direction. Players start with this form of movement when they do not have any keys.
- **Monkey**: Players can move *up to* 3 squares in any one direction.
- **Pinkey**: Players can move *up to* 1 square in any one direction.
- **Donkey**: Players can move *up to* 3 squares diagonally.
- **Key Note**: Players can move *exactly* 2 squares in any one direction.
- **Key Disk**: Players can move *up to* 3 squares horizontally or vertically.

The square that the player is currently on will be highlighted in orange, and the squares that the player can make valid moves to are highlighted in green.

Players must strategise to pick up the right keys at the right times to secure a swift victory against other players, as certain keys can limit the player's movement and affect the number of turns needed to get to another key (or possibly the chest).

There are also features to save and load games, so you can pick up the game from where you left it off easily.

## Contributing

We welcome bug reports or suggestions to improve the game. Please create an issue detailing your report/request as specific as possible.

If you would like to contribute directly to the project, feel free to fork the repository for you to work on as you see fit. Then, open a pull request with descriptions of your changes and we'll look into it. You can either help to close some existing issues, or even add a feature of your own (subject to our approval).

### Commit Message Guidelines

Commit messages must follow the standard commit message guidelines, which can be found [here](https://chris.beams.io/posts/git-commit/). In short, commit messages must have a subject of less than 50 characters, with an optional description limited to 72 characters per line. Message subjects must be written in the imperative mood (e.g. "Add constructor method", NOT "Added constructor method" or "Adds constructor method", etc.).

### Documentation

As per the assignment requirements, all of the Java source files must have comments in them to state the contributors to the file and to explain what the code does. We choose to retain this requirement after this project is open-sourced as well. In favour of standardisation, **all comments should be written according to the [Javadoc](https://en.wikipedia.org/wiki/Javadoc) style**.

### Code Style

For code style, [standard Java naming conventions](http://www.oracle.com/technetwork/java/codeconventions-135099.html) must be followed. This project uses **4 spaces** for indentation, and uses LF as the end-of-line character. A Visual Studio Code workspace settings file is included for this setting, should you be using that editor (it's our preferred editor).

## License

This project is distributed under the GNU General Public License v3.0. See [this link](https://choosealicense.com/licenses/gpl-3.0/) for more information on the license.

## Credits

- **Mohamed Haryz Izzudin bin Mohamed Rafy** (@pyrox18): Original developer
- **Muhammad Faishal Dzaky** (@zafum5): Original developer
- **Ramanan R Muralitharan** (@RamFromSudan): Original developer *(not actually from Sudan)*
- **Dr. Ian Chai** of Multimedia University, Cyberjaya, Malaysia: Icon artwork and assignment requirement guidelines that led to the creation of this project