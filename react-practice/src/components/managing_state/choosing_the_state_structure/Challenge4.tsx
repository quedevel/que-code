import { useState } from 'react';
import { letters } from './data';
import Letter from './LetterForm';

type SelectedIds = number[];

export default function MailClient() {
    const [selectedIds, setSelectedIds] = useState<SelectedIds>([]);

    const selectedCount = selectedIds.length;

    function handleToggle(toggledId: number) {
        // Was it previously selected?
        if (selectedIds.includes(toggledId)) {
            // Then remove this ID from the array.
            setSelectedIds(selectedIds.filter(id =>
                id !== toggledId
            ));
        } else {
            // Otherwise, add this ID to the array.
            setSelectedIds([
                ...selectedIds,
                toggledId
            ]);
        }
    }

    return (
        <>
            <h2>Inbox</h2>
            <ul>
                {letters.map(letter => (
                    <Letter
                        key={letter.id}
                        letter={letter}
                        isSelected={
                            selectedIds.includes(letter.id)
                        }
                        onToggle={handleToggle}
                    />
                ))}
                <hr />
                <p>
                    <b>
                        You selected {selectedCount} letters
                    </b>
                </p>
            </ul>
        </>
    );
}
