## Project Creation
1. Clone the repository
1. Enter the directory called [example-plugins](example-plugins)
1. From there, create a copy of the folder called [example-widget](example-plugins/example-widget)
1. Then, rename the folder and gradle file to your project's name
1. Add an entry in settings.gradle with the import statements formatted as
```Java
import "example-plugins:PROJECT_NAME"
```

## Widget Project Structure
- The file directly inside of [java/com/example/simplewidget](example-plugins/example-widget/java/com/example/simplewidget) should be suffixed with `Plugin`, and almost never touched
- [java/com/example/simplewidget/widget](example-plugins/example-widget/src/main/java/com/example/simplewidget/widget) should be suffixed with `Widget`, and contains information about how a widget will use inputs
- [resources/com/example/simplewidget](example-plugins/example-widget/resources/com/example) contains an fxml file which should have the same name as [com/example/simplewidget/widget](example-plugins/example-widget/java/com/example/simplewidget/widget), and determines how the widget looks
> [!CAUTION]
> Fxml is really bad at reporting errors, so if a widget fails to load, check the fxml file with extreme care
- [java/com/example/simplewidget/data](example-plugins/example-widget/java/com/example/simplewidget/data) and its subdirectories define custom types for widgets, but aren't very often necessary

## Building
Due to the fact that a full gradle build takes upwards of ten minutes, the project allows smaller builds for individual plugins.
To build a single plugin, type the following into a terminal
```bash
./gradlew example-plugins:PROJECT_NAME:InstallPlugin
```
This will build your plugin and place it directly in the ~/Shuffleboard/plugins directory

## Docs
For more information, check the WPI docs [here](https://docs.wpilib.org/en/stable/docs/software/dashboards/shuffleboard/custom-widgets/index.html)
or the wiki [here](https://github.com/4329/ShuffleboardWidgets/wiki)