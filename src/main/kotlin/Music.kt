class Music(
    private var _uniqueIDNumber: Int,
    private var _title: String,
    private var _artist: String) {

    val uniqueIDNumber: Int = _uniqueIDNumber
    val title: String = _title
    val artist: String = _artist

    fun display(): String
    {
        return "ID: $uniqueIDNumber \nTitle: $title\nLead Actor: $artist"
    }
}