
stations = new {st1: "MANabc;Manchester"; st2:"GNFgef;Greenfield"};

result = "";

for (st in stations) {
  input = stations[st];
  code = input.substring(0,3);
  semiC = input.indexOf(';');
  name = input.substring(semiC + 1, input.length);
  result = result + code + ': ' + name;
}