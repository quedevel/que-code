import {useState} from "react";

export default function Form() {
    const [firstName, setFirstName] = useState<string>('')
    const [lastName, setLastName] = useState<string>('')

    function handleFirstNameChange(e: { target: { value: string; }; }) {
        setFirstName(e.target.value)
    }

    function handleLastNameChange(e: { target: { value: string; }; }) {
        setLastName(e.target.value)
    }

    function handleReset() {
        setFirstName('')
        setLastName('')
    }

    return (
        <form onSubmit={e => e.preventDefault()}>
            <input
                placeholder="First name"
                value={firstName}
                onChange={handleFirstNameChange}
            />
            <input
                placeholder="Last name"
                value={lastName}
                onChange={handleLastNameChange}
            />
            <h1>Hi, {firstName} {lastName}</h1>
            <button onClick={handleReset}>Reset</button>
        </form>
    );
}
