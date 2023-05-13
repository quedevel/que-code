import React, {useState} from 'react'
import {foods, filterItems, Food} from './data'

export default function FilterableList() {
    const [query, setQuery] = useState<string>('')
    const results = filterItems(foods, query)

    function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
        setQuery(e.target.value)
    }

    return (
        <>
            <SearchBar
                query={query}
                onChange={handleChange}
            />
            <hr />
            <List items={results} />
        </>
    )
}

type SearchProps = {
    query: string
    onChange: (e: React.ChangeEvent<HTMLInputElement>) => void
}

function SearchBar({ query, onChange }: SearchProps) {
    return (
        <label>
            Search:{' '}
            <input
                value={query}
                onChange={onChange}
            />
        </label>
    )
}

function List({ items }: {items: Food[]}) {
    return (
        <table>
            <tbody>
            {items.map(food => (
                <tr key={food.id}>
                    <td>{food.name}</td>
                    <td>{food.description}</td>
                </tr>
            ))}
            </tbody>
        </table>
    )
}
