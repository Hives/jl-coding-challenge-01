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

    @Test
    fun `formatTime(60) returns "1 minute"`() {
        assertEquals("1 minute", formatTime(60))
    }

    @Test
    fun `formatTime(61) returns "1 minute and 1 second"`() {
        assertEquals("1 minute and 1 second", formatTime(61))
    }

    @Test
    fun `formatTime(62) returns "1 minute and 2 seconds"`() {
        assertEquals("1 minute and 2 seconds", formatTime(62))
    }

    @Test
    fun `formatTime(119) returns "1 minute and 59 seconds"`() {
        assertEquals("1 minute and 59 seconds", formatTime(119))
    }

    @Test
    fun `formatTime(120) returns "2 minutes"`() {
        assertEquals("2 minutes", formatTime(120))
    }

    @Test
    fun `formatTime(3599) returns "59 minutes and 59 seconds"`() {
        assertEquals("59 minutes and 59 seconds", formatTime(3599))
    }

    @Test
    fun `formatTime(3600) returns "1 hour"`() {
        assertEquals("1 hour", formatTime(3600))
    }

    @Test
    fun `formatTime(3601) returns "1 hour and 1 second"`() {
        assertEquals("1 hour and 1 second", formatTime(3601))
    }

    @Test
    fun `formatTime(3660) returns "1 hour and 1 minute"`() {
        assertEquals("1 hour and 1 minute", formatTime(3660))
    }

    @Test
    fun `formatTime(3661) returns "1 hour, 1 minute and 1 second"`() {
        assertEquals("1 hour, 1 minute and 1 second", formatTime(3661))
    }

    @Test
    fun `formatTime(60 * 60 * 24) returns "1 day"`() {
        assertEquals("1 day", formatTime(60 * 60 * 24))
    }

    @Test
    fun `formatTime(60 * 60 * 24 * 365) returns "1 year"`() {
        assertEquals("1 year", formatTime(60 * 60 * 24 * 365))
    }
}
