class Movie(
    private var _uniqueIDNumber: Int,
    private var _title: String,
    private var _leadActor: String) {

    val uniqueIDNumber: Int = _uniqueIDNumber
    val title: String = _title
    val leadActor: String = _leadActor

    fun display(): String
    {
        return "ID: $uniqueIDNumber \nTitle: $title\nLead Actor: $leadActor"
    }

    }

