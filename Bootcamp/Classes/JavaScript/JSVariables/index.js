
// 3 ways to declare variables in JS:
// var
// let
// const

let student; // var. declaration (saving a spot in memory)
console.log("Value is: ", student); // Value is:  undefined
student = "kevin"; // var. assignment (initialization) - giving it a value

let firstName = "sandra"; // declaration and initialization in the same time

//  can't name it with a number starting nor with JS reserved words:
// let 3students 
// class, let, const, function, for, ... 

// multiple var. declarations
let price, tax, total;

// use camelCase (but if you want to use snake_case is OK, just be consistent)
let totalPrice // camelCase
let total_amount // snake_case

let name; // lowercase
// let Name; 

// this is a single-line comment
/* this is
multiple lines
comment */

// numbers are immutable data types - can't change their value, you are creating a new variable with the same name
price = 7;
price = 9;

// double quotes combined with single quotes (string)
let pizza = "margherita is 'the best' ";
console.log(pizza); // ==> margherita is 'the best'

// "const" is used when declaring a variable whose value will be constant.
// if we try to change its values we will get the error back

const name = 'Ana';
name = 'Marina';

// console:
// unknown: "name" is read-only

// Using "let" we can only declare a variable without assigning it a value. That is not the case with "const".
// Variable needs to be declared and initialized at the same time.

let name; // <== we can do this

const price; // <== error

// JavaScript is a dynamically typed language and that means new variables are created at runtime,
//and the type of variables is determined at runtime.

// You can reassign values and change the data type of variables in JavaScript.

let favoriteFood;

favoriteFood = 'Steak';
console.log('Value: ', favoriteFood, ' Type: ', typeof favoriteFood);

// The type will get determined automatically while the program is being processed
favoriteFood = 20;
console.log('Value: ', favoriteFood, ' Type: ', typeof favoriteFood);
