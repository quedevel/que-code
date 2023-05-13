import React from "react"

type ItemProps = {
    name: string
    importance: number
}

function Item({ name, importance }: ItemProps) {
    return (
        <li className="item">
            {name} {importance > 0 && '(Importance: '+importance+')'}
        </li>
    )
}

export default function PackingList() {
    return (
        <section>
            <h1>Sally Ride's Packing List</h1>
            <ul>
                <Item
                    importance={9}
                    name="Space suit"
                />
                <Item
                    importance={0}
                    name="Helmet with a golden leaf"
                />
                <Item
                    importance={6}
                    name="Photo of Tam"
                />
            </ul>
        </section>
    )
}
