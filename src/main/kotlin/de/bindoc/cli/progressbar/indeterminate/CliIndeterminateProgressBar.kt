package de.bindoc.cli.progressbar.indeterminate

class CliIndeterminateProgressBar(
    var statusMessage: String = "",
    private var startNumber: Int = 0
) : Thread() {

    private var run: Boolean = true
    private var animationCycle: Int = 0

    fun step(number: Int) {
        startNumber += number
    }

    fun doStop() {
        run = false
    }

    override fun run() {
        while (run) {
            printBar()
            sleep(50)
        }
    }

    private fun printBar() {
        val anim = animationCycle / 20
        val animation = animations[anim] ?: "[   ]"
        animationCycle++
        if (animationCycle >= (animations.size * 20)) {
            animationCycle = 0
        }
        val bar = "$animation - $startNumber - [$statusMessage]"
        print("$bar\r")
    }

    companion object {
        private val animations = arrayOf(
            "[ \\ ]",
            "[ | ]",
            "[ / ]",
            "[ - ]"
        )
    }
}

