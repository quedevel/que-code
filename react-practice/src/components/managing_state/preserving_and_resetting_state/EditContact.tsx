import { useState } from 'react';
import { Contact } from "./ContactList";

type Props = {
    initialData: Contact;
    onSave: (data: Contact) => void;
};

export default function EditContact({ initialData, onSave }: Props) {
    const [name, setName] = useState<string>(initialData.name);
    const [email, setEmail] = useState<string>(initialData.email);

    return (
        <section>
            <label>
                Name:{' '}
                <input
                    type="text"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
            </label>
            <label>
                Email:{' '}
                <input
                    type="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
            </label>
            <button
                onClick={() => {
                    const updatedData: Contact = {
                        id: initialData.id,
                        name: name,
                        email: email,
                    };
                    onSave(updatedData);
                }}
            >
                Save
            </button>
            <button
                onClick={() => {
                    setName(initialData.name);
                    setEmail(initialData.email);
                }}
            >
                Reset
            </button>
        </section>
    );
}
