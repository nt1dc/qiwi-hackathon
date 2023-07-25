package command

import api.ValCurs

interface Executable {
    fun execute(valuteCurs: ValCurs)
}