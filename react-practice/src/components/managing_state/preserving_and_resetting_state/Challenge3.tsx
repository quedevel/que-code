import { useState } from 'react'
import ContactList, {Contact} from './ContactList'
import EditContact from './EditContact'

export default function ContactManager() {
    const [
        contacts,
        setContacts
    ] = useState<Contact[]>(initialContacts)
    const [
        selectedId,
        setSelectedId
    ] = useState<number>(0)
    const selectedContact = contacts.find(c =>
        c.id === selectedId
    )

    function handleSave(updatedData: Contact) {
        const nextContacts = contacts.map(c => {
            if (c.id === updatedData.id) {
                return updatedData
            } else {
                return c
            }
        })
        setContacts(nextContacts)
    }

    return (
        <div>
            <ContactList
                contacts={contacts}
                selectedId={selectedId}
                onSelect={(id: number)=> setSelectedId(id)}
            />
            <hr />
            {selectedContact && (
                <EditContact
                    key={selectedId}
                    initialData={selectedContact}
                    onSave={handleSave}
                />
            )}
        </div>
    )
}

const initialContacts: Contact[] = [
    { id: 0, name: 'Taylor', email: 'taylor@mail.com' },
    { id: 1, name: 'Alice', email: 'alice@mail.com' },
    { id: 2, name: 'Bob', email: 'bob@mail.com' }
]
