# Java-Factory

This is designed to be a fairly intuitive example usage of the Factory pattern, using hopefully what is a familiar concept to many: Minecraft mobs. 

The goal here isn't to have code that actually does anything functionally. Just to show an example of how the Factory pattern can be applied.

## Installation

Well, you need Java. 

```bash
brew install openjdk@21
```

This gets OpenJDK Java21 and installs it. 

You can check that you're running Java21 by running: 

```bash
java --version;
```

A Mac may already have a version of Java installed in `/usr/bin/java`. You'll be able to tell by running: 

```bash
which java;
```

If that outputs `/opt/homebrew/opt/openjdk@21/bin` then you're golden. If not, you may need to play a little in `~/.zshrc`. 

Appending to your `$path` array *should* work: 

```bash
path+=("/opt/homebrew/opt/openjdk@21/bin");
```

If that doesn't, you can ensure that it's *prepended before* the standard Mac installed version: 

```bash
path=("$(brew --prefix openjdk@21)/bin" $path)
```

I've also used Maven, as that's a fairly standard choice. 

```bash
brew install mvn;
```

Check that's okay by running: 

```bash
mvn --version;
```

I then ran the following Maven command to initialise the repo: 

```bash
mvn archetype:generate -DgroupId=com.example \
  -DartifactId=console-app \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
```

## Running

### Build

Navigate into the app: 

```bash
cd console-app
```

and then run: 

```bash
mvn package
```

### Run

```bash
java -cp target/console-app-1.0-SNAPSHOT.jar com.example.App
```

### Run tests

```bash
mvn test
```

or for a specific test: 

```bash
mvn -Dtest=AppTest test
```


## Dependencies

- Mockito (for testing)
- Guice (for dependency injection)