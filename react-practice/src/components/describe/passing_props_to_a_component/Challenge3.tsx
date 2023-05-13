import React, {ReactNode} from "react"

interface CardProps {
    children: ReactNode
}

function Card({ children }: CardProps) {
    return (
        <div className="card">
            <div className="card-content">
                {children}
            </div>
        </div>
    )
}

export default function Profile() {
    return (
        <div>
            <Card>
                <h1>Photo</h1>
                <img
                    className="avatar"
                    src="https://i.imgur.com/OKS67lhm.jpg"
                    alt="Aklilu Lemma"
                    width={100}
                    height={100}
                />
            </Card>
            <Card>
                <h1>About</h1>
                <p>Aklilu Lemma was a distinguished Ethiopian scientist who discovered a natural treatment to schistosomiasis.</p>
            </Card>
        </div>
    )
}