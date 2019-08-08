import org.junit.Test
import org.junit.Assert.assertEquals

internal class Time_formatterKtTest {

    @Test
    fun `0 seconds returns "none"`() {
        assertEquals("none", formatTime(0))
    }

    @Test
    fun `formatTime(1) returns "1 second"`() {
        assertEquals("1 second", formatTime(1))
    }

    @Test
    fun `formatTime(2) returns "2 seconds"`() {
        assertEquals("2 seconds", formatTime(2))
    }

    @Test
    fun `formatTime(59) returns "59 seconds"`() {
        assertEquals("59 seconds", formatTime(59))
    }
}
