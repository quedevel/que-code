import React, { useState } from 'react';

export default function Form() {
    const [showForm, setShowForm] = useState<boolean>(true);
    const [message, setMessage] = useState<string>('');

    const handleSubmit = (e: React.ChangeEvent<HTMLFormElement>) => {
        e.preventDefault();
        setShowForm(false);
        sendMessage(message);
    }

    if (!showForm) {
        return (
            <>
                <h1>Thanks for using our services!</h1>
                <button onClick={() => {
                    setMessage('');
                    setShowForm(true);
                }}>
                    Open chat
                </button>
            </>
        );
    }

    return (
        <form onSubmit={handleSubmit}>
            <textarea
              placeholder="Message"
              value={message}
              onChange={e => setMessage(e.target.value)}
            />
            <button type="submit" disabled={message === ''}>
                Send
            </button>
        </form>
    );
}

function sendMessage(message: string) {
    console.log('Sending message: ' + message);
}
