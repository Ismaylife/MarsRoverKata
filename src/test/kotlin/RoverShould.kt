import org.junit.Test
import kotlin.test.assertEquals

class RoverShould{

    @Test
    fun be_in_a_given_coordinates(){
        val axisX = 0
        val axisY = 0
        val orientation = 'S'

        val rover = Rover(x = axisX, y = axisY, orientation = orientation)
        assertEquals(rover.x, axisX)
        assertEquals(rover.y, axisY)
    }

    @Test
    fun be_oriented(){
        val axisX = 0
        val axisY = 0
        val orientation = 'S'

        val rover = Rover(x = axisX, y = axisY, orientation = orientation)
        assertEquals(rover.orientation, orientation)
    }

    @Test
    fun move_to_the_front(){
        val axisX = 0
        val axisY = 0
        val orientation = 'S'
        val movement = 'f'

        val rover = Rover(x = axisX, y = axisY, orientation = orientation)
        rover.move(movement)
        assertEquals(rover.y, axisY + 1)
    }

    @Test
    fun move_to_the_back(){
        val axisX = 0
        val axisY = 0
        val orientation = 'S'
        val movement = 'b'

        val rover = Rover(x = axisX, y = axisY, orientation = orientation)
        rover.move(movement)
        assertEquals(axisY - 1, rover.y)
    }


}