// We will be working on the following array:

const numbers = [3, 7, 9, 10, 12];

// Let's use .filter() to extract the numbers that are divisible with 3.

const filteredArr = numbers.filter((num) => {
  if (num % 3 === 0) return num;
});
// filteredArr: 3,9,12

// and in one line, this would look like:

const filteredArr2 = numbers.filter((num) => num % 3 === 0);
// filteredArr2: 3,9,12

// Remember, anything we use the array methods for (map, reduce, filter, ...) can be done using for loop or .forEach() method. Let's see what is under the hood of the .filter() method:

const filtered = [];
for (const num of numbers) {
  if (num % 3 === 0) filtered.push(num);
}

console.log(`filtered: ${filtered}`); // filtered: 3,9,12

// in one line:

const filtered2 = [];
numbers.forEach((num) => (num % 3 === 0 ? filtered2.push(num) : null));

console.log(`filtered2: ${filtered2}`); // filtered2: 3,9,12
