import React, {useState} from "react"
import Board from "./Board"

export default function Game() {
    const [history, setHistory] = useState<any>([Array(9).fill(null)])
    const [currentMove, setCurrentMove] = useState<number>(0)
    const xIsNext = currentMove % 2 === 0
    const currentSquares = history[currentMove]

    const handlePlay = (nextSquares: any) => {
        const nextHistory = [...history.slice(0, currentMove + 1), nextSquares]
        setHistory(nextHistory)
        setCurrentMove(nextHistory.length - 1)
    }


    const jumpTo = (nextMove: number) => {
        setCurrentMove(nextMove)
    }

    const moves = history.map((squares: Array<string|null>, move: number) => {
        let description
        if (move > 0) {
            description = 'Go to move #' + move
        } else {
            description = 'Go to game start'
        }
        return (
            <li key={move}>
                <button onClick={() => jumpTo(move)}>{description}</button>
            </li>
        )
    })

    return (
        <div className="game">
            <div className="game-board">
                <Board xIsNext={xIsNext} squares={currentSquares} onPlay={handlePlay} />
            </div>
            <div className="game-info">
                <ol>{moves}</ol>
            </div>
        </div>
    )
}