import { useState } from 'react'

export default function EditProfile() {
    const [isEditing, setIsEditing] = useState<boolean>(false)
    const [firstName, setFirstName] = useState<string>('Jane')
    const [lastName, setLastName] = useState<string>('Jacobs')

    return (
        <form onSubmit={e => {
            e.preventDefault()
            setIsEditing(!isEditing)}}>
            <label>
                First name:{' '}
                {isEditing ? (
                    <input
                        value={firstName}
                        onChange={e => {
                            setFirstName(e.target.value)
                        }}
                    />
                ) : (
                    <b>{firstName}</b>
                )}
            </label>
            <label>
                Last name:{' '}
                {isEditing ? (
                    <input
                        value={lastName}
                        onChange={e => {
                            setLastName(e.target.value)
                        }}
                    />
                ) : (
                    <b>{lastName}</b>
                )}
            </label>
            <button type="submit">
                {isEditing ? 'Save' : 'Edit'} Profile
            </button>
            <p><i>Hello, {firstName} {lastName}!</i></p>
        </form>
    )
}
