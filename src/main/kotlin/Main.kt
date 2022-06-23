import java.util.Scanner

var availableMovies = mutableListOf<Movie>(
    Movie(101,"Titanic","Leonardo DiCaprio"),
    Movie(105,"The Lord of the Rings: the Turn of the King","Elijah Wood"),
    Movie(121,"Forrest Gump","Tom Hanks"),
    Movie(124,"Back to the Future","Michael J. Fox"),
    Movie(139,"The Avengers","Robert Downey Jr.")
)


var availableMusic = mutableListOf<Music>(
    Music(230,"Blinding Light","The Weeknd"),
    Music(215,"Good 4 U","Olivia Rodrigo"),
    Music(214,"Memories","Maroon 5"),
    Music(257,"Riptide","Vance Joy"),
    Music(273,"Enemy","Imagine Dragons")
)


var availableBooks = mutableListOf<Book>(
    Book(335,"Pride and Prejudice","Jane Austen"),
    Book(317,"The Princess Bride","William Goldman"),
    Book(103,"The Great Gatsby","F. Scott Fitzgerald"),
    Book(104,"1984","George Orwell"),
    Book(105,"The Outsiders","S. E. Hinton")
)

var rentedMovies = mutableListOf<Movie>()
var rentedMusic = mutableListOf<Music>()
var rentedBooks = mutableListOf<Book>()


fun getWelcome(): String {
    var option: String
    do {
        println("Welcome!\n What would you like to rent?\n [M] Movies \n [MU] Music \n [B] Books \n [Q] Quit")
        option = readln()
    } while (!option.equals("M", true) && !option.equals("MU", true) && !option.equals("B", true) && !option.equals("Q",
            true))
    return option.uppercase()
}

fun renting(selection: String) {
    val type: String = if(selection == "M") ("movies") else if(selection == "MU") ("music") else("books")
    var option: String
    do {
        println("Currently renting: $type \n Please select from the following: \n [R]Rent \n [V]View rented items \n " +
                "[Q] Quit")
        option = readln()
    } while (!option.equals("R", true) && !option.equals("V", true) && !option.equals("Q", true))
    when(option.uppercase())
    {
        "R" -> {
            when (selection){
                "M" -> {
                    println("Here are all the available movies: ")
                    for(m in availableMovies)
                        println("\n"+m.display()+"\n__________")

                    confirmation(selection)
                }
                "MU" -> {
                    println("Here are all the available music: ")
                    for(mu in availableMusic)
                        println("\n"+mu.display()+"\n__________")
                    confirmation(selection)
                }
                "B" -> {
                    println("Here are all the available books: ")
                    for(b in availableBooks)
                        println("\n"+b.display()+"\n__________")
                    confirmation(selection)
                }
            }
        }
        "V" -> viewRentedItems(selection)
    }

}

fun confirmation(selection: String){

    val scan = Scanner(System.`in`)
    var validChoice = false
    var movieChoice: Movie? = null
    var musicChoice: Music? = null
    var bookChoice: Book? = null
    var index: Int = 0
    do{
        println("What would you like to rent (enter ID)?")
        val input: Int = scan.nextInt()
        when(selection){
            "M" ->{
                for(i in 0 until availableMovies.size)
                {
                    if(availableMovies[i].uniqueIDNumber == input) {
                        println("found")
                        validChoice = true
                        movieChoice = availableMovies[i]
                        index = i
                        break
                    }

                }

            }
            "MU" ->{
                for(i in 0 until availableMusic.size)
                {
                    if(availableMusic[i].uniqueIDNumber == input) {
                        validChoice = true
                        musicChoice = availableMusic[i]
                        index = i
                        break
                    }

                }

            }
            "B" ->{
                for(i in 0 until availableBooks.size)
                {
                    if(availableBooks[i].uniqueIDNumber == input) {
                        validChoice = true
                        bookChoice = availableBooks[i]
                        index = i
                        break
                    }

                }

            }
        }
    } while(!validChoice)

    when(selection) {
        "M" -> {
            var choice: String
            do {
                if (movieChoice != null) {
                    println("Please confirm that you are renting the following (y/n):\n " + movieChoice.display())
                }
                choice = readln()
            } while (!choice.equals("y", true) && !choice.equals("n", true))

            if (choice == "y") {
                availableMovies.removeAt(index)
                if (movieChoice != null) {
                    rentedMovies.add(movieChoice)
                }
                println("Rented Successfully!")

            }
        }
        "MU" -> {
            var choice: String
            do {
                if (musicChoice != null) {
                    println("Please confirm that you are renting the following (y/n):\n " + musicChoice.display())
                }
                choice = readln()
            } while (!choice.equals("y", true) && !choice.equals("n", true))

            if (choice == "y") {
                availableMusic.removeAt(index)
                if (musicChoice != null) {
                    rentedMusic.add(musicChoice)
                }
                println("Rented Successfully!")

            }
        }
        "B" ->{
            var choice: String
            do {
                if (bookChoice != null) {
                    println("Please confirm that you are renting the following (y/n):\n " + bookChoice.display())
                }
                choice = readln()
            } while (!choice.equals("y", true) && !choice.equals("n", true))

            if (choice == "y") {
                availableBooks.removeAt(index)
                if (bookChoice != null) {
                    rentedBooks.add(bookChoice)
                }
                println("Rented Successfully!")

            }
        }
    }


}

fun viewRentedItems(selection: String){

    if(selection == "M"){
        if(rentedMovies.size == 0)
        {
            println("You have not any rented movies")
        }
        else {
            println("You've already rented the following: ")
            for (m in rentedMovies)
                println(m.display())
        }
    }
    else if(selection == "MU"){
        if(rentedMusic.size == 0)
        {
            println("You have not rented music")
        }
        else {
            println("You've already rented the following: ")
        for(mu in rentedMusic)
            println(mu.display())
            }
    }
    else{
        if(rentedBooks.size == 0)
        {
            println("You have not rented books")
        }
        else {
            println("You've already rented the following: ")
            for (b in rentedBooks)
                println(b.display())
        }
    }
    println("\nPress anything to continue")
    readln()
}

fun main(args: Array<String>) {
    var quit = false
    do {
        when(getWelcome())
        {
            "M" -> {
                renting("M")

            }
            "MU" -> {
                renting("MU")

            }
            "B" -> {
                renting("B")

            }
            "Q" -> quit = true

        }
    } while(!quit)

}
//yo it's me fatou :D'
// 10/10!!
//it works?? It works!! - Fatou
//Spencer is here!
//Hello!