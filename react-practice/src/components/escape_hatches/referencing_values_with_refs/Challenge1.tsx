import { useState, useRef } from 'react' 

export default function Chat() {
    const [text, setText] = useState<string>('') 
    const [isSending, setIsSending] = useState<boolean>(false) 
    const timeoutRef = useRef<NodeJS.Timeout | null>(null) 

    function handleSend() {
        setIsSending(true) 
        timeoutRef.current = setTimeout(() => {
            alert('Sent!') 
            setIsSending(false) 
        }, 3000) 
    }

    function handleUndo() {
        setIsSending(false) 
        if (timeoutRef.current) clearTimeout(timeoutRef.current) 
    }

    return (
        <>
            <input
                disabled={isSending}
                value={text}
                onChange={e => setText(e.target.value)}
            />
            <button
                disabled={isSending}
                onClick={handleSend}>
                {isSending ? 'Sending...' : 'Send'}
            </button>
            {isSending &&
                <button onClick={handleUndo}>
                    Undo
                </button>
            }
        </>
    ) 
}
