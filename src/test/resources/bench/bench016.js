/**
 * Site: Useful string methods - Mozilla
 */

function fixCapitalization(input){
    result = "";
    for (c in cities) {
        lower = input[c].toLowerCase();
        firstLetter = lower.slice(0, 1);
        firstLetter = firstLetter.toUpperCase();
        result = result + firstLetter + lower.substring(1, lower.length) + ", ";
    }

    return result.substring(0, result.length - 2);
}

cities = new {city1: "lonDon"; city2: "ManCHESTer"};
x = fixCapitalization(cities);