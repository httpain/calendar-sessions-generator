package com.httpain.sessions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import picocli.CommandLine
import java.io.PrintWriter
import java.io.StringWriter

class CalendarGeneratorCommandTest {

    @Test
    fun `should parse simple schedule`() {
        val app = CalendarGeneratorCommand()
        val cmd = CommandLine(app)

        val sw = StringWriter()
        cmd.out = PrintWriter(sw)

        val exitCode = cmd.execute("-r", "tue", "14:30", "-r", "fri", "17:00", "-d", "1h30m")
        assertEquals(0, exitCode)
        assertEquals("recurrence: '[[tue, 14:30], [fri, 17:00]]'\nduration: '1h30m'\n", sw.toString())
    }

}