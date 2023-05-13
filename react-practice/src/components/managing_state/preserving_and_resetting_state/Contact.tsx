import { useState } from 'react'

type Contact = {
    id: number
    name: string
    email: string
}

export default function Contact({ contact }: {contact: Contact}) {
    const [expanded, setExpanded] = useState(false)
    return (
        <>
            <p><b>{contact.name}</b></p>
            {expanded &&
                <p><i>{contact.email}</i></p>
            }
            <button onClick={() => {
                setExpanded(!expanded)
            }}>
                {expanded ? 'Hide' : 'Show'} email
            </button>
        </>
    )
}
