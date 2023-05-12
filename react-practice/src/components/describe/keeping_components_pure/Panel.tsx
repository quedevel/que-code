import {ReactNode, useState} from 'react';

type PanelProps = {
    children: ReactNode;
}

export default function Panel({ children }: PanelProps) {
    const [open, setOpen] = useState(true);
    return (
        <section className="panel">
            <button onClick={() => setOpen(!open)}>
                {open ? 'Collapse' : 'Expand'}
            </button>
            {open && children}
        </section>
    );
}