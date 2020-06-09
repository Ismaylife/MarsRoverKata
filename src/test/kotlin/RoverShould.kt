import org.junit.Test
import kotlin.test.assertEquals

class RoverShould{

    @Test
    fun be_in_a_coordinates(){
        val axisX = 0
        val axisY = 0

        val rover = Rover(x = axisX, y = axisY)
        assertEquals(rover.x, axisX)
        assertEquals(rover.y, axisY)
    }

}