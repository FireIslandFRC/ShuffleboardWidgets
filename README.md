# MyWidgets

## Project Creation
1. Clone the repository
1. Enter the directory called [example-plugins](example-plugins)
1. From there, create a copy of the folder called example-widget
1. Then, rename the folder and gradle file to your project's name
1. Add an entry in settings.gradle with the import statements formatted as
```Java
import "example-plugins:PROJECT_NAME"
```

## Widget Project Structure
- The file directly inside of `java/com/example/simplewidget` should be suffixed with Plugin, and almost never touched
- `java/com/example/simplewidget/widget` should be suffixed with Widget, and contains information about how a widget will use inputs
- `resources/com/example/simplewidget` contains an fxml file which should have the same name as `com/example/simplewidget/widget`, and determines how the widget looks
> [!CAUTION]
> Fxml is really bad at reporting errors, so if the widget fails to load, check that file with extreme care
- `java/com/example/simplewidget/data` and its subdirectories define custom types for widgets, but aren't very often necessary

## Building
Due to the fact that a full gradle build takes upwards of ten minutes, the project allows smaller builds for individual plugins.
To build a single plugin, type the following into a terminal
```
./gradlew example-plugins:PROJECT_NAME:InstallPlugin
```
This will build your plugin and place it directly in the ~/Shuffleboard/plugins directory