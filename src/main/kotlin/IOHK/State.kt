package IOHK

sealed class State(val expectedCommiters: List<String>, val actualCommiters: List<String>) {
    open fun onCommitObserved(userName: String): State {
        val newActualCommiters = actualCommiters.plus(userName)
        when {
            newActualCommiters.containsAll(expectedCommiters) -> return State.Open(
                this.expectedCommiters,
                newActualCommiters
            )

            else -> return State.Initial(this.expectedCommiters, newActualCommiters)
        }
    }

    class Initial(expectedCommiters: List<String>, actualCommiters: List<String>) :
        State(expectedCommiters, actualCommiters) {}

    class Open(expectedCommiters: List<String>, actualCommiters: List<String>) :
        State(expectedCommiters, actualCommiters) {
        override fun onCommitObserved(userName: String): State {
            if (expectedCommiters.contains(userName))
                return UnfairUsage(this.expectedCommiters, this.actualCommiters)
            return Open(this.expectedCommiters, this.actualCommiters)
        }
    }

    class UnfairUsage(expectedCommiters: List<String>, actualCommiters: List<String>) :
        State(expectedCommiters, actualCommiters) {
        override fun onCommitObserved(userName: String): State {
                return UnfairUsage(this.expectedCommiters, this.actualCommiters)
        }
    }


}
