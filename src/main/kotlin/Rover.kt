data class Rover(var x: Int, var y: Int, var orientation: Char) {

    fun move(commands: String) {
        for (command: Char in commands) {
            when(command) {
                'f' -> goFront ()
                'b' -> goBack ()
                'l','r' -> rotate(command)
            }
        }
    }

    private fun goFront(){
        when (this.orientation) {
            'N' -> this.y++
            'E' -> this.x++
            'S' -> this.y--
            'W' -> this.x--
        }
    }

    private fun goBack(){
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
        var indexOfNewOrientation = indexActualOrientation

        when(orientation){
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