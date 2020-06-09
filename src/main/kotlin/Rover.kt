data class Rover(var x: Int, var y: Int, var orientation: Char){

    fun move(direction : Char){
        if (direction == 'f'){
            this.y++
        }
    }
}