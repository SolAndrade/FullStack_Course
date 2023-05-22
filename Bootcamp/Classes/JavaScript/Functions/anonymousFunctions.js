// Anonymous Functions

// Example:

const calcSum = function (a, b) {
    return a + b;
  };
  
  // Anonymous functions as other function’s arguments
  
  // Example 1:
  
  function printName(name, anonFunc) {
    anonFunc(name);
  }
  
  printName("sandra", function (name) {
    console.log(name[0].toUpperCase() + name.slice(1));
  });
  
  // => Sandra
  
  // Example 2:
  
  function getLength(str, anonFunc) {
    anonFunc(str);
  }
  
  getLength("aleksandra", function (str) {
    console.log(`${str} has ${str.length} letters.`);
  });
  
  // => aleksandra has 10 letters.
  
  getLength("nick", function (str) {
    console.log(`${str} has ${str.length} letters.`);
  });
  // => nick has 4 letters.
  
  // Very often, we will use anonymous functions as arguments in the setTimeout() JavaScript native method:
  
  setTimeout(function () {
    console.log("I am anonymous function and I will execute after 1 second.");
  }, 1000);
  
  // ... nothing happens for 1 second
  // => I am anonymous function and I will execute after 1 second.
  