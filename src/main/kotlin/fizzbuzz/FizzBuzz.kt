package fizzbuzz

class FizzBuzz {
    companion object {
        fun eval(nombre: Int): String {
            if (nombre % 3 == 0)
                return "Fizz"
            return nombre.toString()
        }
    }
}
