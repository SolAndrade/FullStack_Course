// Before

hello = function () {
    return "Hello World!";
  };

  // After

hello = () => {
    return "Hello World!";
  };

  // Arrow Functions

// function expression syntax
const greeting = function (name) {
    console.log(`Hello, ${name}!`);
  };
  
  // arrow function syntax
  const greeting = (name) => {
    return name;
  };
  
  // If we have only one return we can remove the return statement
  const greeting = (name) => `Hello, ${name}!`;
  
  // In case no parameters
  const greeting = () => console.log("Hello there!");
  