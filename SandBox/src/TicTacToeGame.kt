fun main() {
    val ticTacToe = TicTacToe()
    ticTacToe.getInfo()
    while (!ticTacToe.isEndedGame)
        ticTacToe.play()
}

class TicTacToe {
    private val ox = charArrayOf('o', 'x')
    private val fields = CharArray(9){' '}

    private var user: Char = ' '
    private var computer: Char = ' '

    var isEndedGame = false

    fun getInfo(){
        user = ox[(0..1).random()]
        println("You're $user")
        computer = if (user != ox[0]) ox[0] else ox[1]
        println("Computer $computer")
    }

    fun play(){
        if (user == 'x'){
            printField(isEndedGame)

            insertUserOX()
            checkField(user)

            insertComputerOX()
            checkField(computer)
        } else {
            insertComputerOX()
            checkField(computer)

            printField(isEndedGame)

            insertUserOX()
            checkField(user)
        }
    }

    private fun printField(isWin: Boolean){
        if (!isWin){
            println("""
        ${fields[0]}|${fields[1]}|${fields[2]}
        -----
        ${fields[3]}|${fields[4]}|${fields[5]}
        -----
        ${fields[6]}|${fields[7]}|${fields[8]}
        """)
        }
    }

    private fun insertUserOX(){
        if (!isEndedGame){
            do {
                var position: Int
                do {
                    print("Enter positions number: ")
                    position = readLine()?.toIntOrNull() ?: 0
                } while (position !in 1..9)

                if (fields[position - 1] == ' '){
                    fields[position - 1] = user
                    break
                }
            } while (true)
        }
    }

    private fun insertComputerOX(){
        if (!isEndedGame){
            do {
                val position: Int = (1..9).random()

                if (fields[position - 1] == ' '){
                    fields[position - 1] = computer
                    break
                }
            } while (true)
        }
    }

    private fun checkField(ox: Char){
        if (!isEndedGame){
            if (fields[0] == ox && fields[1] == ox && fields[2] == ox ||
                fields[3] == ox && fields[4] == ox && fields[5] == ox ||
                fields[6] == ox && fields[7] == ox && fields[8] == ox ||
                fields[0] == ox && fields[3] == ox && fields[6] == ox ||
                fields[1] == ox && fields[4] == ox && fields[7] == ox ||
                fields[2] == ox && fields[5] == ox && fields[8] == ox ||
                fields[0] == ox && fields[4] == ox && fields[8] == ox ||
                fields[2] == ox && fields[4] == ox && fields[6] == ox){
                println("${if (ox == user) "User" else "Computer"} is Win!")
                isEndedGame = true
                getEpicWin(ox)
            } else if (' ' !in fields){
                println("Nothing won! Fields is over!")
                isEndedGame = true
            }
        }
    }

    private fun getEpicWin(winnerSymbol: Char){
        for (i in fields.indices)
            if (fields[i] == winnerSymbol)
                fields[i] = winnerSymbol.toUpperCase()
        printField(false)
    }
}