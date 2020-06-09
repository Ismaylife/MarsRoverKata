import org.junit.Test
import kotlin.test.assertEquals

class RoverShould{

    @Test
    fun be_in_a_given_coordinates(){
        val axisX = 0
        val axisY = 0
        val orientation = 'N'

        val rover = Rover(x = axisX, y = axisY, orientation = orientation)
        assertEquals(rover.x, axisX)
        assertEquals(rover.y, axisY)
    }

    @Test
    fun be_in_a_given_orientation(){
        val axisX = 0
        val axisY = 0
        val orientation = 'N'

        val rover = Rover(x = axisX, y = axisY, orientation = orientation)
        assertEquals(rover.orientation, orientation)
    }

    @Test
    fun move_to_the_front(){
        val axisX = 0
        val axisY = 0
        val orientation = 'N'
        val movement = "f"

        val rover = Rover(x = axisX, y = axisY, orientation = orientation)
        rover.move(movement)
        assertEquals(rover.y, axisY + 1)
    }

    @Test
    fun move_to_the_back(){
        val axisX = 0
        val axisY = 0
        val orientation = 'N'
        val movement = "b"

        val rover = Rover(x = axisX, y = axisY, orientation = orientation)
        rover.move(movement)
        assertEquals(axisY - 1, rover.y)
    }

    @Test
    fun be_reoriented(){
        val axisX = 0
        val axisY = 0
        val orientation = 'N'
        var movement = "r"

        var rover = Rover(x = axisX, y = axisY, orientation = orientation)
        rover.move(movement)
        assertEquals('E', rover.orientation)

        movement = "l"

        rover = Rover(x = axisX, y = axisY, orientation = orientation)
        rover.move(movement)
        assertEquals('W', rover.orientation)
    }

    @Test
    fun move_and_rotate_with_a_String_instructions_given(){
        val axisX = 0
        val axisY = 0
        val orientation = 'N'
        var movement = "fffrf"

        var rover = Rover(x = axisX, y = axisY, orientation = orientation)
        rover.move(movement)
        assertEquals(3, rover.y)
        assertEquals(1, rover.x)

    }




}