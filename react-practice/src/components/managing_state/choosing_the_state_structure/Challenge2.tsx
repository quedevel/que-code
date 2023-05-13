import { useState } from 'react';
import AddItem from './AddItem';
import PackingList, { Item } from './PackingList';

let nextId = 3;
const initialItems: Item[] = [
    { id: 0, title: 'Warm socks', packed: true },
    { id: 1, title: 'Travel journal', packed: false },
    { id: 2, title: 'Watercolors', packed: false },
];

export default function TravelPlan() {
    const [items, setItems] = useState<Item[]>(initialItems);

    const total = items.length;
    const packed = items.filter((item: Item) => item.packed).length;

    function handleAddItem(title: string) {
        setItems([
            ...items,
            {
                id: nextId++,
                title: title,
                packed: false,
            },
        ]);
    }

    function handleChangeItem(nextItem: Item) {
        setItems(
            items.map((item) => {
                if (item.id === nextItem.id) {
                    return nextItem;
                } else {
                    return item;
                }
            })
        );
    }

    function handleDeleteItem(itemId: number) {
        setItems(items.filter((item) => item.id !== itemId));
    }

    return (
        <>
            <AddItem onAddItem={handleAddItem} />
            <PackingList
                items={items}
                onChangeItem={handleChangeItem}
                onDeleteItem={handleDeleteItem}
            />
            <hr />
            <b>
                {packed} out of {total} packed!
            </b>
        </>
    );
}
