
let player1 = {
    "dice":0,
    "score": 0,
    "winInARow": 0,
}

let player2 = {
    "dice":0,
    "score": 0,
    "winInARow": 0,
}

const game = (player1, player2) => {
    player1.dice = Math.ceil(Math.random() * 20);
    player2.dice = Math.ceil(Math.random() * 20);

    if (player1.dice > player2.dice) {
        console.log("player1 = gagne")
        player1.winInARow += 1
        player2.winInARow = 0
        if (player1.winInARow >= 2)
            player1.score+=1
    }
    else  {
        console.log("player2 = gagne")
        player2.winInARow += 1
        player1.winInARow = 0
        if (player2.winInARow >= 2)
            player2.score += 1
    }
}

while (player1.score < 11 && player2.score < 11) {
    game(player1, player2);
}

console.log("player1.score = "+ player1.score)
console.log("player2.score = "+ player2.score)



