const chai = require("chai");
const assert = chai.assert;
chai.config.truncateThreshold = 0;


describe('isEven(num)', () => {
  
  it('should return true if argument is an even number', () => {
    assert.equal(isEven(18), true);
  });
  
  it('should return false if the argument is an odd number.', () => {
    assert.equal(isEven(11),false);
  });
  
});