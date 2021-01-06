package forJava

class Env {
    var env = arrayListOf<Pair<String, Any>>()

    fun copy(): Env {
        var env = Env()
        env.env = this.env.clone() as ArrayList<Pair<String, Any>>
        return env
    }

    fun extend(key: String, value: Any) {
        env.add(Pair(key, value))
    }

    fun lookup(key: String): Any {
        var pair = env.last { pair -> pair.first == key }
        return pair.second
    }
}