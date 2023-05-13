import React, { useState, useRef } from 'react';

export default function Chat() {
    const [text, setText] = useState<string>('');
    const textRef = useRef<string>(text);

    function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
        setText(e.target.value);
        textRef.current = e.target.value;
    }

    function handleSend() {
        setTimeout(() => {
            alert('Sending: ' + textRef.current);
        }, 3000);
    }

    return (
        <>
            <input
                value={text}
                onChange={handleChange}
            />
            <button
                onClick={handleSend}>
                Send
            </button>
        </>
    );
}
