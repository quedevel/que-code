import { JSX } from "react/jsx-runtime";

const poem = {
    lines: [
        'I write, erase, rewrite',
        'Erase again, and then',
        'A poppy blooms.'
    ]
};

export default function Poem() {

    let wrappedLines: JSX.Element[] = []

    poem.lines.forEach((line: string, index: number) => {
        wrappedLines.push(
            <p key={index}>
                {line}
            </p>
        )

        wrappedLines.push( <hr /> )
    });

    return (
        <article>
            {wrappedLines.slice(0, poem.lines.length + poem.lines.length-1)}
        </article>
    );
}

