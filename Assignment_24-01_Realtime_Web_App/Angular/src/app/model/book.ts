export class Book {
    id: number;
    bookName: string;
    description: string;
    authorName: string;
    price: number;

    constructor(id, bookName, description, authorName, price) {
        this.id = id;
        this.bookName = bookName;
        this.description = description;
        this.authorName = authorName;
        this.price = price;
    }
}
