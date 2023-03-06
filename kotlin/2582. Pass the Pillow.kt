class Solution {
    fun passThePillow(n: Int, time: Int): Int {

        val mod = time % (2 * n - 2)
        return if (mod <= n - 1) 1 + mod else 2 * n - mod - 1

        // var t = 0
        // var res = 1
        // var sign = 1
        // while (t < time) {
        //     t++
        //     res += sign
        //     if (res == n || res == 1) sign = -sign
        // }
        // return res
    }
}