export type Item = {
  id: number
  title: string
  packed: boolean
}

export type Props = {
  items: Item[]
  onChangeItem: (nextItem: Item) => void
  onDeleteItem: (n: number) => void
}


export default function PackingList({
  items,
  onChangeItem,
  onDeleteItem
}: Props
) {
  return (
    <ul>
      {items.map(item => (
        <li key={item.id}>
          <label>
            <input
              type="checkbox"
              checked={item.packed}
              onChange={e => {
                onChangeItem({
                  ...item,
                  packed: e.target.checked
                })
              }}
            />
            {' '}
            {item.title}
          </label>
          <button onClick={() => onDeleteItem(item.id)}>
            Delete
          </button>
        </li>
      ))}
    </ul>
  )
}
