let str;
function longestString(strings) {
  if (strings.length == 0) {
    return false;
  }
  str = strings[0];
  for (let i = 1; i < strings.length; i++) {
    if (str.length < strings[i].length) {
      str = strings[i];
    }
  }
  return str;
}