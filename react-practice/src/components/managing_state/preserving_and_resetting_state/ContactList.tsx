export type Contact = {
    id: number
    name: string
    email: string
}

type Props = {
    contacts: Contact[]
    selectedId: number
    onSelect: (n: number) => void
}

export default function ContactList({
    contacts,
    selectedId,
    onSelect
}: Props
) {
    return (
        <section>
            <ul>
                {contacts.map(contact =>
                    <li key={contact.id}>
                        <button onClick={() => {
                            onSelect(contact.id)
                        }}>
                            {contact.id === selectedId ?
                                <b>{contact.name}</b> :
                                contact.name
                            }
                        </button>
                    </li>
                )}
            </ul>
        </section>
    )
}
