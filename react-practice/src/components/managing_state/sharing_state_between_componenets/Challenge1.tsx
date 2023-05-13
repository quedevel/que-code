import { SetStateAction, useState} from 'react'

export default function SyncedInputs() {
    return (
        <>
            <Input label="First input"/>
            <Input label="Second input"/>
        </>
    )
}

function Input({label}: { label: string }) {
    const [text, setText] = useState('')

    function handleChange(e: { target: { value: SetStateAction<string> } }) {
        setText(e.target.value)
    }

    return (
        <label>
            {text}
            {' '}
            <input
                value={text}
                onChange={handleChange}
            />
        </label>
    )
}
