package IOHK


class HeadState( val awaitedCommiters : List<String>) {
    fun initialize(): State = State.Initial(this.awaitedCommiters, emptyList())
}
