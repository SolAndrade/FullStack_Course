// ************************************
// ************ BOOLEAN ***************
// ************************************

// == compares just using value (loose or abstract equality)

let x = 5;
let y = "5";
console.log(`What is this: ${x == y}`); // What is this: true

// === compares using value and type (strict equality)

console.log(`What is this: ${x === y}`); // What is this: false

// falsy values - will evaluate as FALSE
// - false
// - 0
// - "" empty string
// - null
// - undefined
// NaN

// truthy values - will evaluate as TRUE
// true
// "0"
// "false"
// [] or {}
// 35 (any number)
// new Date()

if ("false") `Passed thingy is truthy`;
else `Passed thingy is falsy`; // => 'Passed thingy is truthy'
// true && true
// true && false
// !true
if (true || false) {
  console.log("sooo true");
} else {
  console.log("maybe not so true");
}

// ************************************
// ********* IMMUTABILITY *************
// ************************************

// All primitive data types are immutable - meaning, once primitives are created, they can't be modified.

// Example:
let city = "miami";
console.log(city[0]); // <== m
city[0] = "M"; // let's capitalize the first letter
console.log(city); // <== miami (it seems that the first letter is not capitalized after all
// since the primitive (string) can't be mutated

// Values are immutable but variables are mutable which means you can reassign them:

let city = "miami";
console.log(city); // <== miami

// we CAN re-assign our variable to another value
city = "berlin";
console.log(city); // <== berlin

// but still CAN NOT change the value "berlin"
city[0] = "B";
console.log(city); // <== berlin

// You can reassign the variable with a new value but you can't alter the existing value.
// Example with the string methods - each of them returns a new string and the original string stays untouched.

const message = "Don't be sad, be happy!";
console.log(message.slice(0, 3)); // <== Don
console.log(message); // <== Don't be sad, be happy!
