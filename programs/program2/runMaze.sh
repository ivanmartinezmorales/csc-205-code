echo "Compiling maze"

javac -target 1.4 Direction.java Maze.java MazeDisplay.java MazeSolver.java StartSolvingMaze.java

echo "Executing StartSolvingMaze"

java StartSolvingMaze
echo "Compiling ResumeSolvingMaze"
javac -target 1.4 ResumeSolvingMaze.java
echo "Starting ResumeSolvingMaze"
