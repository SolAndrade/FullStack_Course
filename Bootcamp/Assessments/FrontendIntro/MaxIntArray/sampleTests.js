const chai = require("chai");
const assert = chai.assert;
chai.config.truncateThreshold = 0;

describe('maxOfArray(numbers)', () => {
  
  it('should return the greatest number from the given array of numbers.', () => {
    assert.equal( maxOfArray( [1, 200, 100, 44] ), 200);
  });
  
  it('should return false when argument is an empty array', () => {
    assert.equal( maxOfArray( [] ), false);
  });
});
  