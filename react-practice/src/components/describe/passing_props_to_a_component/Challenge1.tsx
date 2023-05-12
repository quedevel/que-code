import { getImageUrl } from './utils';

interface Scientist {
    name: string
    imageId: string
    imageSize: number
    profession: string
    awards: Array<string>
    discovery: string
}

function Profile({
 name,
 imageId,
 imageSize = 70,
 profession,
 awards,
 discovery
}: Scientist) {
    return (
        <section className="profile">
            <h2>{name}</h2>
            <img
                className="avatar"
                src={getImageUrl(imageId)}
                alt={name}
                width={imageSize}
                height={imageSize}
            />
            <ul>
                <li><b>Profession:</b> {profession}</li>
                <li>
                    <b>Awards: {awards.length} </b>
                    ({awards.join(', ')})
                </li>
                <li>
                    <b>Discovered: </b>
                    {discovery}
                </li>
            </ul>
        </section>
    );
}

const scientists = [
    {
        name: "Maria Skłodowska-Curie",
        imageId: "szV5sdG",
        imageSize: 70,
        profession: 'physicist and chemist',
        awards: [
            'Nobel Prize in Physics',
            'Nobel Prize in Chemistry',
            'Davy Medal',
            'Matteucci Medal'
        ],
        discovery: 'polonium (chemical element)'
    },
    {
        name: "Katsuko Saruhashi",
        imageId: "YfeOqp2",
        imageSize: 70,
        profession: 'geochemist',
        awards: [
            'Miyake Prize for geochemistry',
            'Tanaka Prize'
        ],
        discovery: 'a method for measuring carbon dioxide in seawater'
    },
]

export default function Gallery() {
    return (
        <div>
            <h1>Notable Scientists</h1>
            {scientists.map((s:Scientist) =>
                <Profile
                    name={s.name}
                    imageId={s.imageId}
                    imageSize={s.imageSize}
                    profession={s.profession}
                    discovery={s.discovery}
                    awards={s.awards}
                />
            )}
        </div>
    );
}