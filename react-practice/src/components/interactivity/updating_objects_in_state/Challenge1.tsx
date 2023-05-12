import React, { useState } from 'react';

type Player = {
    firstName: string;
    lastName: string;
    score: number;
}

export default function Scoreboard() {
    const [player, setPlayer] = useState<Player>({
        firstName: 'Ranjani',
        lastName: 'Shettar',
        score: 10,
    });

    function handlePlusClick() {
        setPlayer({
            ...player,
            score: player.score + 1
        })
    }

    function handleFirstNameChange(e: React.ChangeEvent<HTMLInputElement>) {
        setPlayer({
            ...player,
            firstName: e.target.value,
        });
    }

    function handleLastNameChange(e: React.ChangeEvent<HTMLInputElement>) {
        setPlayer({
            ...player,
            lastName: e.target.value
        });
    }

    return (
        <>
            <label>
                Score: <b>{player.score}</b>
                {' '}
                <button onClick={handlePlusClick}>
                    +1
                </button>
            </label>
            <label>
                First name:
                <input
                    value={player.firstName}
                    onChange={handleFirstNameChange}
                />
            </label>
            <label>
                Last name:
                <input
                    value={player.lastName}
                    onChange={handleLastNameChange}
                />
            </label>
        </>
    );
}
