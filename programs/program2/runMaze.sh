echo "Compiling maze"

javac Direction.java Maze.java MazeDisplay.java MazeSolver.java StartSolvingMaze.java

echo "Executing StartSolvingMaze"

java StartSolvingMaze
echo "Compiling ResumeSolvingMaze"
javac ResumeSolvingMaze.java
echo "Starting ResumeSolvingMaze"
