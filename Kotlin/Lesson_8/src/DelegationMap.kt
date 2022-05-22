class DelegationMap (private val map: HashMap<String, Int?> = hashMapOf()) :
    Map<String, Int?> by map{
    var tempPair: Pair<String, Int?>? = null
        private set

    override fun get(key: String): Int? {
        tempPair = key to map[key]
        return map.remove(key)
    }

    fun put(key: String, value: Int?){
        map[key] = value
    }
}