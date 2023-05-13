import React, { useState, useCallback } from 'react';

type DebouncedButtonProps = {
    onClick: () => void;
    children: React.ReactNode;
};

function DebouncedButton({ onClick, children }: DebouncedButtonProps) {
    const [timeoutID, setTimeoutID] = useState<NodeJS.Timeout | null>(null);

    const handleClick = useCallback(() => {
        if (timeoutID) {
            clearTimeout(timeoutID);
        }
        const newTimeoutID = setTimeout(() => {
            onClick();
        }, 1000);
        setTimeoutID(newTimeoutID);
    }, [onClick, timeoutID]);

    return <button onClick={handleClick}>{children}</button>;
}

export default function Dashboard() {
    return (
        <>
            <DebouncedButton onClick={() => alert('Spaceship launched!')}>
                Launch the spaceship
            </DebouncedButton>
            <DebouncedButton onClick={() => alert('Soup boiled!')}>
                Boil the soup
            </DebouncedButton>
            <DebouncedButton onClick={() => alert('Lullaby sung!')}>
                Sing a lullaby
            </DebouncedButton>
        </>
    );
}
