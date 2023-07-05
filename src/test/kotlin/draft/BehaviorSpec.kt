package draft

import IOHK.HeadState
import IOHK.State
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.should
import io.kotest.matchers.types.beInstanceOf

class BehaviorSpec : BehaviorSpec({
    given("a head") {
        val headState = HeadState(awaitedCommiters = listOf("Alice", "Bob"))
        `when`("we init it") {
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

                    `when`("we have observed a commit by Zoe") {
                        val afterZoeState = afterAliceState.onCommitObserved("Zoe")
                        then("it hasn't changed") {
                            afterZoeState.actualCommiters shouldHaveSize 2
                            afterZoeState should beInstanceOf<State.Open>()
                        }

                        `when`("we have observed a 2nd commit by Alice") {
                            val afterAliceUnfairState = afterZoeState.onCommitObserved("Alice")
                            then("it's not fair") {
                                afterAliceUnfairState.actualCommiters shouldHaveSize 2
                                afterAliceUnfairState should beInstanceOf<State.UnfairUsage>()
                            }

                            `when`("unfair is a dead end, any commit can happen") {
                                val stillAliceUnfairState = afterAliceUnfairState.onCommitObserved("Zoe")
                                then("it's still not fair") {
                                    stillAliceUnfairState.actualCommiters shouldHaveSize 2
                                    stillAliceUnfairState should beInstanceOf<State.UnfairUsage>()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
})