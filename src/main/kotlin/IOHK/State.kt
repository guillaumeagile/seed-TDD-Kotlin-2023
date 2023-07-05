package IOHK

sealed class State(val expectedCommiters: List<String>, val actualCommiters: List<String>) {
    fun onCommitObserved(userName: String): State {
        val newActualCommiters = actualCommiters.plus(userName)
        when {
            newActualCommiters.containsAll(expectedCommiters) -> return State.Open(this.expectedCommiters, newActualCommiters)
            else -> return State.Initial(this.expectedCommiters, newActualCommiters)
        }
    }


    class Open(expectedCommiters: List<String>, newActualCommiters: List<String>) : State(expectedCommiters, newActualCommiters) {}

    class Initial(expectedCommiters: List<String>, actualCommiters: List<String>) :
        State(expectedCommiters, actualCommiters) {}
}
