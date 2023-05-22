// Functions can be passed as parameters (arguments) to other functions. In that case, we are talking about callbacks.

// Callback functions are used to make sure a particular code doesn’t execute until another code has already finished execution.

function eatDinner() {
    console.log("Eating the dinner!");
  }
  
  function eatDessert() {
    console.log("Eating the dessert!");
  }
  
  eatDinner(); // <== Eating the dinner!
  eatDessert(); // <== Eating the dessert!
  
  // Code is executed line by line, then how is it possible for a function to execute before another?
  
  // Delayed execution of one of the functions
  
  function eatDinner() {
    setTimeout(function () {
      console.log("Eating the dinner!");
    }, 1000);
  }
  
  function eatDessert() {
    console.log("Eating the dessert!");
  }
  
  eatDinner();
  eatDessert();
  
  // the console:
  // Eating the dessert!
  // Eating dinner!
  
  // Callbacks
  
  // When invoking a function with a callback, make sure not to use () when it comes to the callback function.
  
  function eatDinner(callback) {
    // the word "callback" is just a placeholder
    // you can use any other word
    console.log("Eating the dinner!");
    callback();
  }
  
  function eatDessert() {
    console.log("Eating the dessert!");
  }
  
  eatDinner(eatDessert); // <== make sure when invoking callback func NOT tu use ()
  
  // Eating dinner!
  // Eating the dessert!
  