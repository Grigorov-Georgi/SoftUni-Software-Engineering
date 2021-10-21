class Story {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this._comments = [];
        this._likes = [];
    }

    get likes() {
        if (this._likes.length == 0) {
            return `${this.title} has 0 likes`
        } else if (this._likes.length == 1) {
            return `${this._likes[0]} likes this story!`
        }
        return `${this._likes[0]} and ${this._likes.length - 1} others like this story!`
    }


    like(username) {
        if (this._likes.includes(username)) {
            throw new Error(`You can't like the same story twice!`);
        }
        if (this.creator == username) {
            throw new Error(`You can't like your own story!`)
        }
        this._likes.push(username);
        return `${username} liked ${this.title}!`
    }

    dislike(username) {
        if (this._likes.includes(username)) {
            this._likes.splice(this._likes.indexOf(username), 1);
            return `${username} disliked ${this.title}`
        } else {
            throw new Error(`You can't dislike this story!`);
        }
    }

    comment(username, content, id) {
        let comment = this._comments.find(x => x.id == id);
        if (!comment) {
            comment = {
                id: this._comments.length + 1,
                username,
                content,
                replies: [],
            }
            this._comments.push(comment);
            return `${username} commented on ${this.title}`;
        } else {
            let replay = {
                id: comment.replies.length + 1,
                username,
                content,
            }
            comment.replies.push(replay);
            return `You replied successfully`;
        }
    }

    toString(sortingType) {
        switch (sortingType) {
            case 'asc':
                this._comments.sort((a, b) => a.id - b.id);
                this._comments.forEach(c => c.replies.sort((a, b) => a.id - b.id));
                break;
            case 'desc':
                this._comments.sort((a, b) => b.id - a.id);
                this._comments.forEach(c => c.replies.sort((a, b) => b.id - a.id));
                break;
            case 'username':
                this._comments.sort((a, b) => a.username.localeCompare(b.username));
                this._comments.forEach(c => c.replies.sort((a, b) => a.username.localeCompare(b.username)));
                break;
        }
        let result = [];
        result.push(`Title: ${this.title}`);
        result.push(`Creator: ${this.creator}`);
        result.push(`Likes: ${this._likes.length}`);
        result.push(`Comments:`);

        if(this._comments.length == 0){
             return result.join('\n');
        } else {
            for(let comment of this._comments){
                result.push(`-- ${comment.id}. ${comment.username}: ${comment.content}`);
                for(let reply of comment.replies){
                    result.push(`--- ${comment.id}.${reply.id}. ${reply.username}: ${reply.content}`);
                }
            }
        }
        return result.join('\n');
    }
}

let art = new Story("My Story", "Anny");
art.like("John");
console.log(art.likes);
art.dislike("John");
console.log(art.likes);
art.comment("Sammy", "Some Content");
console.log(art.comment("Ammy", "New Content"));
art.comment("Zane", "Reply", 1);
art.comment("Jessy", "Nice :)");
console.log(art.comment("SAmmy", "Reply@", 1));
console.log()
console.log(art.toString('username'));
console.log()
art.like("Zane");
console.log(art.toString('desc'));
