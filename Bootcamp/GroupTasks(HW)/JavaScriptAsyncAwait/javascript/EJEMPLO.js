const directions = [
    "Starting point: Ironhack Miami",
    "↑ Head east on SW 8th St/Carlos Arboleya toward SW 1st Avenue",
    "➔ Turn right onto S Miami Ave",
    "* Chipotle Mexican Grill 891 S Miami Ave, Miami",
  ];
  
  // function getDirections(step, callback, errorCallback) {
  //   setTimeout(() => {
  //     console.log(directions[step]);
    
  //     if (!directions[step]) errorCallback("Instructions not found.");
  //     else callback();
  //   }, 2000);
  // }
  
  
  // getDirections(0, () => {
  //   getDirections(1, () => {
  //     getDirections(2, () => {
  //       getDirections(3, () => {        
  //         console.log("You arrived at your destination!");
  //       }, (err) => console.log(err));
  //     }, (err) => console.log(err));
  //   }, (err) => console.log(err));
  // }, (err) => console.log(err))
  
  
  
  function obtainDirections(step) {
    return new Promise(function (resolve, reject) {
      setTimeout(() => {
        console.log(directions[step]);
    
        if (!directions[step]) reject("Instructions not found.");
        else resolve();
      }, 2000);
    });
  }
  
  
  // obtainDirections(0)
  //   .then(() => obtainDirections(1))
  //   .then(() => obtainDirections(2))
  //   .then(() => obtainDirections(3))
  //   .then(() => console.log("You arrived at your destination!"))
  //   .catch((err) => console.log(err));
  
  
  // async function getCoffee() {
  //   try {
  //     await obtainDirections(0);
  //     await obtainDirections(1);
  //     await obtainDirections(2);
  //     await obtainDirections(3);
  //     console.log("You arrived at your destination!");
  //   } catch (e) {
  //     console.log("Error: ", e);
  //   }
  // }
  
  // getCoffee();
  
  
  
  // fetch("https://pokeapi.co/api/v2/pokemon/")
  //   .then(response => response.json())
  //   .then(data => console.log(data))
  //   .catch((e) => console.log(e))
  
  
  let data;
  
  async function getPokemon() {
    try {
      const response = await fetch("https://pokeapi.co/api/v2/pokemon/");
      data = await response.json();
      console.log(data.results);
    } catch (e) {
      console.log("Error: ", e);
    }
  }
  
  getPokemon();