import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class RoverShould {

    lateinit var rover: Rover

    @Before
    fun generate_rover() {
        rover = Rover(x = 0, y = 0, orientation = 'N')
    }

    @Test
    fun generate_a_rover() {
        assertEquals('N', rover.orientation)
        assertEquals(0, rover.x)
        assertEquals(0, rover.y)
    }

    @Test
    fun move_to_the_front() {
        rover.move("f")
        assertEquals(0 + 1, rover.y)
    }

    @Test
    fun move_to_the_back() {
        rover.move("b")
        assertEquals(0 - 1, rover.y)
    }

    @Test
    fun be_reoriented_to_the_right() {
        var movement = "r"
        rover.move(movement)
        assertEquals('E', rover.orientation)
    }

    @Test
    fun be_reoriented_to_the_left() {
        var movement = "l"
        rover.move(movement)
        assertEquals('W', rover.orientation)
    }

    @Test
    fun move_and_rotate_with_multiple_instructions_given() {
        rover.move("fffrf")
        assertEquals(3, rover.y)
        assertEquals(1, rover.x)
    }
}