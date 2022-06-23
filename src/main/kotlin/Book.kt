class Book(
    private val _uniqueIDNumber: Int,
    private val _title: String,
    private val _author: String) {

    val uniqueIDNumber: Int = _uniqueIDNumber
    val title: String = _title
    val author: String = _author

    fun display(): String
    {
        return "ID: $uniqueIDNumber \nTitle: $title\nLead Actor: $author"
    }
}