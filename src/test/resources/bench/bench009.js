function parse(name){
    tid = new {};
    colonIndex = name.indexOf(":");
    if(colonIndex < 0){
        tid["outputIndex"] = 0;
        tid["name"] = name;
        return tid;
    }else{
        return "null";
    }
}

x = parse("123456");
y = parse(":Robbie");