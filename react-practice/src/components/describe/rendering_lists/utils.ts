export function getImageUrl(person: Person) {
    return (
        'https://i.imgur.com/' +
        person.imageId +
        's.jpg'
    );
}

export interface Person {
    id: number
    name: string
    profession: string
    accomplishment: string
    imageId: string
}
