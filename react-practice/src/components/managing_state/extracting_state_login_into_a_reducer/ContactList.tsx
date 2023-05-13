import { ChangedSelectionAction } from './messengerReducer';

export type Contact = {
    id: number;
    name: string;
    email: string;
};

type Props = {
    contacts: Contact[];
    selectedId: number;
    dispatch: (action: ChangedSelectionAction) => void;
};

export default function ContactList({ contacts, selectedId, dispatch }: Props) {
    return (
        <section className="contact-list">
            <ul>
                {contacts.map((contact) => (
                    <li key={contact.id}>
                        <button
                            onClick={() => {
                                dispatch({
                                    type: 'changed_selection',
                                    contactId: contact.id,
                                });
                            }}
                        >
                            {selectedId === contact.id ? <b>{contact.name}</b> : contact.name}
                        </button>
                    </li>
                ))}
            </ul>
        </section>
    );
}
