import org.junit.Test
import org.junit.Assert.assertEquals

internal class Time_formatterKtTest {
    @Test
    fun `0 seconds returns 'none'`() {
        assertEquals("none", formatTime(0))
    }
}
