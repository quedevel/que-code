import React from "react"

interface Props {
    category: string
}

export default function ProductCategoryRow({ category }: Props) {
    return (
        <tr>
            <th colSpan={2}>
                {category}
            </th>
        </tr>
    )
}