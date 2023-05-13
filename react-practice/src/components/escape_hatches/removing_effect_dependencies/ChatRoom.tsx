import { useEffect } from 'react'
import { createConnection } from './chat'

type Props = {
    options: {
        roomId: string
        serverUrl: string
    }
}

export default function ChatRoom({ options }: Props) {
    const { roomId, serverUrl } = options
    useEffect(() => {
        const connection = createConnection({
            roomId: roomId,
            serverUrl: serverUrl
        })
        connection.connect()
        return () => connection.disconnect()
    }, [roomId, serverUrl])

    return <h1>Welcome to the {options.roomId} room!</h1>
}
