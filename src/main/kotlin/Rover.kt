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