import { useState } from 'react'
import ChatRoom from './ChatRoom'

export default function App() {
    const [isDark, setIsDark] = useState<boolean>(false)
    const [roomId, setRoomId] = useState<string>('general')
    const [serverUrl, setServerUrl] = useState<string>('https://localhost:1234')

    const options = {
        serverUrl: serverUrl,
        roomId: roomId
    }

    return (
        <div className={isDark ? 'dark' : 'light'}>
            <button onClick={() => setIsDark(!isDark)}>
                Toggle theme
            </button>
            <label>
                Server URL:{' '}
                <input
                    value={serverUrl}
                    onChange={e => setServerUrl(e.target.value)}/>
            </label>
            <label>
                Choose the chat room:{' '}
                <select
                    value={roomId}
                    onChange={e => setRoomId(e.target.value)}>
                    <option value="general">general</option>
                    <option value="travel">travel</option>
                    <option value="music">music</option>
                </select>
            </label>
            <hr />
            <ChatRoom options={options} />
        </div>
    )
}
