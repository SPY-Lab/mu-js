function parseHost(input){
    input = input.trim();
    input = input.toLowerCase();
    if (!input.startsWith("https://")){
        return "null";
    }else{
        input = input.substring(8, input.length);
        if(input.charAt(0) == "["){
            return "null";
        }else{
            if(!input.startsWith("www.")){
                return "null";
            }else{
                if(input.endsWith(".it")){
                    domain = input.substring(4, input.length - 3);
                    object = new {a: "https"; b: "www"; c: domain; d: ".it"};
                    return object;
                }else{
                    return "null";
                }
            }
        }
    }
}

//parse dei primi 3 domini .it che usano https
function parseFirstDomain(s){
    while(true){
        if(s.length == 0){
            return "null";
        }else{
            index = s.indexOf("\n");
            if(index == -1){
                sub = s.substring(0, s.length);
                s = "";
            }else{
                sub = s.substring(0, index);
                s = s.substring(index + 1, s.length);
            }
            result = parseHost(sub);
            if(! result == "null"){
                return result;
            }else{}
        }

    }

    return "null";
}

x = parseFirstDomain("https://google.it\na");