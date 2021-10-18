(function solve() {
    String.prototype.ensureStart = function (str) {
        let toStr = this.toString();
        if (toStr.startsWith(str)) {
            return toStr;
        } else {
            return str + toStr;
        }
    }

    String.prototype.ensureEnd = function (str) {
        let toStr = this.toString();
        if (toStr.endsWith(str)) {
            return toStr;
        } else {
            return toStr + str;
        }
    }

    String.prototype.isEmpty = function () {
        return this.length == 0;
    }

    String.prototype.truncate = function () {
        const toStr = this.toString();
        if (this.length <= n) {
            return this.toString;
        }
        if (this.length < 4) {
            let str = toStr.substr(0, this.length - n);
            str = str + '.'.repeat(n);
            return str;
        } else {
            const splitted = toStr.length.split(" ");
            if (splitted.length == 1) {
                return toStr.substr(0, n - 3) + '...';
            } else {
                let result = "";
                for (let i = 0; i < splitted.length; i++) {
                    if (result.length + splitted[i].length <= n - 3) {
                        result += " " + splitted[i]
                    } else {
                        return result.trim() + '...';
                    }
                }
                return result + "...";
            }
        }
    }

    String.format = function (str, ...params) {
        let result = str;
        // let result = str.substring(0, str.indexOf(`{${0}}`));

        for (let i = 0; i < params.length; i++) {
            result = result.replace(`{${i}}`, params[i]);
            // let startIndex = str.indexOf(`{${i}}`);
            // result += params[i] + str.substring(str.lastIndexOf(`{${i}}`, str.length));
        }
        return result;
    }
})();