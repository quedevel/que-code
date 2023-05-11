import React from 'react';

interface MyButtonProps{
    count: number
    onClick: () => void
}

export default function MyButton({ count, onClick }: MyButtonProps) {
    return (
        <button onClick={onClick}>
            Clicked {count} times
        </button>
    );
}