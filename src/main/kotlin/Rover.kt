import kotlin.math.sign

data class Rover(var x: Int, var y: Int, var orientation: Char) {

    private val map = Map(10, 10)
    private val obstacle = Obstacle(5, 5)
    private val obstacleList = listOf<Obstacle>(obstacle)

    fun move(commands: String) {
        for (command: Char in commands) {
            when (command) {
                'f' -> goFront()
                'b' -> goBack()
                'l', 'r' -> rotate(command)
            }
        }
    }

    private fun goFront() {
        var coordinates = Coordinates(this.x, this.y)
        var newPosition = coordinates

        when (this.orientation) {
            'N' -> newPosition = confirmMovement(coordinates.x, coordinates.y + 1)
            'E' -> newPosition = confirmMovement(coordinates.x + 1, coordinates.y)
            'S' -> newPosition = confirmMovement(coordinates.x, coordinates.y - 1)
            'W' -> newPosition = confirmMovement(coordinates.x - 1, coordinates.y)
        }

        this.x = newPosition.x
        this.y = newPosition.y
    }

    private fun goBack() {
        var coordinates = Coordinates(this.x, this.y)
        var newPosition = coordinates

        when (this.orientation) {
            'N' -> newPosition = confirmMovement(coordinates.x, coordinates.y - 1)
            'E' -> newPosition = confirmMovement(coordinates.x - 1, coordinates.y)
            'S' -> newPosition = confirmMovement(coordinates.x, coordinates.y + 1)
            'W' -> newPosition = confirmMovement(coordinates.x + 1, coordinates.y)
        }

        this.x = newPosition.x
        this.y = newPosition.y
    }

    private fun rotate(orientation: Char) {

        var coordinates = "NESW"
        var indexActualOrientation = coordinates.indexOf(this.orientation)
        var indexOfNewOrientation = indexActualOrientation

        when (orientation) {
            'r' -> {
                if (indexActualOrientation == 3) {
                    indexOfNewOrientation = 0
                } else {
                    indexOfNewOrientation++
                }
            }

            'l' -> {
                if (indexActualOrientation == 0) {
                    indexOfNewOrientation = 3
                } else {
                    indexOfNewOrientation--
                }
            }
        }

        this.orientation = coordinates[indexOfNewOrientation]
    }

    private fun confirmMovement(x: Int, y: Int): Coordinates {
        var newPosition = Coordinates(this.x, this.y)
        if(!isAnyObstacle(x, y)){
            if (isIntoMapLimits(x, y)){
                newPosition.x = x
                newPosition.y = y
            }
            else {
                when{
                    x < 0  -> newPosition.x = map.maxWidth
                    x > 10 -> newPosition.x = 0
                    y < 0  -> newPosition.y = map.maxHeight
                    y > 10 -> newPosition.y = 0
                }
            }
        }

        return newPosition
    }


    private fun isIntoMapLimits(x: Int, y: Int): Boolean {
        return !(x > 10 || x < 0 || y > 10 || y < 0)
    }

    private fun isAnyObstacle(x: Int, y: Int): Boolean {
        var thereIs = false
        for (obstacle in obstacleList) {
            if (obstacle.x == x && obstacle.y == y) {
                thereIs = true
                return thereIs
            }
        }
        return thereIs
    }


}

data class Coordinates(var x: Int, var y: Int)

data class Map(val maxWidth: Int, val maxHeight: Int)

data class Obstacle(val x: Int, val y: Int)