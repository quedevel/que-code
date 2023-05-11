import React, {useState} from "react"
import SearchBar from "./SearchBar"
import ProductTable from "./ProductTable"
import Product from "./interface/Product"

interface Props {
    products: Product[]
}

export default function FilterableProductTable({ products }: Props) {
    const [filterText, setFilterText] = useState<string>('')
    const [inStockOnly, setInStockOnly] = useState<boolean>(false)

    return (
        <div>
            <SearchBar
                filterText={filterText}
                inStockOnly={inStockOnly}
                onFilterTextChange={setFilterText}
                onInStockOnlyChange={setInStockOnly} />
            <ProductTable
                products={products}
                filterText={filterText}
                inStockOnly={inStockOnly} />
        </div>
    )
}