type Props = {
    onChangeColor: () => void
}

export default function ColorSwitch({ onChangeColor }: Props) {
    return (
        <button onClick={e => {
            e.stopPropagation()
            onChangeColor();
        }}>
            Change color
        </button>
    );
}
