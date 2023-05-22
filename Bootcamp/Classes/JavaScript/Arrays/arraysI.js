// ******************************************************************************************
// PART 1 (DECLARATION, INDEX, ADD, REMOVE)
// ******************************************************************************************

// EXAMPLES OF ARRAYS
const animals = ["dog", "cat", "fish"];
const mixedArr = [
  3,
  "fish",
  true,
  [],
  { name: "sandra" },
  "",
  null,
  ["table", "chair"],
];

// arrays are zero-indexed
// arrays have the "length" property. it equals (index + 1)

// ADD elements to array
// .push() adds elements to the end of the array - mutates the original array

animals.push("tiger");
console.log(animals); // [ 'dog', 'cat', 'fish', 'tiger' ]

// .unshift() adds elements to the beginning of the array  - mutates the original array

animals.unshift("monkey");
console.log(animals); // [ 'monkey', 'dog', 'cat', 'fish', 'tiger' ]

// inserts an element at a specified index
animals.splice(2, 0, "horse");
console.log(animals); // [ 'monkey', 'dog', 'horse', 'cat', 'fish', 'tiger' ]

// ADD some and REMOVE some
animals.splice(3, 2, "lion"); // removes cat and fish and replaces them with lion
console.log(animals); // [ 'monkey', 'dog', 'horse', 'lion', 'tiger' ]

// REMOVE elements from array
// .splice() remove element at specified index  - mutates the original array
animals.splice(2, 1);
console.log(animals); // [ 'monkey', 'dog', 'lion', 'tiger' ]

// .pop() - remove last element - mutates the original array
animals.pop();
console.log(animals); // [ 'monkey', 'dog', 'lion' ]

// shift() - remove the first elem - mutates the original array
animals.shift();
console.log(animals); // [ 'dog', 'lion' ]
