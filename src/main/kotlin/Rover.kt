data class Rover(var x: Int, var y: Int, var orientation: Char) {

    fun move(commands: String) {
        for (char: Char in commands) {

            when(char) {
                'f' -> goFront (this.orientation)
                'b' -> goBack (this.orientation)
                'l','r' -> rotate(char)
            }
        }
    }

    private fun goFront(orientation : Char){
        when (orientation) {
            'N' -> this.y++
            'E' -> this.x++
            'S' -> this.y--
            'W' -> this.x--
        }
    }

    private fun goBack(orientation : Char){
        when (this.orientation) {
            'N' -> this.y--
            'E' -> this.x--
            'S' -> this.y++
            'W' -> this.x++
        }
    }

    private fun rotate(orientation: Char) {

        var coordinates = "NESW"
        var indexActualOrientation = coordinates.indexOf(this.orientation)
        var indexNewOrientation = indexActualOrientation

        if (orientation == 'r') {
            if (indexActualOrientation == 3) {
                indexNewOrientation = 0
            } else {
                indexNewOrientation++
            }
        }

        if (orientation == 'l') {
            if (indexActualOrientation == 0) {
                indexNewOrientation = 3
            } else {
                indexNewOrientation--
            }
        }

        this.orientation = coordinates[indexNewOrientation]
    }

}

data class Map(val maxWidth: Int, val MaxHeight: Int) {
    fun checkMapLimits() {
    }
}

data class Obstacles(var obstacles: List<Obstacle>) {
    fun checkMapObstacles() : Boolean {
        return false;
    }
}

data class Obstacle(val x: Int, val y: Int)