import { useState } from 'react'

type Props = {
    onAddItem: (title: string) => void
}

export default function AddItem({ onAddItem }: Props) {
    const [title, setTitle] = useState<string>('')
    return (
        <>
            <input
                placeholder="Add item"
                value={title}
                onChange={e => setTitle(e.target.value)}
            />
            <button onClick={() => {
                setTitle('')
                onAddItem(title)
            }}>Add</button>
        </>
    )
}
