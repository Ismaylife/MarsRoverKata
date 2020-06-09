data class Rover(var x: Int, var y: Int, var orientation: Char) {

    fun move(commands: String) {
        for (char: Char in commands) {

            if (char == 'f') {

                when(this.orientation){
                    'N' -> this.y++
                    'E' -> this.x++
                    'S' -> this.y--
                    'W' -> this.x--
                }
            }

            if (char == 'b') {
                when(this.orientation){
                    'N' -> this.y--
                    'E' -> this.x--
                    'S' -> this.y++
                    'W' -> this.x++
                }
            }

            if (char == 'r' || char == 'l') {
                rotate(char)
            }
        }
    }

    private fun rotate(direction: Char) {

        var coordinates = "NESW"
        var indexActualOrientation = coordinates.indexOf(this.orientation)

        if (direction == 'r') {
            if (indexActualOrientation == 3) {
                indexActualOrientation = 0
            } else {
                indexActualOrientation++
            }
        }

        if (direction == 'l') {
            if (indexActualOrientation == 0) {
                indexActualOrientation = 3
            } else {
                indexActualOrientation--
            }
        }

        this.orientation = coordinates[indexActualOrientation]
    }
}