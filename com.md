javac -d bin --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls src/*.java

java -cp bin:img --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls 'nom Executable'




javac -d bin --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/*.java

java --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml -cp bin MainApp
