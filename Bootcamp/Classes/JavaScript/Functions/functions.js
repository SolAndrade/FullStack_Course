function doStuff() {}

const doStuff = function () {};


// create => function declaration
function printCoffeePrice() {
    console.log("Coffee price is 5.");
  }
  
  // call => invocation
  printCoffeePrice();
  
  // -- return multiple values
  // functions can’t, by default, return multiple values. To surpass this limitation,
  // you can pack return values into an object or array and return it.
  
  // --- returns packed in the object
  function getUser() {
    // info could come from an API
  
    const name = "ana";
    const age = "32";
  
    return {
      name,
      age,
    };
  }
  const userInfo = getUser();
  console.log(`${userInfo.name}, ${userInfo.age} years`); // ana, 32 years
  
  // function declaration (statement)
  function welcomeMessage(message) {
    return message;
  }
  
  // function assigned to a variable
  const greeting = welcomeMessage("So nice to have you here! Welcome!");
  
  console.log(greeting); // So nice to have you here! Welcome!
  
  // function expression - is a function without name stored in a variable
  const welcomeMessage = function (message) {
    console.log(message);
  };
  
  welcomeMessage("So nice to have you here! Welcome!");
  // => So nice to have you here! Welcome!
  
  // Function declaration vs. function expression
  
  // A function declaration is a named function and can be stored in a variable if needed (example with greeting).
  // A function expression is an un-named (or so-called anonymous) function that is stored in the variable.
  // Both can be reused throughout the code.
  
  // function declaration (statement)
  
  checkFuncDeclaration(); // => Func declaration CAN be invoked before it's defined.
  
  function checkFuncDeclaration() {
    console.log("Func declaration CAN be invoked before it is defined.");
  }
  
  // function expression
  
  checkFuncExpression(); // => ReferenceError: checkFuncExpression is not defined
  
  const checkFuncExpression = function () {
    console.log("Func expression CAN NOT be invoked before it is defined.");
  };
  
  // Hoisting
  
  // Function declarations get hoisted (lift) to the top of the code before any other code gets executed.
  // That is why we can call them before we declare them.
  
  //Function expressions are treated as variables and don't get hoisted. The code execution is line by line.
  // That is why we can't call them before we declare them.
  