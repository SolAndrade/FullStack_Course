// We will be working on the following array:

const arr = [1, 2, 3];
console.log(`original: ${arr}`); // original: 1,2,3

// `.forEach()` return "undefined"

const newArr = arr.forEach((el) => el * 3);
console.log(newArr); // undefined

// If we want to double each number in the `arr` without making changes to it, we have to create a new empty array and push changed elements in it:

const someNewArr = [];
arr.forEach((el) => someNewArr.push(el * 2));
console.log(`forEach-pushed: ${someNewArr}`); // forEach-pushed: 2,4,6

// If we want for any reason to mutate the original array:

arr.forEach((el, i) => (arr[i] = el * 2));
console.log(`forEach-mutated: ${arr}`); // forEach-mutated: 2,4,6

// Example with using `.map()`

// The only proper way of going through an array and making changes to it without actually changing the original array is using `.map()`:

const updatedArr = arr.map((el) => el * 2);
console.log(`mapped: ${updatedArr}`); // mapped: 4,8,12

// In case you are wondering how we got 4, 8, and 12, remember we mutated the original array earlier.
