type Props = {
    color: string
    time: string
}

export default function Clock(props: Props) {
    return (
        <h1 style={{ color: props.color }}>
            {props.time}
        </h1>
    );
}
