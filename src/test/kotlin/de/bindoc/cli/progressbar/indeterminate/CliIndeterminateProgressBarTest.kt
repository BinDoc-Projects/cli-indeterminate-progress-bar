package de.bindoc.cli.progressbar.indeterminate

import kotlin.test.Test


internal class CliIndeterminateProgressBarTest {

    @Test
    fun runProgressBar() {
        val progressBar = CliIndeterminateProgressBar("Test")
        progressBar.start()

        (0..100).forEach {
            progressBar.step(1)
            Thread.sleep(100)
        }

        progressBar.doStop()

    }

}