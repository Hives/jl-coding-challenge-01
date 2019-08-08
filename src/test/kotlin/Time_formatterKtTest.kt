import org.junit.Test
import org.junit.Assert.assertEquals

internal class Time_formatterKtTest {

    @Test
    fun `0 seconds returns 'none'`() {
        assertEquals("none", formatTime(0))
    }

    @Test
    fun `1 second returns '1 second'`() {
        assertEquals("1 second", formatTime(1))
    }
}
