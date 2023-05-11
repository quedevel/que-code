import React from "react"

interface Product {
    title: string
    isFruit: boolean
    id: number
}

const products: Product[] = [
    { title: 'Cabbage', isFruit: false, id: 1 },
    { title: 'Garlic', isFruit: false, id: 2 },
    { title: 'Apple', isFruit: true, id: 3 },
]

export default function ShoppingList(){
    const listItems = products.map((product: Product) =>
        <li
            key={product.id}
            style={{
                color: product.isFruit ? 'magenta' : 'darkgreen'
            }}
        >
            {product.title}
        </li>
    )

    return (
        <ul>{listItems}</ul>
    )
}