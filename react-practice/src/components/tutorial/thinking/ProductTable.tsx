import React from "react"
import ProductRow from "./ProductRow"
import ProductCategoryRow from "./ProductCategoryRow"
import Product from "./interface/Product"

type ProductTableProps = {
    products: Array<Product>
    filterText: string
    inStockOnly: boolean
}

export default function ProductTable({ products, filterText, inStockOnly }: ProductTableProps) {
    const rows: React.ReactNode[] = []
    let lastCategory: string | null = null

    products.forEach((product) => {
        if (
            product.name.toLowerCase().indexOf(
                filterText.toLowerCase()
            ) === -1
        ) {
            return
        }
        if (inStockOnly && !product.stocked) {
            return
        }
        if (product.category !== lastCategory) {
            rows.push(
                <ProductCategoryRow
                    category={product.category}
                    key={product.category} />
            )
        }
        rows.push(
            <ProductRow
                product={product}
                key={product.name} />
        )
        lastCategory = product.category
    })

    return (
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>{rows}</tbody>
        </table>
    )
}