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
        when (this.orientation) {
            'N' -> if (checkMovement(this.x, this.y + 1)) this.y++ else this.y = 0
            'E' -> if (checkMovement(this.x + 1, this.y)) this.x++ else this.x = 0
            'S' -> if (checkMovement(this.x, this.y - 1)) this.y-- else this.y = map.maxHeight
            'W' -> if (checkMovement(this.x - 1, this.y)) this.x-- else this.x = map.maxWidth
        }
    }

    private fun goBack() {
        when (this.orientation) {
            'N' -> if (checkMovement(this.x, this.y - 1)) this.y-- else this.y = map.maxHeight
            'E' -> if (checkMovement(this.x - 1, this.y)) this.x-- else this.x = map.maxWidth
            'S' -> if (checkMovement(this.x, this.y + 1)) this.y++ else this.y = 0
            'W' -> if (checkMovement(this.x + 1, this.y)) this.x++ else this.x = 0
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

    private fun checkMovement(x: Int, y: Int): Boolean {
        return isIntoMapLimits(x, y) && !isAnyObstacle(x, y)

    }


    private fun isIntoMapLimits(x: Int, y: Int): Boolean {
        val map = Map(10, 10)
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


data class Map(val maxWidth: Int, val maxHeight: Int)

data class Obstacle(val x: Int, val y: Int)