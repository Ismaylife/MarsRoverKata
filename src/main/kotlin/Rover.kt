data class Rover(var x: Int, var y: Int, var orientation: Char) {

    val map = Map(10 , 10)

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
            'N' -> if (isIntoMapLimits(this.x, this.y + 1))this.y++ else this.y = 0
            'E' -> if (isIntoMapLimits(this.x + 1, this.y))this.x++ else this.x = 0
            'S' -> if (isIntoMapLimits(this.x, this.y - 1)) this.y-- else this.y = map.maxHeight
            'W' -> if (isIntoMapLimits(this.x - 1, this.y)) this.x-- else this.x = map.maxWidth
        }
    }

    private fun goBack(){
        when (this.orientation) {
            'N' -> if (isIntoMapLimits(this.x, this.y - 1)) this.y-- else this.y = map.maxHeight
            'E' -> if (isIntoMapLimits(this.x - 1, this.y)) this.x-- else this.x = map.maxWidth
            'S' -> if (isIntoMapLimits(this.x, this.y + 1))this.y++ else this.y = 0
            'W' -> if (isIntoMapLimits(this.x + 1, this.y))this.x++ else this.x = 0
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

    private fun isIntoMapLimits(x : Int, y: Int) : Boolean {
        val map = Map(10, 10)
        return !(x > 10 || x < 0 || y > 10 || y < 0)
    }

    private fun Checker(){



        /* fun checkMovement () : Boolean{
             checkMapLimits()
             checkMapObstacles()
             return false
         }*/

        /*fun checkMapObstacles(){

        }*/
    }

}


data class Map (val maxWidth: Int, val maxHeight: Int)

data class Obstacles(var obstacles: List<Obstacle>)

data class Obstacle(val x: Int, val y: Int)