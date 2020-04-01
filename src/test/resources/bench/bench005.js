function propertyName(methodName){
    if(methodName.startsWith("is")){
        propertyName = methodName.substring("is".length, methodName.length);
    }else{
        if(methodName.startsWith("get")){
            propertyName = methodName.substring("get".length, methodName.length);
        }else{}
    }

    return propertyName.substring(0, 1).toLowerCase() + propertyName.substring(1, propertyName.length + 1);
}

x = propertyName("isRobbie");
y = propertyName("get123456");
z = propertyName("Bobby");