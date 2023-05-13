import { useEffect } from 'react' 
import { createEncryptedConnection, createUnencryptedConnection } from './chat' 

type Props = {
    roomId: string
    isEncrypted: boolean
}

export default function ChatRoom({ roomId, isEncrypted }: Props) {
    useEffect(() => {
        const createConnection = isEncrypted ?
            createEncryptedConnection :
            createUnencryptedConnection 
        const connection = createConnection(roomId) 
        connection.connect() 
        return () => connection.disconnect() 
    }, [roomId, isEncrypted]) 

    return <h1>Welcome to the {roomId} room!</h1> 
}
