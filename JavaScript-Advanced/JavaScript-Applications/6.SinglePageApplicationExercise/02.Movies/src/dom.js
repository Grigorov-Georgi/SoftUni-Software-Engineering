const main = document.querySelector('main');

export function showView(section){
    main.replaceChildren(section);
}

export function e(type, attributes, ...content) {
    const result = document.createElement(type);

    for (let [attr, value] of Object.entries(attributes || {})) {
        if (attr.substring(0, 2) == 'on') {
            result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
        } else if (attr === 'class') {
            value.split(' ').filter(x => x !== '').forEach(x => result.classList.add(x));

        } else {
            result[attr] = value;
        }
    }

    content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

    content.forEach(e => {
        if (typeof e == 'string' || typeof e == 'number') {
            const node = document.createTextNode(e);
            result.appendChild(node);
        } else {
            result.appendChild(e);
        }
    });

    return result;
}

// export function e(type, attributes, ...content) {
//     const result = document.createElement(type);

//     for (let [attr, value] of Object.entries(attributes || {})) {
//         if(attr.substring(0, 2) == 'on'){
//             result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);    
//         } else {
//             result[attr] = value;        }
//     }

//     content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

//     content.forEach(e => {
//         if(typeof e == 'string' || typeof e == 'number'){
//             const node = document.createTextNode(e);
//             result.appendChild(node);
//         } else {
//             result.appendChild(e);
//         }
//     });

//     return result
// }