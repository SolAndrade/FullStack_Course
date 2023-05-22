// 3 ways to create strings:
// double (""), single quotes ('') and backticks (``)

// backticks (``) --> template literals: strings that allow us to embed expressions in them

let name = "Ana";
console.log(`Hello there, ${name}!`);
// ==> Hello there, Ana!

console.log(`${name} has ${22 + 12} years.`);
// ==> Ana has 34 years.

const str = "this is our test string";

// console.log(`This is the first letter: ${str[0]}`);
// the same as above ^^^^
// console.log("This is the first letter:", str[0]);

// ********************
// string methods
// ********************

console.log(`${student.toUpperCase()}`); // MARCOS

//    check if the string includes a substring or character:

// .includes() // returns true or false
// .indexOf() // returns the position where a specific character is found or
// if it's not found returns -1 (false)

const bootcamp = "web dev";

console.log(bootcamp.includes("web")); // true
console.log(bootcamp.includes(" web")); // false

console.log("where is it on the string: ", bootcamp.indexOf("dev")); // 4

console.log("where is it on the string: ", bootcamp.indexOf("hello")); // -1

// -------------------------------------------------------------------------------------

//    access character in the string .charAt(index)

console.log("the first letter is: ", bootcamp[0]); // w

console.log("the first letter is: ", bootcamp.charAt(0)); // w
console.log("the first letter is: ", bootcamp.charAt(4)); // d

// -------------------------------------------------------------------------------------

//    .substring(start, end) // end is not inclusive
//    .substr(start, how-many-from-the-start)
//    .slice(start, end) - and can accept negative numbers (counts from the last index)

let str = "this is our test string";

let substring1 = str.substring(5, 10); // we count from 0
console.log(substring1); // is ou ==> the last is not included, meaning the "end" is not inclusive
let substring2 = str.substring(5, 11);
console.log(substring2); // is our

let substring3 = str.substring(-10, 5); // negative number is zero for substring(), so this is the same as (0, 5)
console.log("substring3: ", substring3); // this

let useSubstring2 = str.substring(5); // from this position till the end of the string if we don't pass the end value
console.log(`What if we pass only start to substring: ${useSubstring2}`); // What if we pass only start to substring: is our test

// --------------------------------------------------------

let substr1 = str.substr(5, 11);

console.log(substr1); // is our test

let slicedString1 = str.slice(5, 10);
console.log("sliced string: ", slicedString1); // is ou

let slicedString2 = str.slice(-5);
console.log(slicedString2); // tring

// **************************************************
// - substring's parameters are reversible, as it will always use its smallest
//   parameter value as the start index and largest value as the stop index.
// - substring will treat a negative start index as 0.
// - slice extracts from the end of the string if the starting index is negative.
// **************************************************

// -------------------------------------------------------------------------------------

//    startsWith() method - determines whether a string begins with the characters of a specified string,
// returns true or false as appropriate

//    endsWith() method - determines whether a string ends with the characters of a specified string
// returns true or false as appropriate. It’s also case-sensitive.

console.log("does string start with 'this': ", str.startsWith("this")); // does string start with 'this':  true

console.log("does string end with 'hello': ", str.endsWith("hello")); // does string end with 'hello':  false

// the same as above ^^^^
// console.log("This is the first letter:" + str[0]);

str[0] = "T";
console.log(`Is string changed: ${str}`); // Is string changed: this is our test string

let num = 3;
console.log(typeof num);
num += 11; // num = num + 11 // number
console.log(`num 1: ${num}`); // 14

num = "3"; // now our num is type of string so math operations will "fail"
console.log(typeof num); // string

// adding to a string => concatenation
num += "11"; // num = num + 11 => string
console.log(`Num 2: ${num}`); // 311

// length is not a method
console.log(`How long is this string: ${str.length}`); // 23
