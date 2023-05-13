import { useState } from 'react';

type Contact = {
    id: number;
    name: string;
    email: string;
}


export default function EditContact(props: EditProps) {
    return (
        <EditForm
            {...props}
            key={props.savedContact.id}
        />
    );
}

type EditProps = {
    savedContact: Contact;
    onSave: (updatedData: Contact) => void;
    onReset: () => void;
}

function EditForm({ savedContact, onSave }: EditProps) {
    const [name, setName] = useState(savedContact.name);
    const [email, setEmail] = useState(savedContact.email);

    return (
        <section>
            <label>
                Name:{' '}
                <input
                    type="text"
                    value={name}
                    onChange={e => setName(e.target.value)}
                />
            </label>
            <label>
                Email:{' '}
                <input
                    type="email"
                    value={email}
                    onChange={e => setEmail(e.target.value)}
                />
            </label>
            <button onClick={() => {
                const updatedData = {
                    id: savedContact.id,
                    name: name,
                    email: email
                };
                onSave(updatedData);
            }}>
                Save
            </button>
            <button onClick={() => {
                setName(savedContact.name);
                setEmail(savedContact.email);
            }}>
                Reset
            </button>
        </section>
    );
}
