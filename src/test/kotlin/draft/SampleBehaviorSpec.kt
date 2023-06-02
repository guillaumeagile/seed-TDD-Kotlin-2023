package draft

import io.kotest.core.spec.style.BehaviorSpec

class SampleBehaviorSpec : BehaviorSpec({
    given("une rame de papier qui coute 10EUR") {
        `when`("je commande 101 rames") {
            then("je paye un total avec une remise de 5%") {
                // test code
            }
        }
    }
})