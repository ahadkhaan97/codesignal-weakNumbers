fun main() {
    print(solution(7))
}

fun solution(n: Int): MutableList<Int> {
    val divisorMap = HashMap<Int, Int>()
    val weaknessMap = HashMap<Int, Int>()
    for (i in 1 until n + 1) {
        divisorMap[i] = getDivisors(i)
        weaknessMap[i] = getWeakness(divisorMap, divisorMap[i] ?: 0)
    }

    var max = -1

    weaknessMap.forEach {
        if (it.value > max)
            max = it.value
    }

    val tempList = mutableListOf<Int>()
    tempList.add(max)
    var count = 0
    weaknessMap.forEach {
        if (it.value == max) {
            count++
        }
    }
    tempList.add(count)
    return tempList
}

fun getWeakness(weaknessMap: HashMap<Int, Int>, i: Int): Int {
    var weakness = 0
    weaknessMap.forEach {
        if (it.value > i)
            weakness++
    }
    return weakness
}

fun getDivisors(n: Int): Int {
    var divisors = 0
    for (i in 1 until n + 1) {
        if (n % i == 0)
            divisors++
    }
    return divisors
}