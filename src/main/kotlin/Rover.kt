data class Rover(var x: Int, var y: Int, var orientation: Char) {

    private val map = Map(10, 10)
    private val obstacle = Obstacle(Coordinates(5, 5))
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
        lateinit var newPosition : Coordinates

        newPosition = calculateNewPositionGoingForward(coordinates)

        this.x = newPosition.x
        this.y = newPosition.y
    }

    private fun calculateNewPositionGoingForward(coordinates: Coordinates): Coordinates {
        return when (this.orientation) {
            'N' -> confirmMovement(coordinates.x, coordinates.y + 1)
            'E' -> confirmMovement(coordinates.x + 1, coordinates.y)
            'S' -> confirmMovement(coordinates.x, coordinates.y - 1)
            'W' -> confirmMovement(coordinates.x - 1, coordinates.y)
            else -> coordinates
        }
    }

    private fun goBack() {

        this.x = calculateNewPositionGoingBackwards(Coordinates(x, y)).x
        this.y = calculateNewPositionGoingBackwards(Coordinates(x, y)).y
    }

    private fun calculateNewPositionGoingBackwards(coordinates: Coordinates): Coordinates {
        return when (this.orientation) {
            'N' -> confirmMovement(coordinates.x, coordinates.y - 1)
            'E' -> confirmMovement(coordinates.x - 1, coordinates.y)
            'S' -> confirmMovement(coordinates.x, coordinates.y + 1)
            'W' -> confirmMovement(coordinates.x + 1, coordinates.y)
            else -> coordinates
        }
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
            if (isIntoMapSLimits(x, y)){
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


    private fun isIntoMapSLimits(x: Int, y: Int): Boolean {
        return !(x > 10 || x < 0 || y > 10 || y < 0)
    }

    private fun isAnyObstacle(x: Int, y: Int): Boolean {
        var thereIs = false
        for (obstacle in obstacleList) {
            if (obstacle.getX() == x && obstacle.getY() == y) {
                thereIs = true
                return thereIs
            }
        }
        return thereIs
    }

}

data class Coordinates(var x: Int, var y: Int)

data class Map(val maxWidth: Int, val maxHeight: Int)

data class Obstacle(val coordinates : Coordinates){
    fun getX() : Int{
        return this.coordinates.x
    }
    fun getY() : Int{
        return this.coordinates.y
    }
}