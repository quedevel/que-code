export function getImageUrl(imageId: string, size: string = 's') {
    return (
        'https://i.imgur.com/' +
        imageId +
        size +
        '.jpg'
    );
}

export function getImageUrl2(person: Person, size: string) {
    return (
        'https://i.imgur.com/' +
        person.imageId +
        size +
        '.jpg'
    );
}

export interface Person {
    name: string
    imageId: string
}
