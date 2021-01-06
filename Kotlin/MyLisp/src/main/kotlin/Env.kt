import java.lang.Exception

//class Env(env: Env = null){
//class Env(topEnv: Env?){
class Env{
    constructor()

    constructor(topEnv: Env){
        this.topEnv = topEnv
    }

//    constructor(topEnv: Env?) : this(
//        this.topEnv = topEnv
//    )

    //    var env = arrayListOf<Pair<String, Any>>()
    private var env = mutableMapOf<String, Any>()
    private var topEnv:Env? = null

//    fun copy(): Env {
//        var env = Env()
//        env.env = this.env.clone() as ArrayList<Pair<String, Any>>
//        return env
//    }

    fun extend(key: String, value: Any) {
//        env.add(Pair(key, value))
        if (this.env[key] == null){
            env[key] = value
        }
        else{
            throw Exception("the value of $key already exist!")
        }
    }

    fun lookup(key: String): Any {
//        var pair = env.last { pair -> pair.first == key }
//        return pair.second
        if (this.env[key] != null) {
            return this.env[key]!!
        }
        else{
            var value = this.topEnv?.lookup(key)
            var error = "the value of $key already exist!"
//            guard(value,error);
            guardValue(value, error)
            return value!!
            /*
            if (value != null){
                return value
            }
            else{
                throw Exception("the value of $key already exist!")
            }
            */
        }

    }
}