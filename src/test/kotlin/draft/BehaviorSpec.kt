package draft

import IOHK.HeadState
import IOHK.State
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.should
import io.kotest.matchers.types.beInstanceOf

class BehaviorSpec : BehaviorSpec({
    given("we have head") {
        val headState = HeadState(listOf("Alice", "Bob"))
        `when`("that we init") {
            val actualState = headState.initialize()
            then("it's initial") {
                actualState should beInstanceOf<State.Initial>()
            }

            `when`("we have observed a commit by Bob") {
                val afterBobState = actualState.onCommitObserved("Bob")
                then("it's still initial") {
                    afterBobState should beInstanceOf<State.Initial>()
                    afterBobState.actualCommiters shouldHaveSize 1
                }

                `when`("we have observed a commit by Alice") {
                    val afterAliceState = afterBobState.onCommitObserved("Alice")
                    then("it's open") {
                        afterAliceState.actualCommiters shouldHaveSize 2
                        afterAliceState should beInstanceOf<State.Open>()
                    }
                }
            }
        }
    }
})