import { useState } from 'react';

const initialProducts = [{
    id: 0,
    name: 'Baklava',
    count: 1,
}, {
    id: 1,
    name: 'Cheese',
    count: 5,
}, {
    id: 2,
    name: 'Spaghetti',
    count: 2,
}];

type Product = {
    id: number
    name: string
    count: number
}

export default function ShoppingCart() {
    const [
        products,
        setProducts
    ] = useState(initialProducts)

    function handleIncreaseClick(productId: number) {
        setProducts(products.map((product: Product) => {
            return product.id !== productId? product : { ...product, count: product.count+1 }
        }))
    }

    function handleDecreaseClick(productId: number) {
        let productList = products.map((product: Product) => {
            return product.id !== productId? product : { ...product, count: product.count-1 }
        });
        setProducts(productList.filter(p => p.count > 0))
    }

    return (
        <ul>
            {products.map(product => (
                <li key={product.id}>
                    {product.name}
                    {' '}
                    (<b>{product.count}</b>)
                    <button onClick={() => {
                        handleIncreaseClick(product.id);
                    }}>
                        +
                    </button>
                    <button onClick={() => {
                        handleDecreaseClick(product.id);
                    }}>
                        –
                    </button>
                </li>
            ))}
        </ul>
    );
}
