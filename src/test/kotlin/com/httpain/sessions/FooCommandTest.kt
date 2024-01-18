package com.httpain.sessions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import picocli.CommandLine
import java.io.PrintWriter
import java.io.StringWriter

class FooCommandTest {

    @Test
    fun `should foo`() {
        val app = FooCommand()
        val cmd = CommandLine(app)

        val sw = StringWriter()
        cmd.out = PrintWriter(sw)

        val exitCode = cmd.execute("-b", "baz cux", "-d", "36000")
        assertEquals(0, exitCode)
        assertEquals("bar: 'baz cux'\nduration: '18us'\n", sw.toString())
    }

}