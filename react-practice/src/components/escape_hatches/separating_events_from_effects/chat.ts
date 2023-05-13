export function createConnection(serverUrl: string, roomId: string) {
    // A real implementation would actually connect to the server
    return {
        connect() {
            console.log('✅ Connecting to "' + roomId + '" room at ' + serverUrl + '...')
        },
        disconnect() {
            console.log('❌ Disconnected from "' + roomId + '" room at ' + serverUrl)
        }
    }
}

export function createEncryptedConnection(roomId: string) {
    // A real implementation would actually connect to the server
    return {
        connect() {
            console.log('✅ 🔐 Connecting to "' + roomId + '... (encrypted)');
        },
        disconnect() {
            console.log('❌ 🔐 Disconnected from "' + roomId + '" room (encrypted)');
        }
    };
}

export function createUnencryptedConnection(roomId: string) {
    // A real implementation would actually connect to the server
    return {
        connect() {
            console.log('✅ Connecting to "' + roomId + '... (unencrypted)');
        },
        disconnect() {
            console.log('❌ Disconnected from "' + roomId + '" room (unencrypted)');
        }
    };
}

