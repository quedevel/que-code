import { useState } from 'react';

type OnAddTodo = { onAddTodo: (title: string) => void };
export default function AddTodo({ onAddTodo }: OnAddTodo) {
    const [title, setTitle] = useState('');
    return (
        <>
            <input
                placeholder="Add todo"
                value={title}
                onChange={e => setTitle(e.target.value)}
            />
            <button onClick={() => {
                setTitle('');
                onAddTodo(title);
            }}>Add</button>
        </>
    )
}
