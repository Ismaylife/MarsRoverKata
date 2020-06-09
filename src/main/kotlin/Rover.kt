data class Rover(var x: Int, var y: Int, var orientation: Char){

    fun move(direction : Char){

        if (direction == 'f'){
            this.y++
        }

        if (direction == 'b'){
            this.y--
        }

        if (direction == 'r' || direction == 'l'){
            rotate(direction)
        }
    }

    private fun rotate(direction: Char){

        var coordinates = "NESW"
        var indexActualOrientation = coordinates.indexOf(this.orientation)

        if(direction == 'r'){
            if(indexActualOrientation == 3){
                indexActualOrientation = 0
            }
            else {
                indexActualOrientation++
            }
        }

        if(direction == 'l'){
            if(indexActualOrientation == 0){
                indexActualOrientation = 3
            }
            else{
                indexActualOrientation--
            }
        }

        this.orientation = coordinates[indexActualOrientation]
    }
}